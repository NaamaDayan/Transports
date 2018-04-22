package BL.EntitiyFunctions;

import BL.Entities.Delivery;
import BL.Entities.Place;
import DAL.Deliveries;
import DAL.DeliveryDestinations;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Naama on 21/04/2018.
 */
public class DeliveryDestinationFunctions {

    public static void removeDeliveryDestination(String deliveryId, String destId) throws SQLException, ClassNotFoundException {
        if (DeliveryDestinations.isDestExistInDelivery(deliveryId, destId))
            DeliveryDestinations.removeDeliveryDestination(deliveryId, destId);
        else {
            System.out.println("error: Delivery Destination doesn't exist");
            return;
        }
    }
}
