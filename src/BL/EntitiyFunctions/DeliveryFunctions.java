package BL.EntitiyFunctions;

import BL.Entities.*;
import DAL.*;

import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryFunctions {

    public static void insertDelivery(Delivery delivery) {
        Deliveries.insertDeivery(delivery.getId(), delivery.getDate(), delivery.getHour(),
                delivery.getOrderId(), delivery.getTruck().getId(), delivery.getDriver().getId(), delivery.getSource().getId());
        List<Place> dests = delivery.getDestinations();
        for (Place place: dests)
            DeliveryDestinations.insertDeliveryDestination(delivery.getId(), place.getId());
    }

    public static Delivery retrieveDelivery(String id){
        return Deliveries.retrieveDelivery(id);
    }

    public static void removeDelivery(String id){
        Deliveries.removeDelivery(id);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isDeliveryExist(id);
    }

    public static boolean isDriverSuitableForTruck(Driver driver, Truck truck){
        return Deliveries.DoesDriverHaveLicense(driver.getId(), truck.getModel());
    }
}
