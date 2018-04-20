package DAL;
import java.io.File;
import java.sql.*;

public class CreateTables {

    public static void initDB() {
        File file = new File ("transports.db");
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
            if (!file.exists())
                createTable(conn);
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void createTable(Connection conn){
        createTrucksTable(conn);
        createDriversTable(conn);
        createLicensesTable(conn);
        createDeliveriesTable(conn);
        createPlacesTable(conn);
        createDeliveryDestinationsTable(conn);
        createLicensesForDriversTable(conn);
    }
    private static void createTrucksTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE Trucks " +
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
                    " TRUCK_MODEL  TEXT, FOREIGN KEY(TRUCK_MODEL) REFERENCES Trucks(MODEL)" +
                    "PRIMARY KEY (LICENSE_TYPE, TRUCK_MODEL))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createLicensesForDriversTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE LicensesForDrivers " +
                    "(DRIVER_ID VARCHAR (9)," +
                    "LICENSE_TYPE VARCHAR (9), "+
                    "FOREIGN KEY (LICENSE_TYPE) REFERENCES Licenses(LICENSE_TYPE)," +
                    "FOREIGN KEY(DRIVER_ID) REFERENCES Drivers(ID),"+
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
                    "LEAVING_DATE DATETIME NOT NULL, " +
                    "LEAVING_HOUR DATETIME NOT NULL, " +
                    "ORDER_NUMBER VARCHAR (9) NOT NULL, " +
                    "TRUCK_ID VARCHAR (9), " +
                    "DRIVER_ID VARCHAR (9), " +
                    "SOURCE_ID VARCHAR(9) ,"+
                    "FOREIGN KEY(TRUCK_ID) REFERENCES Trucks(ID),"+
                    "FOREIGN KEY(DRIVER_ID) REFERENCES Drivers(ID),"+
                    "FOREIGN KEY(SOURCE_ID) REFERENCES Places(PLACE_ID))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void createDeliveryDestinationsTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE DeliveryDestinations " +
                    "(DELIVERY_ID INTEGER, " +
                    "PLACE_ID INTEGER,"+
                    "FOREIGN KEY(PLACE_ID) REFERENCES Places(PLACE_ID)," +
                    "FOREIGN KEY(DELIVERY_ID) REFERENCES Deliveries(DELIVERY_ID),"+
                    "PRIMARY  KEY(DELIVERY_ID, PLACE_ID))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
