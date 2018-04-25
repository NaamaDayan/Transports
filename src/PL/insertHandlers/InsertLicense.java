package PL.insertHandlers;


import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;
import BL.Entities.LicenseTypeForTruck;

import java.util.Scanner;

public class InsertLicense extends Functor
{


    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter license id");
        String licenseType = reader.next();
        try {
            if (LicenseTypeForTruckFunctions.isExist(licenseType)){
                System.out.println("license already exists");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("enter truck model");
        String truckModel = reader.next();
        LicenseTypeForTruck license = new LicenseTypeForTruck(licenseType, truckModel);
        LicenseTypeForTruckFunctions.insertLicense(license);
    }
}
