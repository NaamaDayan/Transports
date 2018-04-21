package PL.insertHandlers;

import BL.EntitiyFunctions.DriverLicenseFunctions;
import PL.Functor;
import BL.Entities.DriverLicense;
import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class insertLicenseForDriver extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver idl");
        String driverId = reader.next();
        System.out.println("enter license type");
        String licenseType = reader.next();
        DriverLicense driverLicense = new DriverLicense(driverId, licenseType);
        DriverLicenseFunctions.insertDriverLicense(driverLicense);
        System.out.println("Success!!!!");
    }
}