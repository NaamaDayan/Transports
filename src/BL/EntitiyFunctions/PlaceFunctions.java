package BL.EntitiyFunctions;

import BL.Entities.Place;
import DAL.Places;

/**
 * Created by Naama on 21/04/2018.
 */
public class PlaceFunctions {

    public static void insertPlace(Place place){

        Places.insertPlace(place.getId(), place.getAddress(), place.getPhoneNumber(), place.getContactName());
    }

    public static Place retrievePlace(String id){
        return Places.retrievePlace(id);
    }


}
