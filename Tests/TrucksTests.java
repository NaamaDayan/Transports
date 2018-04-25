import BL.Entities.Truck;
import BL.Entities.TruckModel;
import DAL.CreateTables;
import DAL.Models;
import DAL.Trucks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;

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
    public void insertTruck() throws SQLException {
        TruckModel m1 = new TruckModel("1", "mercedes");
        Models.insertModel(m1);
        //insert new truck
        String id = "123";
        String modelID = "1";
        String color = "yellow";
        int netoWeight = 3500;
        int maxWeight = 4000;
        Truck t = new Truck(id, m1, color, netoWeight, maxWeight);
        Trucks.insertTruck(t);
        Truck truck = Trucks.retrieveTruck(id);
        Assert.assertEquals(truck.getId(), id);
        Assert.assertEquals(truck.getColor(), color);
        Assert.assertEquals(truck.getModel().getId(), modelID);
        Assert.assertEquals(truck.getNetoWeight(), netoWeight);
        Assert.assertEquals(truck.getMaxWeight(), maxWeight);
    }


    @Test
    public void retrieveTruck() {
        Truck truck = Trucks.retrieveTruck("242728247247247247"); //does not exist
        Assert.assertTrue(truck==null);
    }

    @Test
    public void updateModelTruck() throws Exception {
        TruckModel m1 = new TruckModel("1", "mercedes");
        TruckModel m2 = new TruckModel("2", "lamburgini");
        Models.insertModel(m1);
        Models.insertModel(m2);
        String id = "234";
        String model = "1";
        String color = "yellow";
        int netoWeight = 3500;
        int maxWeight = 4000;
        Truck t = new Truck(id, m1, color, netoWeight, maxWeight);
        Trucks.insertTruck(t);
        Truck updated = new Truck("234", m2, "yellow", 3200, 4000);
        Trucks.updateTruck(updated);
        Truck truck = Trucks.retrieveTruck("234");
        Assert.assertEquals("234", truck.getId());
        Assert.assertEquals("yellow", truck.getColor());
        Assert.assertEquals("2", truck.getModel().getId());
        Assert.assertEquals(3200, truck.getNetoWeight());
        Assert.assertEquals(4000, truck.getMaxWeight());
    }

}
