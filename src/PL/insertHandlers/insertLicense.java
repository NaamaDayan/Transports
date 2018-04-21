package PL.insertFunctions;


import PL.Functor;
import BL.Entities.LicenseTypeForTruck;
import java.util.Scanner;

public class InsertLicense extends Functor
{


    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter license type");
        String licenseType = reader.next();
        System.out.println("enter truck model");
        String truckModel = reader.next();
        LicenseTypeForTruck license = new LicenseTypeForTruck(licenseType, truckModel);
        license.insertLicense();
        System.out.println("Success!!!!");
    }
}
