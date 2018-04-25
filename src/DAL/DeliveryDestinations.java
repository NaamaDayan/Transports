package DAL;


import BL.Entities.Delivery;
import BL.Entities.DeliveryDestination;
import BL.Entities.Place;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeliveryDestinations {

    public static void insertDeliveryDestination(String deliveryId, String destId, String orderNumber){
        try (Connection conn = Utils.openConnection()) {
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
        try (Connection conn = Utils.openConnection()) {
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
        Connection conn = Utils.openConnection();
        String query = "SELECT * FROM DeliveryDestinations WHERE DELIVERY_ID = ? AND PLACE_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, deliveryId);
        stmt.setString(2, destId);
        ResultSet rs = stmt.executeQuery();
        conn.close();
        return rs.isBeforeFirst();
    }

    //returns a list of all the delivery destinations
    public static List<DeliveryDestination> retrieveDeliveryDestinations(String deliveryId){
        try (Connection conn = Utils.openConnection()) {
            String query = "SELECT * FROM DeliveryDestinations WHERE DELIVERY_ID = (?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            ResultSet rs = stmt.executeQuery();
            List<DeliveryDestination> destinations = new LinkedList();
            while (rs.next()) {
                String destId = rs.getString("PLACE_ID");
                Place dest = Places.retrievePlace(destId);
                String orderNum = rs.getString("ORDER_NUMBER");
                DeliveryDestination deliveryDestination = new DeliveryDestination(dest, orderNum);
                destinations.add(deliveryDestination);
            }
            return destinations;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
