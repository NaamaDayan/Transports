package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Naama on 20/04/2018.
 */
public class LicenseForTruck {

    public static void insertLicense(String truckModel, String licenseId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Licenses VALUES (?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, licenseId);
            stmt.setString(2, truckModel);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removeLicense(String truckModel ,String licenseId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Licenses WHERE LICENSE_TYPE = ? AND TRUCK_MODEL = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, licenseId);
            stmt.setString(2, truckModel);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    //retrieves a list with all the licenses allowd for the given truck
    public static List<String> retrieveTruckLicenses(String truckModel){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Licenses WHERE TRUCK_MODEL = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, truckModel);
            ResultSet rs = stmt.executeQuery();
            List<String> licenses = new LinkedList<>();
            do{
                licenses.add(rs.getString("LICENSE_TYPE"));
            }
            while (rs.next());
            conn.close();
            return licenses;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
