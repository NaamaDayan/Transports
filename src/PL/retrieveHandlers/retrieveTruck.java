package PL.retrieveHandlers;

<<<<<<< HEAD
<<<<<<< HEAD
import BL.Entities.Truck;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

import java.util.Scanner;

public class retrieveTruck extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String id = reader.next();
        Truck truck = TruckFunctions.retrieveTruck(id);
        System.out.println(truck.toString());
=======
=======
>>>>>>> master
import PL.Functor;

public class retrieveTruck extends Functor {
    @Override
    public void execute() {
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
        System.out.println("Success!!!!");
    }
}
