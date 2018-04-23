package DAL;

import BL.Entities.LicenseTypeForTruck;

import java.sql.*;
import BL.Entities.LicenseTypeForTruck;

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

    public static void removeLicense(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Licenses WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    //retrieves a list with all the licenses allowed for the given truck
    public static LicenseTypeForTruck retrieveLicense(String licenseId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Licenses WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, licenseId);
            ResultSet rs = stmt.executeQuery();
            String model = rs.getString("TRUCK_MODEL");
            LicenseTypeForTruck license = new LicenseTypeForTruck(licenseId, model);
            conn.close();
            return license;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void updateLicense(LicenseTypeForTruck l) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "UPDATE Licenses SET TRUCK_MODEL = ? WHERE LICENSE_ID = ?  ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, l.getTruckModel());
        stmt.setString(2, l.getLicenseType());
        stmt.executeUpdate();
        conn.close();
    }

    public static LicenseTypeForTruck isLicenseExist(String id) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "SELECT * FROM License WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        LicenseTypeForTruck l = createLicense(rs);
        conn.close();
        return l;
    }

    public static LicenseTypeForTruck createLicense(ResultSet rs) throws SQLException {
        if (!rs.isBeforeFirst()) //not exists
            return null;
        String id = rs.getString("LICENSE_ID");
        String model = rs.getString("TRUCK_MODEL");
        return new LicenseTypeForTruck(id, model);
    }
}
