package BL.EntitiyFunctions;

import BL.Entities.Driver;
import DAL.Drivers;
import DAL.ErrorsHandler;
import java.sql.SQLException;

import java.sql.SQLException;

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

    public static void removeDriver(String id){
        Drivers.removeDriver(id);
    }

    public static void updateDriver(Driver d) throws SQLException, ClassNotFoundException {
        Drivers.updateDriver(d);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isDriverExist(id);
    }
}
