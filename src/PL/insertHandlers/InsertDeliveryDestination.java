package PL.insertHandlers;

import BL.Entities.DeliveryDestination;
import BL.EntitiyFunctions.DeliveryDestinationFunctions;
import BL.EntitiyFunctions.DeliveryFunctions;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;

import javax.swing.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Naama on 23/04/2018.
 */
public class InsertDeliveryDestination extends Functor{
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() throws ParseException {
        System.out.println("insert delivery id:");
        String deliveryId = reader.next();
        try {
            if (!DeliveryFunctions.isExist(deliveryId)) {
                System.out.println("delivery id does not exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        insertDestination(deliveryId);

    }

    public static String insertDestination(String deliveryId){
        System.out.println("insert destination id:");
        String dest = reader.next();
        try {
            if (!PlaceFunctions.isExist(dest)) {
                System.out.println("place id does not exist");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("insert order number for this destination:");
        String order = reader.next();
        DeliveryDestination d = new DeliveryDestination(deliveryId, dest, order);
        DeliveryDestinationFunctions.insertDeliveryDestination(d);
        return dest;
    }
}
