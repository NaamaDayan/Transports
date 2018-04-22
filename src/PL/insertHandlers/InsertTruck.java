package PL.insertHandlers;

import BL.Entities.Truck;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

import java.util.Scanner;
public class InsertTruck extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter truck id");
        String truckId = reader.next();
        System.out.println("enter truck model");
        String truckModel = reader.next();
        System.out.println("enter truck color");
        String truckColor = reader.next();
        System.out.println("enter truck neto weight");
        int netoWeight = reader.nextInt();
        System.out.println("enter truck max weight");
        int maxWeight = reader.nextInt();
        Truck t = new Truck(truckId, truckModel, truckColor, netoWeight, maxWeight);
        TruckFunctions.insertTruck(t);
        System.out.println("Success!!!!");
    }
}