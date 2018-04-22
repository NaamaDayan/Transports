package PL.updateHandlers;

import BL.Entities.Place;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;
import PL.Utils;

import java.util.Scanner;

public class UpdatePlace extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        String idToUpdate;
        String newField;
        System.out.println("enter place's ID");
        idToUpdate = reader.next();
        Place p;
        try {
            if (!PlaceFunctions.isExist(idToUpdate)) {
                System.out.println("error: ID doesn't exist");
                return;
            }
            else {
                p = PlaceFunctions.retrievePlace(idToUpdate);
            }
        } catch (Exception e) {
            System.out.println("error: update failed");
            return;
        }
        if (Utils.boolQuery("update address? y/n")) {
            System.out.println("enter address");
            newField = reader.next();
            p.setAddress(newField);
        }
        if (Utils.boolQuery("update phone number? y/n")) {
            System.out.println("enter phone number");
            newField = reader.next();
            p.setPhoneNumber(newField);
        }
        if (Utils.boolQuery("update contact name? y/n")) {
            System.out.println("enter contact name");
            newField = reader.next();
            p.setContactName(newField);
        }
        try {
            PlaceFunctions.updatePlace(p);
        } catch (Exception e) {
            System.out.println("error: update failed");
        }
    }
}
