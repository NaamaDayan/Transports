package PL.updateHandlers;

import BL.Entities.LicenseTypeForTruck;
import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;
import PL.Utils;

import java.util.Scanner;


public class UpdateLicense extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        String idToUpdate;
        String newField;
        System.out.println("enter License's ID");
        idToUpdate = reader.next();
        LicenseTypeForTruck l = null;
        try {
            if (!LicenseTypeForTruckFunctions.isExist(idToUpdate)) {
                System.out.println("error: ID doesn't exist");
                return;
            }
            else {
                l = LicenseTypeForTruckFunctions.retrieveLicenses(idToUpdate);
            }
        } catch (Exception e) {
            System.out.println("error: update failed");
            return;
        }
        if (Utils.boolQuery("update truck model? y/n")) {
            System.out.println("enter truck model");
            newField = reader.next();
            l.setTruckModel(newField);
        }
        try {
            LicenseTypeForTruckFunctions.updateLicense(l);
        } catch (Exception e) {
            System.out.println("error: update failed");
        }
    }
}
