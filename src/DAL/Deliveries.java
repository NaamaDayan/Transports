package DAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Deliveries{

    public static void insertDeivery(String id, java.sql.Date date, String orderId, String truckId, String driverId, String sourceId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Deliveries VALUES (?,?,?,?,?,?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setDate(2, date);
            stmt.setString(3, orderId);
            stmt.setString(4, truckId);
            stmt.setString(5, driverId);
            stmt.setString(6, sourceId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removeDelivery(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Deliveries WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateTruckIdDelivery(String deliveryId, String field){
        updateStringFieldDelivery(deliveryId, field, "TRUCK_ID");
    }
    public static void updateDriverIdDelivery(String deliveryId, String field){
        updateStringFieldDelivery(deliveryId, field, "DRIVER_ID");
    }
    public static void updateOrderNumberDelivery(String deliveryId, String field){
        updateStringFieldDelivery(deliveryId, field, "ORDER_NUMBER");
    }
    public static void updateSourceIdDelivery(String deliveryId, String field){
        updateStringFieldDelivery(deliveryId, field, "SOURCE_ID");
    }


    private static void updateStringFieldDelivery(String id, String field, String colomn){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Deliveries SET ? = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, colomn);
            stmt.setString(2, field);
            stmt.setString(3, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void updateDateDelivery(String id,  java.sql.Date date){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Deliveries SET LEAVING_DATE = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDate(1, date);
            stmt.setString(2, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }



}