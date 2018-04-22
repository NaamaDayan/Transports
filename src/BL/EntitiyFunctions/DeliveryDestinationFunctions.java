package BL.EntitiyFunctions;

import BL.Entities.Delivery;
import BL.Entities.DeliveryDestination;
import BL.Entities.Place;
import DAL.Deliveries;
import DAL.DeliveryDestinations;
import DAL.ErrorsHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryDestinationFunctions {

    public static void removeDeliveryDestination(String deliveryId, String destId) throws SQLException, ClassNotFoundException {
        DeliveryDestinations.removeDeliveryDestination(deliveryId, destId);
    }

    public static void insertDeliveryDestination(DeliveryDestination d){
        DeliveryDestinations.insertDeliveryDestination(d.getDeliveryId(), d.getDestId(), d.getOrderNumber());
    }

    public static List<DeliveryDestination> retrieveDeliveryDestination(String deliveryId){
        return DeliveryDestinations.retrieveDeliveryDestination(deliveryId);
    }

    public static boolean isExist(String deliveryId, String destId) throws Exception {
        return ErrorsHandler.isDeliveryDestinationExist(deliveryId, destId);
    }
}
