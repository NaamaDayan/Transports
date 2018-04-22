package Tests;


import BL.Entities.Truck;
import DAL.CreateTables;
import DAL.Trucks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Naama on 22/04/2018.
 */
public class TrucksTest {

    @Before
    public void initDataBase(){
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
    public void removeTruck() throws Exception {

    }

    @Test
    public void retrieveTruck() throws Exception {

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

    @Test
    public void updateColorTruck() throws Exception {
    }

    @Test
    public void updateNetoWeightTruck() throws Exception {
    }

    @Test
    public void updateMaxWeightTruck() throws Exception {
    }



}
