package DAL;
import java.util.Scanner;
import java.sql.*;

public class Main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");) {
            Class.forName("org.sqlite.JDBC");
            createTable(conn);

            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    private static void createTable(Connection conn){
        createTracksTable(conn);
        createDriversTable(conn);
        createLicensesTable(conn);
        createDeliveriesTable(conn);
        createPlacesTable(conn);
        createDeliveryDestinationsTable(conn);
        createLicensesForDriversTable(conn);
    }
    private static void createTracksTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            //create tracks
            String sql = "CREATE TABLE Tracks " +
                    "(ID VARCHAR(9) PRIMARY KEY NOT NULL," +
                    " MODEL           TEXT    NOT NULL, " +
                    " COLOR           TEXT    NOT NULL, " +
                    " NETO_WEIGHT         INT, " +
                    "MAX_WEIGHT         INT)";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void createDriversTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE Drivers " +
                    "(ID VARCHAR(9) PRIMARY KEY     NOT NULL," +
                    " FIRST_NAME           TEXT    NOT NULL, " +
                    " LAST_NAME           TEXT    NOT NULL, " +
                    "PHONE_NUMBER         TEXT)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createLicensesTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE Licenses " +
                    "(LICENSE_TYPE VARCHAR (9) NOT NULL," +
                    " TRACK_MODEL  TEXT FOREIGN KEY REFERENCES Tracks(MODEL)" +
                    "PRIMARY KEY (LICENSE_TYPE, TRACK_MODEL))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createLicensesForDriversTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE LicensesForDrivers " +
                    "(DRIVER_ID VARCHAR (9) FOREIGN KEY REFERENCES Drivers(ID)," +
                    "LICENSE_TYPE VARCHAR (9) FOREIGN KEY REFERENCES Licenses(LICENSE_TYPE)," +
                    "PRIMARY KEY (LICENSE_TYPE, DRIVER_ID))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createPlacesTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE Places " +
                    "(PLACE_ID VARCHAR (9) PRIMARY KEY NOT NULL," +
                    "ADDRESS TEXT NOT NULL ," +
                    "PHONE_NUMBER TEXT, " +
                    "CONTACT_NAME TEXT)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDeliveriesTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE Deliveries " +
                    "(DELIVERY_ID VARCHAR (9) PRIMARY KEY NOT NULL," +
                    "DATE TEXT NOT NULL, " +
                    "LEAVING_HOUR TEXT NOT NULL ," +
                    "TRACK_ID VARCHAR (9) FOREIGN KEY REFERENCES Tracks(ID)," +
                    "DRIVER_ID VARCHAR (9) FOREIGN KEY REFERENCES Drivers(ID)," +
                    "ORDER_NUMBER VARCHAR (9) NOT NULL, " +
                    "SOURCE_ID VARCHAR(9) FOREIGN KEY REFERENCES Places(PLACE_ID))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void createDeliveryDestinationsTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE DeliveryDestinations " +
                    "(DELIVERY_ID VARCHAR (9), FOREIGN KEY (DELIVERY_ID) REFERENCES Deliveries(DELIVERY_ID)," +
                    "PLACE_ID VARCHAR (9), FOREIGN KEY (PLACE_ID) REFERENCES Places(PLACE_ID)," +
                    "PRIMARY  KEY(DELIVERY_ID, PLACE_ID)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
