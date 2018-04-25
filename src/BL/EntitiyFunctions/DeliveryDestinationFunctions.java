package BL.EntitiyFunctions;

import BL.Entities.DeliveryDestination;
import DAL.DeliveryDestinations;
import DAL.ErrorsHandler;
import DAL.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryDestinationFunctions {

    public static void removeDeliveryDestination(String deliveryId, String destId) throws SQLException, ClassNotFoundException {
        DeliveryDestinations.removeDeliveryDestination(deliveryId, destId);
    }

    public static void insertDeliveryDestination(DeliveryDestination d, String deliveryId){
        DeliveryDestinations.insertDeliveryDestination(deliveryId, d.getDestination().getId(), d.getOrder());
    }

    public static List<DeliveryDestination> retrieveDeliveryDestination(String deliveryId){
        return DeliveryDestinations.retrieveDeliveryDestinations(deliveryId);
    }

    public static boolean isExist(String deliveryId, String destId) throws Exception {
        return ErrorsHandler.isDeliveryDestinationExist(deliveryId, destId);
    }
}
