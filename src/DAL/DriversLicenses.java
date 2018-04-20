package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

    public static void removeTruck(String driverId ,String licenseId){
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

}
