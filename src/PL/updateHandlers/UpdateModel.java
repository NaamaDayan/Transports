package PL.updateHandlers;

import BL.Entities.Model;
import BL.EntitiyFunctions.ModelFunctions;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;
import PL.Utils;

import java.util.Scanner;

public class UpdateModel extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        String idToUpdate;
        String name;
        System.out.println("enter model ID");
        idToUpdate = reader.next();
        Model model;
        try {
            model = ModelFunctions.retrieveModel(idToUpdate);
            if (model == null) {
                System.out.println("error: ID doesn't exist");
                return;
            }
            if (Utils.boolQuery("update model name? y/n")) {
                System.out.println("enter model name");
                name = reader.next();
                model.setModelName(name);
            }
            ModelFunctions.updateModel(model);
        }
        catch (Exception e){
            System.out.println("error: update failed");
            return;
        }
    }
}
