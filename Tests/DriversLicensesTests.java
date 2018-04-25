import BL.Entities.LicenseTypeForTruck;
import BL.Entities.TruckModel;
import DAL.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.LinkedList;
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
        TruckModel model1 = new TruckModel("12", "mona");
        TruckModel model2 = new TruckModel("13", "lisa");
        Models.insertModel(model1);
        Models.insertModel(model2);
        Drivers.insertDriver("123", "noy", "barak", "050253");
        LicenseForTruck.insertLicense(model1, "001");
        LicenseForTruck.insertLicense(model2, "002");
        DriversLicenses.insertDriverLicense("123", "001");
        DriversLicenses.insertDriverLicense("123", "002");
        List<LicenseTypeForTruck> returned = DriversLicenses.retrieveDriverLicenses("123");

        List<LicenseTypeForTruck> expected = new LinkedList<>();
        expected.add(new LicenseTypeForTruck("001", model1));
        expected.add(new LicenseTypeForTruck("002", model2));
        assertTrue(returned.size() == expected.size());
        assertTrue(returned.get(0).getLicenseType().equals(expected.get(0).getLicenseType()));
        assertTrue(returned.get(1).getLicenseType().equals(expected.get(1).getLicenseType()));

    }
}
