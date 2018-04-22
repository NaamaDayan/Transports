package BL.EntitiyFunctions;

import BL.Entities.Delivery;
import BL.Entities.Place;
import DAL.Deliveries;
import DAL.DeliveryDestinations;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryDestinationFunctions {

    public static void insertDelivery(Delivery delivery) {
        Deliveries.insertDeivery(delivery.getId(), delivery.getDate(), delivery.getHour(),
                delivery.getOrderId(), delivery.getTruckId(), delivery.getDriverId(), delivery.getSourceId());
        List<Place> dests = delivery.getDestinations();
        for (Place place: dests)
            DeliveryDestinations.insertDeliveryDestination(delivery.getId(), place.getId());
    }

    public static Delivery retrieveDelivery(String id){
        return Deliveries.retrieveDelivery(id);
    }

    public static void removeDeliveryDetination(String deliveryId, String destId) {
        if (DeliveryDestinations.isDestExistInDelivery(deliveryId, destId))
            DeliveryDestinations.removeDeliveryDestination(deliveryId, destId);
        else {
            //todo: some error
        }
    }
}
