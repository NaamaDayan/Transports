package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import BL.Entities.Truck;

public class Trucks {


    public static void insertTruck(String id, String model, String color, int netoWeight, int maxWeight){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Trucks VALUES (?, ?, ? ,?,?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, model);
            stmt.setString(3, color);
            stmt.setInt(4, netoWeight);
            stmt.setInt(5, maxWeight);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public static void removeTruck(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Trucks WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Truck retrieveTruck(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Trucks WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            String model = rs.getString("MODEL");
            String color = rs.getString("COLOR");
            int netoWeight = rs.getInt("NETO_WEIGHT");
            int maxWeight = rs.getInt("MAX_WEIGHT");
            Truck truck = new Truck(id, model, color, netoWeight, maxWeight);
            conn.close();
            return truck;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void updateModelTruck(String id, String model){
        updateStringFieldTruck(id, model, "MODEL");
    }
    public static void updateColorTruck(String id, String color){
        updateStringFieldTruck(id, color, "COLOR");
    }
    public static void updateNetoWeightTruck(String id, int netoWeight){
        updateIntFieldTruck(id, netoWeight, "NETO_WEIGHT");
    }
    public static void updateMaxWeightTruck(String id, int maxWeight){
        updateIntFieldTruck(id, maxWeight, "MAX_WEIGHT");
    }


    private static void updateStringFieldTruck(String id, String field, String colomn){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Trucks SET ? = ? WHERE ID = ?  ";
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

    private static void updateIntFieldTruck(String id, int field, String colomn){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Trucks SET ? = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, colomn);
            stmt.setInt(2, field);
            stmt.setString(3, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
