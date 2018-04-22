package BL.EntitiyFunctions;

import BL.Entities.Driver;
import DAL.Drivers;

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
}
