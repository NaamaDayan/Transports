package DAL;
import java.io.File;
import java.sql.*;

public class CreateTables {

    public static void initDB() {
        File file = new File ("transports.db");
        try {
            Class.forName("org.sqlite.JDBC");
            if (!file.exists())
                createTable();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        createModelsTable(conn);
        createTrucksTable(conn);
        createDriversTable(conn);
        createLicensesTable(conn);
        createDeliveriesTable(conn);
        createPlacesTable(conn);
        createDeliveryDestinationsTable(conn);
        createLicensesForDriversTable(conn);
        conn.close();
    }

    private static void createModelsTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE Models " +
                    "(ID VARCHAR(9) PRIMARY KEY NOT NULL," +
                    "MODEL_NAME     TEXT    NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTrucksTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE Trucks " +
                    "(ID VARCHAR(9) PRIMARY KEY NOT NULL," +
                    "MODEL           VARCHAR(9)    NOT NULL, " +
                    " COLOR           TEXT    NOT NULL, " +
                    "NETO_WEIGHT         INT, " +
                    "MAX_WEIGHT         INT, " +
                    "FOREIGN KEY (MODEL) REFERENCES Models(ID) ON DELETE CASCADE)";
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
                    "(ID VARCHAR (9) NOT NULL," +
                    " TRUCK_MODEL  VARCHAR (9), " +
                    "PRIMARY KEY (ID)" +
                    "FOREIGN KEY (TRUCK_MODEL) REFERENCES Models(ID) ON DELETE CASCADE)";
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
                    "FOREIGN KEY (LICENSE_TYPE) REFERENCES Licenses(ID) ON DELETE CASCADE," +
                    "FOREIGN KEY(DRIVER_ID) REFERENCES Drivers(ID) ON DELETE CASCADE,"+
                    "PRIMARY KEY (LICENSE_TYPE, DRIVER_ID))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createPlacesTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {

            String sql = "CREATE TABLE Places " +
                    "(ID VARCHAR (9) PRIMARY KEY NOT NULL," +
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
                    "(ID VARCHAR (9) PRIMARY KEY NOT NULL," +
                    "LEAVING_DATE DATETIME NOT NULL, " +
                    "LEAVING_TIME DATETIME NOT NULL, " +
                    "TRUCK_ID VARCAR (9), " +
                    "DRIVER_ID VARCHAR (9), " +
                    "SOURCE_ID VARCHAR(9) ,"+
                    "FOREIGN KEY(TRUCK_ID) REFERENCES Trucks(ID) ON DELETE CASCADE,"+
                    "FOREIGN KEY(DRIVER_ID) REFERENCES Drivers(ID) ON DELETE CASCADE,"+
                    "FOREIGN KEY(SOURCE_ID) REFERENCES Places(ID) ON DELETE CASCADE)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void createDeliveryDestinationsTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE DeliveryDestinations " +
                    "(DELIVERY_ID VARCHAR (9), " +
                    "PLACE_ID VARCHAR (9),"+
                    "ORDER_NUMBER VARCHAR (9),"+
                    "ITEM_ID TEXT,"+
                    "QUANTITY INTEGER ,"+
                    "PRIMARY KEY(DELIVERY_ID, PLACE_ID, ORDER_NUMBER, ITEM_ID)," +
                    "FOREIGN KEY(PLACE_ID) REFERENCES Places(ID) ON DELETE CASCADE," +
                    "FOREIGN KEY(DELIVERY_ID) REFERENCES Deliveries(ID) ON DELETE CASCADE)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
