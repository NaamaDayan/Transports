package BL.EntitiyFunctions;

import BL.Entities.Place;
import DAL.ErrorsHandler;
import DAL.Places;

import java.sql.SQLException;

/**
 * Created by Naama on 21/04/2018.
 */
public class PlaceFunctions {

    public static void insertPlace(Place place){

        Places.insertPlace(place.getId(), place.getAddress(), place.getPhoneNumber(), place.getContactName());
    }

    public static boolean isIdExist(String placeId) throws SQLException, ClassNotFoundException {
        return ErrorsHandler.isPlaceExist(placeId);
    }

    public static Place retrievePlace(String id){
        return Places.retrievePlace(id);
    }

    public static void removePlace(String id){
        Places.removePlace(id);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isPlaceExist(id);
    }

}
