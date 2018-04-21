package BL;
import DAL.Trucks;


public class Truck {

    private String id;
    private String model;
    private String color;
    private int netoWeight;
    private int maxWeight;

    public Truck(String id, String model, String color, int netoWeight, int maxWeight) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.netoWeight = netoWeight;
        this.maxWeight = maxWeight;
    }

    public void insertTruck() {
    Trucks.insertTruck(id, model,color, netoWeight, maxWeight );
}

}
