package DAL;


import BL.Entities.Place;

import java.sql.*;

public class Places {

    public static void insertPlace(String placeId, String address, String phoneNumber, String contactName){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Places VALUES (?, ?, ?, ?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, placeId);
            stmt.setString(2, address);
            stmt.setString(3, phoneNumber);
            stmt.setString(4, contactName);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void removePlace(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "DELETE FROM Places WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Place retrievePlace(String id) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Places WHERE PLACE_ID= (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            String address = rs.getString("ADDRESS");
            String phoneNumber = rs.getString("PHONE_NUMBER");
            String contactName = rs.getString("CONTACT_NAME");
            Place place = new Place(id, address, phoneNumber, contactName);
            conn.close();
            return place;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }



    public static void updateAdressPlace(String placeId, String address){
        updateStringFieldPlace(placeId, address, "ADDRESS");
    }
    public static void updatePhoneNumberPlace(String placeId, String phoneNumber){
        updateStringFieldPlace(placeId, phoneNumber, "PHONE_NUMBER");
    }
    public static void updateContactNamePlace(String placeId, String contactName){
        updateStringFieldPlace(placeId, contactName, "CONTACT_NAME");
    }

    private static void updateStringFieldPlace(String id, String field, String colomn){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "UPDATE Places SET ? = ? WHERE ID = ?  ";
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
