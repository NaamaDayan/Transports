package PL.retrieveHandlers;

import PL.Functor;
import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class retrieveLicense extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter truck model");
        String model = reader.next();
        List<String> licensesTypes = LicenseTypeForTruckFunctions.retrieveLicenses(model);
        System.out.println("licenses for truck " + model + " :");
        for (String license : licensesTypes)
            System.out.println(license);
        System.out.println("Success!!!!");
    }


}
