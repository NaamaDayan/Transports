package Tests;

import BL.Entities.LicenseTypeForTruck;
import DAL.CreateTables;
import DAL.LicenseForTruck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */
public class LicenseForTruckTest {
    @Before
    public void initDataBase(){
        CreateTables.initDB();
    }

    @Test
    public void insertLicense() throws Exception {
    }

    @Test
    public void removeLicense() throws Exception {
    }

    @Test
    public void retrieveLicense() throws Exception {
        LicenseForTruck.insertLicense("mona", "123");
        LicenseTypeForTruck returned = LicenseForTruck.retrieveLicense("123");
        Assert.assertEquals(returned.getTruckModel(), "mona");
    }

    @Test
    public void updateLicense() throws Exception {
    }

    @Test
    public void isLicenseExist() throws Exception {
    }

    @Test
    public void createLicense() throws Exception {
    }



}
