package PL.insertHandlers;

import PL.Functor;

import java.util.Scanner;
import BL.Truck;
public class insertTruck extends Functor {
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
        Truck.insertTruck(truckId, truckModel, truckColor, netoWeight, maxWeight);
        System.out.println("Success!!!!");
    }
}