package BL.EntitiyFunctions;

import BL.Entities.DriverLicense;
import BL.Entities.LicenseTypeForTruck;
import DAL.DriversLicenses;
import DAL.ErrorsHandler;

import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverLicenseFunctions {

    public static void insertDriverLicense(DriverLicense dl){

        DriversLicenses.insertDriverLicense(dl.getDriver(), dl.getLicense().getLicenseType());
    }
    public static List<LicenseTypeForTruck> retrieveLicenses(String driverId){
        return DriversLicenses.retrieveDriverLicenses(driverId);
    }

    public static void removeLicenseOfDriver(String driverId ,String licenseId){
        DriversLicenses.removeDriverLicense(driverId, licenseId);
    }

    public static boolean isExist(String driverId, String licenseId) throws Exception {
        return ErrorsHandler.isDriverLicenseExist(driverId, licenseId);
    }
}
