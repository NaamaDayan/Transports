package PL.insertHandlers;


import BL.Truck;
import PL.Functor;

import java.util.Scanner;
import BL.Driver;

public class insertDriver extends Functor{
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String driverId = reader.next();
        System.out.println("enter first name");
        String firstName = reader.next();
        System.out.println("enter last name");
        String lastName = reader.next();
        System.out.println("enter phone number");
        String phoneNumber = reader.next();
        Driver.insertDriver(driverId, firstName, lastName, phoneNumber);
        System.out.println("Success!!!!");
    }
}
