package PL.updateHandlers;

import BL.Entities.Driver;
import BL.EntitiyFunctions.DriverFunctions;
import PL.Functor;
import java.util.Scanner;


public class UpdateDriver extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        String idToUpdate;
        String newField;
        System.out.println("enter driver's ID");
        idToUpdate = reader.next();
        Driver d = null;
        try {
            d = DriverFunctions.isDriverExist(idToUpdate);
        } catch (Exception e) {
            System.out.println("error: update failed");
            return;
        }
        if (d == null) {
            System.out.println("error: ID doesn't exist");
            return;
        }
        if (updateUtils.boolQuery("update first name? y/n")) {
            System.out.println("enter first name");
            newField = reader.next();
            d.setFirstName(newField);
        }
        if (updateUtils.boolQuery("update last name? y/n")) {
            System.out.println("enter last name");
            newField = reader.next();
            d.setLastName(newField);
        }
        if (updateUtils.boolQuery("update phone number? y/n")) {
            System.out.println("enter phone number");
            newField = reader.next();
            d.setPhoneNumber(newField);
        }
        try {
            DriverFunctions.updateDriver(d);
        } catch (Exception e) {
            System.out.println("error: update failed");
        }
    }
}
