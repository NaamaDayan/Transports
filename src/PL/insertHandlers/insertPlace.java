package PL.insertHandlers;

<<<<<<< HEAD
<<<<<<< HEAD

import BL.Entities.Place;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;

import java.util.Scanner;

public class insertPlace extends Functor {
    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter place id");
        String placeId = reader.next();
        System.out.println("enter place address");
        String address = reader.next();
        System.out.println("enter place phone number");
        String phoneNumber = reader.next();
        System.out.println("enter place contact name");
        String contactName = reader.next();
        Place place = new Place(placeId, address, phoneNumber, contactName);
        PlaceFunctions.insertPlace(place);
=======
=======
>>>>>>> master
import PL.Functor;

public class insertPlace extends Functor {
    @Override
    public void execute() {
<<<<<<< HEAD
>>>>>>> master
=======
>>>>>>> master
        System.out.println("Success!!!!");
    }
}
