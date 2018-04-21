package PL.insertHandlers;


import BL.EntitiyFunctions.DriverFunctions;
import PL.Functor;

import java.util.Scanner;
import BL.Entities.Driver;

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
        Driver driver = new Driver(driverId, firstName, lastName, phoneNumber);
        DriverFunctions.insertDriver(driver);
        System.out.println("Success!!!!");
    }
}
