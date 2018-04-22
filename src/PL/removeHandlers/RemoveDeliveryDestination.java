package PL.removeHandlers;
import BL.EntitiyFunctions.DeliveryDestinationFunctions;
import PL.Functor;

import java.util.Scanner;

/**
 * Created by Shahar on 22/04/2018.
 */
public class RemoveDeliveryDestination extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter delivery id");
        String deliveryId = reader.next();
        System.out.println("enter destination id");
        String destId = reader.next();
        DeliveryDestinationFunctions.removeDeliveryDetination(deliveryId, destId);
    }
}
