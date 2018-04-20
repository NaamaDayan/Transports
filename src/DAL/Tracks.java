package DAL;
import DAL.CreateTables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.sql.SQLException;
import java.sql.Statement;

public class Tracks {


    public static void insertTrack(String id, String model, String color, int netoWeight, int maxWeight){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Tracks VALUES (?, ?, ? ,?,?)  ";
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


    public static void removeTrack(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Tracks WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateModelTrack(String id, String model){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Tracks SET MODEL = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, model);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateColorTrack(String id, String color){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Tracks SET COLOR = ? WHERE ID = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, color);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }




}
