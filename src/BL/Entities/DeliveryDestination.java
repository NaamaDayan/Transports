package BL.Entities;
import DAL.DeliveryDestinations;
/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryDestination {

    private String deliveryId;
    private String destId;

    public DeliveryDestination(String deliveryId, String destId) {
        this.deliveryId = deliveryId;
        this.destId = destId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getDestId() {
        return destId;
    }




}
