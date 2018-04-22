package PL.retrieveHandlers;

import BL.Entities.Place;
import BL.EntitiyFunctions.PlaceFunctions;
import PL.Functor;

import java.util.Scanner;

public class RetrievePlace extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter place id");
        String id = reader.next();
        try {
            if (!PlaceFunctions.isExist(id)){
                System.out.println("id does not exist");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Place place = PlaceFunctions.retrievePlace(id);
        System.out.println(place.toString());
        System.out.println("Success!!!!");
    }
}
