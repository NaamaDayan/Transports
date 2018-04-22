package PL.removeHandlers;
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
        DeliveryFunctions.removeDelivery(id);
    }
}
