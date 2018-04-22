package BL.EntitiyFunctions;

import BL.Entities.Driver;
import DAL.Drivers;
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

    public static Driver isDriverExist(String id) throws SQLException, ClassNotFoundException {
        return Drivers.isDriverExist(id);
    }

}
