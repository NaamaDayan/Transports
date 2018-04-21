package PL.insertFunctions;

import PL.Functor;

import java.util.Scanner;
import BL.DeliveryDestination;
/**
 * Created by Naama on 21/04/2018.
 */
public class InsertDeliveryDestination extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter delivery id");
        String deliveryId = reader.next();
        System.out.println("enter destination id");
        String destinationId = reader.next();
        DeliveryDestination deliveryDestination = new DeliveryDestination(deliveryId, destinationId);
        deliveryDestination.insertDeliveryDestination();
        System.out.println("Success!!!!");
    }
}
