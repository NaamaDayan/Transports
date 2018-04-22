package PL.removeHandlers;
import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;

import java.util.Scanner;

/**
 * Created by Shahar on 22/04/2018.
 */
public class RemoveLicense extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
       System.out.println("enter license id");
        String id = reader.next();
        LicenseTypeForTruckFunctions.removeLicense(id);
    }
}
