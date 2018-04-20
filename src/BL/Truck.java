package BL;
import DAL.Trucks;


public class Truck {

public static void insertTruck(String id, String model, String color, int netoWeight, int maxWeight) {
    Trucks.insertTruck(id, model,color, netoWeight, maxWeight );
}

}
