package BL.Entities;

/**
 * Created by Naama on 23/04/2018.
 */
public class DeliveryDestination {

    private String deliveryId;
    private String destId;
    private String orderNumber;

    public DeliveryDestination(String deliveryId, String destId, String orderNumber) {
        this.deliveryId = deliveryId;
        this.destId = destId;
        this.orderNumber = orderNumber;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getDestId() {
        return destId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
