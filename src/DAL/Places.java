package DAL;


import BL.Entities.Driver;
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
            String query = "SELECT * FROM Places WHERE ID= (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Place place = createPlace(rs);
            conn.close();
            return place;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void updatePlace(Place p) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "UPDATE Place SET ADDRESS = ?, PHONE_NUMBER = ?, CONTACT_NAME = ? WHERE PLACE_ID = ?  ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, p.getAddress());
        stmt.setString(2, p.getPhoneNumber());
        stmt.setString(3, p.getContactName());
        stmt.setString(4, p.getId());
        stmt.executeUpdate();
        conn.close();
    }

    public static Place isPlaceExist(String id) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "SELECT * FROM Place WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        Place place = createPlace(rs);
        conn.close();
        return place;
    }

    public static Place createPlace(ResultSet rs) throws SQLException {
        if (!rs.isBeforeFirst()) //not exists
            return null;
        String id = rs.getString("ID");
        String address = rs.getString("ADDRESS");
        String contactName = rs.getString("CONTACT_NAME");
        String phoneNumber = rs.getString("PHONE_NUMBER");
        return new Place(id, address, phoneNumber, contactName);
    }
}
