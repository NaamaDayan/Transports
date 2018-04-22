package BL.EntitiyFunctions;

import BL.Entities.LicenseTypeForTruck;
import DAL.DriversLicenses;
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

    public static List<String> retrieveLicenses(String truckModel){
        return LicenseForTruck.retrieveTruckLicenses(truckModel);
    }

    public static void removeLicense(String id){
        LicenseForTruck.removeLicense(id);
    }

    public static void updateLicense(LicenseTypeForTruck d) throws SQLException, ClassNotFoundException {
        LicenseForTruck.updateLicense(d);
    }

    public static LicenseTypeForTruck isLicenseExist(String id) throws SQLException, ClassNotFoundException {
        return LicenseForTruck.isLicenseExist(id);
    }
}
