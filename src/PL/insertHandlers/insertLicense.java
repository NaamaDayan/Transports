package PL.insertHandlers;

<<<<<<< HEAD

import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;
import BL.Entities.LicenseTypeForTruck;
import java.util.Scanner;

public class insertLicense extends Functor
{


    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter license type");
        String licenseType = reader.next();
        System.out.println("enter truck model");
        String truckModel = reader.next();
        LicenseTypeForTruck license = new LicenseTypeForTruck(licenseType, truckModel);
        LicenseTypeForTruckFunctions.insertLicense(license);
=======
import PL.Functor;

public class insertLicense extends Functor {
    @Override
    public void execute() {
>>>>>>> master
        System.out.println("Success!!!!");
    }
}
