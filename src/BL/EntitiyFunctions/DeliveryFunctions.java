package BL.EntitiyFunctions;

import BL.Entities.*;
import DAL.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryFunctions {

    public static void insertDelivery(Delivery delivery) {
        Deliveries.insertDeivery(delivery.getId(), delivery.getDate(), delivery.getHour(),
               delivery.getTruck().getId(), delivery.getDriver().getId(), delivery.getSource().getId());
        List<DeliveryDestination> dests = delivery.getDestinations();
        for (DeliveryDestination place: dests)
            DeliveryDestinations.insertDeliveryDestination(place.getDeliveryId(), place.getDestId(), place.getOrderNumber());
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

    public static void updateDelivery(Delivery d) throws SQLException, ClassNotFoundException {
        Deliveries.updateDelivery(d);
    }
}
