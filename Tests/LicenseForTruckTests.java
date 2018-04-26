package Tests;

import BL.Entities.LicenseTypeForTruck;
import BL.Entities.TruckModel;
import DAL.CreateTables;
import DAL.LicenseForTruck;
import DAL.Models;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
        TruckModel m1 = new TruckModel("1", "mona");
        Models.insertModel(m1);
        LicenseForTruck.insertLicense(m1, "123");
        LicenseTypeForTruck returned = LicenseForTruck.retrieveLicense("123");
        Assert.assertEquals("1", returned.getTruckModelId().getId());
    }
}
