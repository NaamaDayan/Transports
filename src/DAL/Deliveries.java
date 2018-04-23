package DAL;


import BL.Entities.*;
import BL.Entities.Driver;

import java.sql.*;
import java.util.List;

public class Deliveries{

    public static void insertDeivery(String id, java.sql.Date date,java.sql.Time hour, String truckId, String driverId, String sourceId){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "INSERT INTO Deliveries VALUES (?,?,?,?,?,?)  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setDate(2, date);
            stmt.setTime(3, hour);
            stmt.setString(4, truckId);
            stmt.setString(5, driverId);
            stmt.setString(6, sourceId);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void removeDelivery(String id) throws ClassNotFoundException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "DELETE FROM Deliveries WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    public static void updateDelivery(Delivery d) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query = "UPDATE Deliveries SET LEAVING_DATE = ?, LEAVING_TIME = ?, TRUCK_ID = ? DRIVER_ID = ?, SOURCE_ID = ? WHERE ID = ?  ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setDate(1, d.getDate());
        stmt.setTime(2, d.getHour());
        stmt.setString(3, d.getTruck().getId());
        stmt.setString(4, d.getDriver().getId());
        stmt.setString(5, d.getSource().getId());
        stmt.setString(6, d.getId());
        stmt.executeUpdate();
        conn.close();
    }

    public static Delivery retrieveDelivery(String id){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM Deliveries WHERE ID = (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            java.sql.Date date  = rs.getDate("LEAVING_DATE");
            java.sql.Time hour = rs.getTime("LEAVING_TIME");
            String truckId = rs.getString("TRUCK_ID");
            Truck truck = Trucks.retrieveTruck(truckId);
            String driverId = rs.getString("DRIVER_ID");
            Driver driver = Drivers.retrieveDriver(driverId);
            String sourceId = rs.getString("SOURCE_ID");
            Place source = Places.retrievePlace(sourceId);
            List<DeliveryDestination> dests = DeliveryDestinations.retrieveDeliveryDestination(id);
            Delivery delivery = new Delivery(id, date, hour, truck, driver, source, dests);
            conn.close();
            return delivery;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public static boolean DoesDriverHaveLicense(String driverId, String truckModel){
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            String query = "SELECT * FROM LicensesForDrivers JOIN Licenses " +
                    "ON LicensesForDrivers.LICENSE_TYPE = Licenses.ID " +
                    "WHERE DRIVER_ID = (?) AND TRUCK_MODEL = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, driverId);
            stmt.setString(2, truckModel);
            ResultSet rs = stmt.executeQuery();
            return rs.isBeforeFirst();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
    }



}
