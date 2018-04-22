package BL.EntitiyFunctions;

import BL.Entities.DriverLicense;
import DAL.DriversLicenses;

import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverLicenseFunctions {

    public static void insertDriverLicense(DriverLicense dl){

        DriversLicenses.insertDriverLicense(dl.getDriverId(), dl.getLicenseId());
    }
    public static List<String> retrieveLicenses(String driverId){
        return DriversLicenses.retrieveDriverLicenses(driverId);
    }

    public static void removeLicenseOfDriver(String driverId ,String licenseId){
        DriversLicenses.removeDriverLicense(driverId, licenseId);
    }
}
