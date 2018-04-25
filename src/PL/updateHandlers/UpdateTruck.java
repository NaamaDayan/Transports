package PL.updateHandlers;

import BL.Entities.Truck;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;
import PL.Utils;

import java.util.Scanner;


public class UpdateTruck extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        String idToUpdate;
        String newStringField;
        int newNumericField;
        System.out.println("enter Truck's ID");
        idToUpdate = reader.next();
        Truck t;
        try {
            if (!TruckFunctions.isExist(idToUpdate)) {
                System.out.println("error: ID doesn't exist");
                return;
            }
            else {
                t = TruckFunctions.retrieveTruck(idToUpdate);
            }
        } catch (Exception e) {
            System.out.println("error: update failed");
            return;
        }
        if (Utils.boolQuery("update model? y/n")) {
            System.out.println("enter model id");
            newStringField = reader.next();
            t.setModel(newStringField);
        }
        if (Utils.boolQuery("update color? y/n")) {
            System.out.println("enter color");
            newStringField = reader.next();
            t.setColor(newStringField);
        }
        if (Utils.boolQuery("update neto weight? y/n")) {
            System.out.println("enter neto weight");
            newNumericField = reader.nextInt();
            t.setNetoWeight(newNumericField);
        }
        if (Utils.boolQuery("update max weight? y/n")) {
            System.out.println("enter max weight");
            newNumericField = reader.nextInt();
            t.setMaxWeight(newNumericField);
        }
        try {
            TruckFunctions.updateTruck(t);
        } catch (Exception e) {
            System.out.println("error: update failed");
        }
    }
}
