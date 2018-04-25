import BL.Entities.Truck;
import BL.Entities.TruckModel;
import DAL.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

/**
 * Created by Naama on 23/04/2018.
 */

public class DeliveryDestinationsTests {
    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }

    @Test
    public void isDestExistInDelivery() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat hourformat = new SimpleDateFormat("h:mm");
        Date date = new java.sql.Date(format.parse("12.12.2012", new ParsePosition(0)).getTime());
        java.sql.Time hour = new java.sql.Time(new Time(hourformat.parse("14:12").getTime()).getTime());
        TruckModel m1 = new TruckModel("1", "bla");
        Truck t = new Truck("12", m1, "red", 123, 350);
        Trucks.insertTruck(t);
        Drivers.insertDriver("12", "roni" ,"shtern", "0502242");
        Places.insertPlace("12", "yerushalmi", "03053", "noy");
        Deliveries.insertDeivery("123",date, hour, "12", "12", "12");
        DeliveryDestinations.insertDeliveryDestination("123", "12", null);
        Assert.assertTrue(DeliveryDestinations.isDestExistInDelivery("123", "12"));
        Assert.assertFalse(DeliveryDestinations.isDestExistInDelivery("123", "16"));

    }

}
