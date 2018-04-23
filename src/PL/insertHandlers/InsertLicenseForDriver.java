package PL.insertHandlers;

import BL.Entities.LicenseTypeForTruck;
import BL.EntitiyFunctions.DriverFunctions;
import BL.EntitiyFunctions.DriverLicenseFunctions;
import BL.EntitiyFunctions.LicenseTypeForTruckFunctions;
import PL.Functor;
import BL.Entities.DriverLicense;

import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class InsertLicenseForDriver extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String driverId = reader.next();
        try {
            if (!DriverFunctions.isExist(driverId)){
                System.out.println("driver does not exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("enter license id");
        String licenseType = reader.next();
        try {
            if (!LicenseTypeForTruckFunctions.isExist(licenseType)){
                System.out.println("license does not exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LicenseTypeForTruck license = LicenseTypeForTruckFunctions.retrieveLicenses(licenseType);
        DriverLicense driverLicense = new DriverLicense(driverId, license);
        DriverLicenseFunctions.insertDriverLicense(driverLicense);
        System.out.println("Success!!!!");
    }




}
