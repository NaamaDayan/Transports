package PL.retrieveHandlers;

import BL.Entities.Driver;
import BL.EntitiyFunctions.DriverFunctions;
import PL.Functor;

import java.util.Scanner;

public class RetrieveDriver extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String id = reader.next();
        Driver driver = DriverFunctions.retrieveDriver(id);
        System.out.println(driver.toString());
        System.out.println("Success!!!!");
    }
}