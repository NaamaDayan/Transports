package Tests;

import BL.Entities.LicenseTypeForTruck;
import DAL.CreateTables;
import DAL.LicenseForTruck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */
public class LicenseForTruckTests {
    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }

    @Test
    public void retrieveLicense() throws Exception {
        LicenseForTruck.insertLicense("mona", "123");
        LicenseTypeForTruck returned = LicenseForTruck.retrieveLicense("123");
        Assert.assertEquals(returned.getTruckModel(), "mona");
    }
}
