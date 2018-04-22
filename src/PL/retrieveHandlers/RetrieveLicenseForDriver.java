package PL.retrieveHandlers;

import BL.EntitiyFunctions.DriverLicenseFunctions;
import PL.Functor;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class RetrieveLicenseForDriver extends Functor{

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String id = reader.next();
        List<String> licensesTypes = DriverLicenseFunctions.retrieveLicenses(id);
        System.out.println("licenses for driver "+id+" :");
        for (String license: licensesTypes)
            System.out.println(license);
        System.out.println("Success!!!!");
    }
}
