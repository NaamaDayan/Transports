package PL.removeHandlers;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

import java.util.Scanner;

/**
 * Created by Naama on 21/04/2018.
 */
public class RemoveTruck extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter truck id");
        String truckId = reader.next();
        TruckFunctions.removeTruck(truckId);
    }
}
