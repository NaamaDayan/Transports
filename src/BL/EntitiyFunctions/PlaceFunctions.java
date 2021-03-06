package BL.EntitiyFunctions;

import BL.Entities.Driver;
import BL.Entities.Place;
import DAL.ErrorsHandler;
import DAL.Drivers;
import DAL.Places;

import java.sql.SQLException;

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

    public static void removePlace(String id){
        Places.removePlace(id);
    }

    public static void updatePlace(Place p) throws SQLException, ClassNotFoundException {
        Places.updatePlace(p);
    }

    public static boolean isExist(String id) throws Exception {
        return ErrorsHandler.isPlaceExist(id);
    }

}
