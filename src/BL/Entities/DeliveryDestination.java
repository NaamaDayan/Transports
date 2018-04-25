package BL.Entities;

/**
 * Created by Naama on 23/04/2018.
 */
public class DeliveryDestination {
    private Place destination;
    private String orderNumber;

    public DeliveryDestination(Place destination, String orderNumber) {
        this.destination = destination;
        this.orderNumber = orderNumber;
    }


    public Place getDestination() {
        return destination;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "DeliveryDestination{" +
                ", destination ='" + destination + '\'' +
                ", orderNumber ='" + orderNumber + '\'' +
                '}';
    }
}
