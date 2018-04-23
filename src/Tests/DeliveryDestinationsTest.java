package Tests;
import BL.Entities.DeliveryDestination;
import DAL.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */

public class DeliveryDestinationsTest {
    @Before
    public void initDataBase(){
        CreateTables.initDB();
    }

    @Test
    public void insertDeliveryDestination() throws Exception {

    }

    @Test
    public void removeDeliveryDestination() throws Exception {
    }

    @Test
    public void isDestExistInDelivery() throws Exception {
        Date date = new Date(2012, 12, 12);
        Time hour = new Time(23, 12,00);
        Trucks.insertTruck("12", "bla", "red", 123, 350);
        Drivers.insertDriver("12", "roni" ,"shtern", "0502242");
        Places.insertPlace("12", "yerushalmi", "03053", "noy");
        Deliveries.insertDeivery("123",date, hour, "12", "12", "12");
        DeliveryDestinations.insertDeliveryDestination("123", "12", "456");
        Assert.assertTrue(DeliveryDestinations.isDestExistInDelivery("123", "12"));
        Assert.assertFalse(DeliveryDestinations.isDestExistInDelivery("123", "16"));

    }

    @Test
    public void retrieveDeliveryDestination() throws Exception {
    }



}
