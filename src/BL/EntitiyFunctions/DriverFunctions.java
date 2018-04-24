package BL.EntitiyFunctions;

import BL.Entities.Driver;
import BL.Entities.DriverLicense;
import BL.Entities.LicenseTypeForTruck;
import DAL.Drivers;
import DAL.DriversLicenses;
import DAL.ErrorsHandler;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.SQLException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverFunctions {

    public static void insertDriver(Driver driver) {
        Drivers.insertDriver(driver.getId(), driver.getFirstName(), driver.getLastName(), driver.getPhoneNumber());
    }

    public static Driver retrieveDriver(String id){
        return Drivers.retrieveDriver(id);
    }

    public static void removeDriver(String id) throws SQLException, ClassNotFoundException {
     //   Driver d = Drivers.retrieveDriver(id);
        Drivers.removeDriver(id);
        /*List<LicenseTypeForTruck> licenseList = DriversLicenses.retrieveDriverLicenses(id); //list of id's of licenses of driver
        for (LicenseTypeForTruck license: licenseList) {
            DriversLicenses.removeDriverLicense(id, license.getLicenseType());
        }*/
    }

    public static void updateDriver(Driver d) throws SQLException, ClassNotFoundException {
        Drivers.updateDriver(d);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isDriverExist(id);
    }
}
