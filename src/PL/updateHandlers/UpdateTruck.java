package PL.updateHandlers;

import BL.Entities.Truck;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

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
        Truck t = null;
        try {
            t = TruckFunctions.isTruckExist(idToUpdate);
        } catch (Exception e) {
            System.out.println("error: update failed");
            return;
        }
        if (t == null) {
            System.out.println("error: ID doesn't exist");
            return;
        }
        if (updateUtils.boolQuery("update model? y/n")) {
            System.out.println("enter model");
            newStringField = reader.next();
            t.setModel(newStringField);
        }
        if (updateUtils.boolQuery("update color? y/n")) {
            System.out.println("enter color");
            newStringField = reader.next();
            t.setColor(newStringField);
        }
        if (updateUtils.boolQuery("update neto weight? y/n")) {
            System.out.println("enter neto weight");
            newNumericField = reader.nextInt();
            t.setNetoWeight(newNumericField);
        }
        if (updateUtils.boolQuery("update max weight? y/n")) {
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
