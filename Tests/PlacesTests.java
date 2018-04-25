package Tests;

import BL.Entities.Place;
import BL.Entities.Truck;
import DAL.CreateTables;
import DAL.Places;
import DAL.Trucks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Naama on 23/04/2018.
 */
public class PlacesTests {
    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }

    @Test
    public void insertPlace() throws Exception {
        String placeId = "123";
        String address = "hana";
        String phoneNumber = "0502636307";
        String contactName = "Moshe";
        Places.insertPlace(placeId, address, phoneNumber, contactName);
        Place returned = Places.retrievePlace(placeId);
        Assert.assertEquals(returned.getId(), placeId);
        Assert.assertEquals(returned.getAddress(), address);
        Assert.assertEquals(returned.getPhoneNumber(), phoneNumber);
        Assert.assertEquals(returned.getContactName(), contactName);
    }

    @Test
    public void retrievePlace() throws Exception {
        Place place = Places.retrievePlace("25725725727"); //does not exist
        Assert.assertTrue(place==null);
    }

    @Test
    public void updatePlace() throws Exception {
        String placeId = "234";
        String address = "hana";
        String phoneNumber = "0502636307";
        String contactName = "Moshe";
        Places.insertPlace(placeId, address, phoneNumber, contactName);
        Place updated = new Place("234", "lamburgini","242472472", "john");
        Places.updatePlace(updated);
        Place place = Places.retrievePlace("234");
        Assert.assertEquals(place.getId(), "234");
        Assert.assertEquals(place.getAddress(), "lamburgini");
        Assert.assertEquals(place.getPhoneNumber(), "242472472");
        Assert.assertEquals(place.getContactName(), "john");
    }

}
