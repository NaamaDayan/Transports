package PL.removeHandlers;
import BL.Entities.Delivery;
import BL.EntitiyFunctions.DeliveryFunctions;
import PL.Functor;

import java.util.Scanner;

/**
 * Created by Shahar on 22/04/2018.
 */
public class RemoveDelivery extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter delivery id");
        String id = reader.next();
        try {
            if (!DeliveryFunctions.isExist(id)) {
                System.out.println("error: delivery doesn't exist");
                return;
            }
            DeliveryFunctions.removeDelivery(id);
        } catch (Exception e) {
            System.out.println("error: remove failed");
            return;
        }
    }
}
