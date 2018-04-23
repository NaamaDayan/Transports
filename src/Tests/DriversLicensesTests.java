package Tests;

import BL.Entities.LicenseTypeForTruck;
import DAL.CreateTables;
import DAL.Drivers;
import DAL.DriversLicenses;

import DAL.LicenseForTruck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */
public class DriversLicensesTests {
    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }

    @Test
    public void retrieveDriverLicenses() throws Exception {
        Drivers.insertDriver("123", "noy", "barak", "050253");
        LicenseForTruck.insertLicense("12", "kruskal");
        LicenseForTruck.insertLicense("13", "moishe");
        DriversLicenses.insertDriverLicense("123", "12");
        DriversLicenses.insertDriverLicense("123", "13");
        List<LicenseTypeForTruck> licenses = DriversLicenses.retrieveDriverLicenses("123");
        Assert.assertTrue(licenses.contains("12"));
        Assert.assertTrue(licenses.contains("13"));


    }



}
