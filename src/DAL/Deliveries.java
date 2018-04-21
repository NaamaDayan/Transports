package DAL;


import BL.Entities.Delivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Deliveries{

    public static void insertDeivery(String id, java.sql.Date date,java.sql.Time hour,  String orderId, String truckId, String driverId, String sourceId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Deliveries VALUES (?,?,?,?,?,?,?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setDate(2, date);
            stmt.setTime(3, hour);
            stmt.setString(4, orderId);
            stmt.setString(5, truckId);
            stmt.setString(6, driverId);
            stmt.setString(7, sourceId);
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

    public static Delivery retrieveDelivery(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Deliveries WHERE DELIVERY_ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            java.sql.Date date  = rs.getDate("LEAVING_DATE");
            java.sql.Time hour = rs.getTime("LEAVING_HOUR");
            String truckId = rs.getString("TRUCK_ID");
            String orderId = rs.getString("ORDER_NUMBER");
            String driverId = rs.getString("DRIVER_ID");
            String sourceId = rs.getString("SOURCE_ID");
            List<String> dests = DeliveryDestinations.retrieveDeliveryDestination(id);
            Delivery delivery = new Delivery(id, date, hour, truckId, driverId, orderId, sourceId, dests);
            conn.close();
            return delivery;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
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
    public static void updateLeavingDateDelivery(String deliveryId, java.sql.Date date){
        updateDateDelivery(deliveryId, date, "LEAVING_DATE");
    }
    public static void updateLeavingHourDelivery(String deliveryId, java.sql.Date hour){
        updateDateDelivery(deliveryId, hour, "LEAVING_HOUR");
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

    private static void updateDateDelivery(String id,  java.sql.Date date, String column){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Deliveries SET ? = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, column);
            stmt.setDate(2, date);
            stmt.setString(3, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }



}
