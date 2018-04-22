package DAL;

import java.sql.*;

/**
 * Created by Naama on 22/04/2018.
 */
public class ErrorsHandler {

    public static boolean isTruckExist(String id) throws SQLException, ClassNotFoundException {
        return isEntityExist(id,  "Trucks");
    }

    public static boolean isDriverExist(String id) throws SQLException, ClassNotFoundException {
        return isEntityExist(id,  "Drivers");
    }

    public static boolean isDeliveryExist(String id) throws SQLException, ClassNotFoundException {
        return isEntityExist(id,  "Deliveries");
    }
    public static boolean isPlaceExist(String id) throws SQLException, ClassNotFoundException {
        return isEntityExist(id,  "Places");
    }
    public static boolean isLicenseExist(String id) throws SQLException, ClassNotFoundException {
        return isEntityExist(id,  "Licenses");
    }



    public static boolean isEntityExist(String id,  String tableName) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:transports.db");
        Class.forName("org.sqlite.JDBC");
        String query  = "SELECT * FROM " + tableName +" WHERE ID = ? ";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        //stmt.setString(2, id);
        ResultSet rs = stmt.executeQuery();
        conn.close();
        return rs.isBeforeFirst();
    }
}
