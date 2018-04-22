package PL.retrieveHandlers;

import BL.Entities.Truck;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

import java.util.Scanner;

public class RetrieveTruck extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String id = reader.next();
        Truck truck = TruckFunctions.retrieveTruck(id);
        System.out.println(truck.toString());
        System.out.println("Success!!!!");
    }
}
