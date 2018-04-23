package BL.Entities;

/**
 * Created by Naama on 23/04/2018.
 */
public class DeliveryDestination {

    private String deliveryId;
    private Place destination;
    private String orderNumber;

    public DeliveryDestination(String delivery, Place destination, String orderNumber) {
        this.deliveryId = delivery;
        this.destination = destination;
        this.orderNumber = orderNumber;
    }

    public String getDelivery() {
        return deliveryId;
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
                "delivery ='" + deliveryId + '\'' +
                ", destination ='" + destination + '\'' +
                ", orderNumber ='" + orderNumber + '\'' +
                '}';
    }
}
