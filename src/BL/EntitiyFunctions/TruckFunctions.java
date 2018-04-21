package BL.EntitiyFunctions;

import BL.Entities.Truck;
import DAL.Trucks;

/**
 * Created by Naama on 21/04/2018.
 */
public class TruckFunctions
{
    public static void insertTruck(Truck truck) {
        Trucks.insertTruck(truck.getId(), truck.getModel(), truck.getColor(), truck.getNetoWeight(), truck.getMaxWeight());
    }

    public static Truck retrieveTruck(String id){
        return Trucks.retrieveTruck(id);
    }

}
