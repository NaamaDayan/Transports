package Tests;

import BL.Entities.Driver;
import BL.Entities.Place;
import DAL.CreateTables;
import DAL.Drivers;

import DAL.Places;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */

public class DriversTests {
    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }

    @Test
    public void retrieveDriver() throws Exception {
        String driverId = "567";
        String firstName = "miri";
        String lastName = "regev";
        String phoneNumber = "36836836836";
        Drivers.insertDriver(driverId, firstName, lastName, phoneNumber);
        Driver driver = Drivers.retrieveDriver(driverId);
        Assert.assertEquals(driver.getId(), driverId);
        Assert.assertEquals(driver.getFirstName(), firstName);
        Assert.assertEquals(driver.getLastName(), lastName);
        Assert.assertEquals(driver.getPhoneNumber(), phoneNumber);
    }

    @Test
    public void updateDriver() throws Exception {
        String driverId = "789";
        String firstName = "aloha";
        String lastName = "darling";
        String phoneNumber = "0353573";
        Drivers.insertDriver(driverId, firstName, lastName, phoneNumber);
        Driver updated = new Driver("789", "beni", "yesh", "346346");
        Drivers.updateDriver(updated);
        Driver driver = Drivers.retrieveDriver("789");
        Assert.assertEquals(driver.getId(), "789");
        Assert.assertEquals(driver.getFirstName(), "beni");
        Assert.assertEquals(driver.getLastName(), "yesh");
        Assert.assertEquals(driver.getPhoneNumber(), "346346");
    }

}
