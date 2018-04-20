package DAL;

import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Drivers {

    public static void insertDriver(String id, String firstName, String lastName, String phoneNumber){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Drivers VALUES (?, ?, ? ,?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, phoneNumber);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removeDriver(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Drivers WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateDriverFirstName(String id, String field){
        updateDriverField(id,field, "FIRST_NAME");
    }
    public static void updateDriverLastName(String id, String field){
        updateDriverField(id,field, "LAST_NAME");
    }
    public static void updateDriverPhoneNumber(String id, String field){
        updateDriverField(id,field, "PHONE_NUMBER");
    }

    //the parameter colomn is for firstName, lastName or phoneNumber only!
    private static void updateDriverField(String id, String field, String colomn){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Driver SET ? = ? WHERE ID = ?  ";
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
}
