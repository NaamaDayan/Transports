package BL.EntitiyFunctions;

import BL.Entities.Delivery;
import BL.Entities.DeliveryDestination;
import BL.Entities.Place;
import DAL.Deliveries;
import DAL.DeliveryDestinations;

import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryFunctions {

    public static void insertDelivery(Delivery delivery) {
        Deliveries.insertDeivery(delivery.getId(), delivery.getDate(), delivery.getHour(),
                delivery.getOrderId(), delivery.getTruckId(), delivery.getDriverId(), delivery.getSourceId());
        List<String> dests = delivery.getDestinations();
        for (String placeId: dests)
            DeliveryDestinations.insertDeliveryDestination(delivery.getId(), placeId);
    }

    public static Delivery retrieveDelivery(String id){
        return Deliveries.retrieveDelivery(id);
    }

}
