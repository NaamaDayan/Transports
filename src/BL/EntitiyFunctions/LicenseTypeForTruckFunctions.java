package BL.EntitiyFunctions;

import BL.Entities.LicenseTypeForTruck;
import DAL.LicenseForTruck;

import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class LicenseTypeForTruckFunctions {

    public static void insertLicense(LicenseTypeForTruck ltft){
        LicenseForTruck.insertLicense(ltft.getTruckModel(), ltft.getLicenseType());
    }

    public static List<String> retrieveLicenses(String truckModel){
        return LicenseForTruck.retrieveTruckLicenses(truckModel);
    }

}
