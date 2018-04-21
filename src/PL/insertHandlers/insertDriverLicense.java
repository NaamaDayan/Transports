package PL.insertFunctions;

import PL.Functor;
import BL.Entities.DriverLicense;
import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class InsertDriverLicense extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver idl");
        String driverId = reader.next();
        System.out.println("enter license type");
        String licenseType = reader.next();
        DriverLicense driverLicense = new DriverLicense(driverId, licenseType);
        driverLicense.insertDriverLicense();
        System.out.println("Success!!!!");
    }
}
