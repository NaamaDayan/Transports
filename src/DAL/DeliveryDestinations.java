package DAL;


import BL.Entities.DeliveryDestination;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeliveryDestinations {

    public static void insertDeliveryDestination(String deliveryId, String destId, String orderNumber){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO DeliveryDestinations VALUES (?, ?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            stmt.setString(2, destId);
            stmt.setString(3, orderNumber);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void removeDeliveryDestination(String deliveryId, String destId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM  DeliveryDestinations WHERE DELIVERY_ID = ? AND PLACE_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            stmt.setString(2, destId);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static boolean isDestExistInDelivery(String deliveryId, String destId) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "SELECT * FROM DeliveryDestinations WHERE DELIVERY_ID = ? AND PLACE_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, deliveryId);
        stmt.setString(2, destId);
        ResultSet rs = stmt.executeQuery();
        conn.close();
        return rs.isBeforeFirst();
    }

    //returns a list of all the delivery destinations
    public static List<DeliveryDestination> retrieveDeliveryDestination(String deliveryId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM DeliveryDestinations WHERE DELIVERY_ID = (?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            ResultSet rs = stmt.executeQuery();
            List<DeliveryDestination> destinations = new LinkedList();
            while (rs.next()) {
                String destId = rs.getString("PLACE_ID");
                String orderNum = rs.getString("ORDER_NUMBER");
                DeliveryDestination deliveryDestination = new DeliveryDestination(deliveryId, destId, orderNum);
                destinations.add(deliveryDestination);
            }
            return destinations;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
