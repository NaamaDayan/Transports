package PL.insertHandlers;


import BL.Entities.Driver;
import BL.Entities.Place;
import BL.Entities.Truck;
import BL.EntitiyFunctions.DeliveryFunctions;
import BL.EntitiyFunctions.DriverFunctions;
import BL.EntitiyFunctions.PlaceFunctions;
import BL.EntitiyFunctions.TruckFunctions;
import PL.Functor;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import BL.Entities.Delivery;

public class InsertDelivery extends Functor{

    static Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat Hourformat = new SimpleDateFormat("h:mm");


    @Override
    public void execute() throws ParseException {
        java.sql.Date leavingDate;
        java.sql.Time leavingHour;
        System.out.println("enter delivery id");
        String deliveryId = reader.next();
        System.out.println("enter date in format: 'dd.MM.yyyy' ");
        leavingDate = readDate(format);
        System.out.println("enter hour in format: 'h:mm' ");
        leavingHour = readHour(Hourformat);
        System.out.println("enter truck id");
        String truckId = reader.next();
        Truck truck = TruckFunctions.retrieveTruck(truckId);
        System.out.println("enter driver id");
        String driverId = reader.next();
        Driver driver = DriverFunctions.retrieveDriver(driverId);
        System.out.println("enter order id");
        String orderId = reader.next();
        System.out.println("enter place id");
        String placeId = reader.next();
        Place place = PlaceFunctions.retrievePlace(placeId);
        System.out.println("enter destination:");
        String firstDest = reader.next();
        List<String> destinations = new LinkedList<>();
        destinations.add(firstDest);
        while (boolQuery("do you want to add destination? y/n")){
            String dest = reader.next();
            destinations.add(dest);
        }
        List<Place> destinationPlaces = new LinkedList<>();
        for (String dest: destinations){
            destinationPlaces.add(PlaceFunctions.retrievePlace(dest));
        }
        //TODO:: think maybe enter a place *name* and then look for it's identifier in the data base
        Delivery delivery = new Delivery(deliveryId, leavingDate, leavingHour, truck, driver, orderId, place, destinationPlaces);
        DeliveryFunctions.insertDelivery(delivery);
        System.out.println("Success!!!!");
    }


    private static boolean boolQuery(String input){
        System.out.println(input);
        String isLegal = reader.next();
        while (!isLegal.equals("y") && !isLegal.equals("n")){
            System.out.println("insert y or n only");
            isLegal = reader.next();
        }
        return isLegal.equals("y");
    }

    private static java.sql.Time readHour(SimpleDateFormat format) throws ParseException {
        String timeString = reader.next();
        java.sql.Time sqlTime;
        long ms = format.parse(timeString).getTime();
        Time time = new Time(ms);
        if (time!=null) {
            sqlTime = new java.sql.Time(time.getTime());
            while (sqlTime==null){
                System.out.println("insert legal time - the format is: h:mm");
                sqlTime = readHour(format);
            }
            return sqlTime;
        }
        else
            System.out.println("insert legal date - the format is: h:mm");
        return readHour(format);
    }


    private static java.sql.Date readDate(SimpleDateFormat format){
        String dateString = reader.next();
        java.sql.Date sqlDate;
        java.util.Date date = format.parse(dateString, new ParsePosition(0));
        if (date!=null) {
            sqlDate = new java.sql.Date(date.getTime());
            while (sqlDate==null){
                System.out.println("insert legal date - the format is: dd.MM.yyyy");
                sqlDate = readDate(format);
            }
            return sqlDate;
        }
        else
            System.out.println("insert legal date - the format is: dd.MM.yyyy");
        return readDate(format);
    }
}
