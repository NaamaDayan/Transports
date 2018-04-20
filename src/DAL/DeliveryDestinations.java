package DAL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeliveryDestinations {

    public static void insertDeliveryDestination(String deliveryId, String destId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO DeliveryDestinations VALUES (?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            stmt.setString(2, destId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removeDeliveryDestination(String deliveryId, String destId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM  DeliveryDestinations WHERE DELIVERY_ID = ? AND PLACE_ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, deliveryId);
            stmt.setString(1, destId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
