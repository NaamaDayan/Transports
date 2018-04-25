package BL.EntitiyFunctions;

import BL.Entities.Model;
import DAL.ErrorsHandler;
import DAL.Models;

import java.sql.SQLException;

/**
 * Created by Naama on 21/04/2018.
 */
public class ModelFunctions {

    public static void insertModel(Model model) throws SQLException {
        Models.insertModel(model.getId(), model.getModelName());
    }

    public static Model retrieveModel(String id) throws SQLException {
        return Models.retrieveModel(id);
    }

    public static void removeModel(String id) throws SQLException {
        Models.removeModel(id);
    }

    public static void updateModel(Model m) throws SQLException, ClassNotFoundException {
        Models.updateModel(m);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isModelExist(id);
    }

}
