package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
