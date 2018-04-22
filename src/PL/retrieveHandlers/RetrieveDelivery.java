package PL.retrieveHandlers;

import BL.Entities.Delivery;
import BL.EntitiyFunctions.DeliveryFunctions;
import PL.Functor;

import java.util.Scanner;

public class RetrieveDelivery extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter delivery id");
        String id = reader.next();
        try {
            if (!DeliveryFunctions.isExist(id)){
                System.out.println("delivery does not exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Delivery delivery = DeliveryFunctions.retrieveDelivery(id);
        System.out.println(delivery.toString());
        System.out.println("Success!!!!");
    }
}
