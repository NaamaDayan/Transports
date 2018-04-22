package BL.EntitiyFunctions;

import BL.Entities.Truck;
import DAL.ErrorsHandler;
import DAL.Trucks;

import java.sql.SQLException;

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

    public static void removeTruck(String id){
        Trucks.removeTruck(id);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isTruckExist(id);
    }
}
