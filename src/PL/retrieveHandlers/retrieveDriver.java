package PL.retrieveHandlers;

<<<<<<< HEAD
import BL.Entities.Driver;
import BL.EntitiyFunctions.DriverFunctions;
import PL.Functor;

import java.util.Scanner;

public class retrieveDriver extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String id = reader.next();
        Driver driver = DriverFunctions.retrieveDriver(id);
        System.out.println(driver.toString());
=======
import PL.Functor;

public class retrieveDriver extends Functor {
    @Override
    public void execute() {
>>>>>>> master
        System.out.println("Success!!!!");
    }
}
