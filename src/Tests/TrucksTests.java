package Tests;


import BL.Entities.Truck;
import DAL.CreateTables;
import DAL.Trucks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Naama on 22/04/2018.
 */
public class TrucksTests {

    @Before
    public void initDataBase(){
        File file = new File ("transports.db");
        if (file.exists())
            file.delete();
        CreateTables.initDB();
    }
    @Test
    public void insertTruck() throws Exception {
        //insert new truck
        String id = "123";
        String model = "mercedes";
        String color = "yellow";
        int netoWeight = 3500;
        int maxWeight = 4000;
        Trucks.insertTruck(id, model, color, netoWeight, maxWeight);
        Truck truck = Trucks.retrieveTruck(id);
        Assert.assertEquals(truck.getId(), id);
        Assert.assertEquals(truck.getColor(), color);
        Assert.assertEquals(truck.getModel(), model);
        Assert.assertEquals(truck.getNetoWeight(), netoWeight);
        Assert.assertEquals(truck.getMaxWeight(), maxWeight);

    }


    @Test
    public void retrieveTruck() throws Exception {
        Truck truck = Trucks.retrieveTruck("242728247247247247"); //does not exist
        Assert.assertTrue(truck==null);
    }

    @Test
    public void updateModelTruck() throws Exception {
        String id = "234";
        String model = "mercedes";
        String color = "yellow";
        int netoWeight = 3500;
        int maxWeight = 4000;
        Trucks.insertTruck(id, model, color, netoWeight, maxWeight);
        Truck updated = new Truck("234", "lamburgini", "yellow", 3200, 4000);
        Trucks.updateTruck(updated);
        Truck truck = Trucks.retrieveTruck("234");
        Assert.assertEquals(truck.getId(), "234");
        Assert.assertEquals("yellow", truck.getColor());
        Assert.assertEquals(truck.getModel(), "lamburgini");
        Assert.assertEquals(truck.getNetoWeight(), 3200);
        Assert.assertEquals(truck.getMaxWeight(), 4000);
    }

}
