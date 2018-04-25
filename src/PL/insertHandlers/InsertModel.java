package PL.insertHandlers;


import BL.Entities.Model;
import BL.EntitiyFunctions.ModelFunctions;
import PL.Functor;

import java.util.Scanner;

public class InsertModel extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
    System.out.println("enter model id");
    String modelId = reader.next();
    try {
        if (ModelFunctions.isExist(modelId)) {
            System.out.println("model already exists");
            return;
        }
        System.out.println("enter model name");
        String name = reader.next();
        Model model = new Model(modelId, name);
        ModelFunctions.insertModel(model);
    }catch (Exception e) {
        System.out.println("error: insert failed");
        return;
    }
    }
}
