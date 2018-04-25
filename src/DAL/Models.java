package DAL;


import BL.Entities.Model;
import BL.Entities.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Models {

    public static void insertModel(String modelId, String name) throws SQLException {
        Connection conn = Utils.openConnection();
        String query = "INSERT INTO Models VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, modelId);
        stmt.setString(2, name);
        stmt.executeUpdate();
        conn.close();
    }

    public static void removeModel(String id) throws SQLException {
        Connection conn = Utils.openConnection();
        String query = "DELETE FROM Models WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    public static Model retrieveModel(String id) throws SQLException {
        Connection conn = Utils.openConnection();
        String query = "SELECT * FROM Models WHERE ID= ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        Model model = createModel(rs);
        conn.close();
        return model;
    }

    public static void updateModel(Model m) throws SQLException {
        Connection conn = Utils.openConnection();
        String query = "UPDATE Models SET MODEL_NAME = ? WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, m.getModelName());
        stmt.setString(2, m.getId());
        stmt.executeUpdate();
        conn.close();
    }

    public static Model createModel(ResultSet rs) throws SQLException {
        if (!rs.isBeforeFirst()) //not exists
            return null;
        String id = rs.getString("ID");
        String name = rs.getString("MODEL_NAME");
        return new Model(id, name);
    }
}
