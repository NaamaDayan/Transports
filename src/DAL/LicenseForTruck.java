package DAL;

import BL.Entities.LicenseTypeForTruck;
import BL.Entities.TruckModel;
import BL.EntitiyFunctions.ModelFunctions;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Naama on 20/04/2018.
 */
public class LicenseForTruck {

    public static void insertLicense(TruckModel truckModel, String licenseId){
        try (Connection conn = Utils.openConnection()) {
            String query = "INSERT INTO Licenses VALUES (?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, licenseId);
            stmt.setString(2, truckModel.getId());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void removeLicense(String id){
        try (Connection conn = Utils.openConnection()) {
            String query = "DELETE FROM Licenses WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static LicenseTypeForTruck retrieveLicense(String licenseId){
        try (Connection conn = Utils.openConnection()) {
            String query = "SELECT * FROM Licenses WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, licenseId);
            ResultSet rs = stmt.executeQuery();
            LicenseTypeForTruck license = null;
            if (rs.isBeforeFirst()) {
                String model = rs.getString("TRUCK_MODEL");
                TruckModel returned = ModelFunctions.retrieveModel(model); //exists because otherwise the License
                                                                            // itself wouldn't be existed
                license = new LicenseTypeForTruck(licenseId, returned);
            }
            conn.close();
            return license;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public static void updateLicense(LicenseTypeForTruck l) throws SQLException, ClassNotFoundException {
        Connection conn = Utils.openConnection();
        String query = "UPDATE Licenses SET TRUCK_MODEL = ? WHERE ID = ?  ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, l.getTruckModel().getId());
        stmt.setString(2, l.getLicenseType());
        stmt.executeUpdate();
        conn.close();
    }
}
