package PL.retrieveHandlers;

<<<<<<< HEAD
<<<<<<< HEAD
import BL.Entities.Delivery;
import BL.EntitiyFunctions.DeliveryFunctions;
import PL.Functor;

import java.util.Scanner;

public class retrieveDelivery extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter delivery id");
        String id = reader.next();
        Delivery delivery = DeliveryFunctions.retrieveDelivery(id);
        System.out.println(delivery.toString());
=======
=======
>>>>>>> master
import PL.Functor;

public class retrieveDelivery extends Functor {
    @Override
    public void execute() {
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
        System.out.println("Success!!!!");
    }
}
