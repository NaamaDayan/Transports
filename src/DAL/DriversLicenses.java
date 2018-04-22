package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DriversLicenses {

    public static void insertDriverLicense(String driverId, String licenseId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO LicensesForDrivers VALUES (?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, driverId);
            stmt.setString(2, licenseId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removeDriverLicense(String driverId ,String licenseId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM LicensesForDrivers WHERE DRIVER_ID = ? AND LICENSE_TYPE = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, driverId);
            stmt.setString(2, licenseId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    //returns a list of all the licenses of a driver
    public static List<String> retrieveDriverLicenses(String driverId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM LicensesForDrivers WHERE DRIVER_ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, driverId);
            ResultSet rs = stmt.executeQuery();
            List<String> licenses = new LinkedList<>();
            while(rs.next())
                licenses.add(rs.getString("LICENSE_TYPE"));
            conn.close();
            return licenses;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }



}
