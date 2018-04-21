package PL.retrieveHandlers;

import BL.Entities.Place;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;

import java.util.Scanner;

public class retrievePlace extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter place id");
        String id = reader.next();
        Place place = PlaceFunctions.retrievePlace(id);
        System.out.println(place.toString());
    }
}
