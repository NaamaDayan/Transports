package BL.EntitiyFunctions;

import BL.Entities.LicenseTypeForTruck;
import DAL.ErrorsHandler;
import DAL.LicenseForTruck;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class LicenseTypeForTruckFunctions {

    public static void insertLicense(LicenseTypeForTruck ltft){
        LicenseForTruck.insertLicense(ltft.getTruckModel(), ltft.getLicenseType());
    }

    public static LicenseTypeForTruck retrieveLicenses(String truckModel){
        return LicenseForTruck.retrieveLicense(truckModel);
    }

    public static void removeLicense(String id){
        LicenseForTruck.removeLicense(id);
    }

    public static void updateLicense(LicenseTypeForTruck d) throws SQLException, ClassNotFoundException {
        LicenseForTruck.updateLicense(d);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isLicenseExist(id);
    }
}
