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


    private static void createTable(Connection conn) {
        try (Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE Tracks " +
                    "(ID VARCHAR(9) PRIMARY KEY     NOT NULL," +
                    " FIRST NAME           TEXT    NOT NULL, " +
                    " LAST NAME           TEXT    NOT NULL, " +
                    " SALARY         INT)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
