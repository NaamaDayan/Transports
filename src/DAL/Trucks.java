package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import BL.Entities.Truck;

public class Trucks {


    public static void insertTruck(String id, String model, String color, int netoWeight, int maxWeight){
        try (Connection conn = Utils.openConnection()) {
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
        }
    }


    public static void removeTruck(String id){
        try (Connection conn = Utils.openConnection()) {
            String query = "DELETE FROM Trucks WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Truck retrieveTruck(String id){
        try (Connection conn = Utils.openConnection()) {
            String query = "SELECT * FROM Trucks WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Truck truck = createTruck(rs);
            conn.close();
            return truck;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public static void updateTruck(Truck t) throws SQLException, ClassNotFoundException {
        Connection conn = Utils.openConnection();
        String query = "UPDATE Trucks SET MODEL = ?, COLOR = ?, NETO_WEIGHT = ?, MAX_WEIGHT = ? WHERE ID = ?  ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, t.getModel());
        stmt.setString(2, t.getColor());
        stmt.setInt(3, t.getNetoWeight());
        stmt.setInt(4, t.getMaxWeight());
        stmt.setString(5, t.getId());
        stmt.executeUpdate();
        conn.close();
    }

    public static Truck isTruckExist(String id) throws SQLException, ClassNotFoundException {
        Connection conn = Utils.openConnection();
        String query = "SELECT * FROM Trucks WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        Truck t = createTruck(rs);
        conn.close();
        return t;
    }

    public static Truck createTruck(ResultSet rs) throws SQLException {
        if (!rs.isBeforeFirst()) //not exists
            return null;
        String id = rs.getString("ID");
        String model = rs.getString("MODEL");
        String color = rs.getString("COLOR");
        int netoWeight = rs.getInt("NETO_WEIGHT");
        int maxWeight = rs.getInt("MAX_WEIGHT");
        return new Truck(id, model, color, netoWeight, maxWeight);
    }
}
