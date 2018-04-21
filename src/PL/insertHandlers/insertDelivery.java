package PL.insertFunctions;


import BL.EntitiyFunctions.DeliveryFunctions;
import PL.Functor;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Scanner;
import BL.Entities.Delivery;

public class InsertDelivery extends Functor{

    static Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat Hourformat = new SimpleDateFormat("h:mm a");


    @Override
    public void execute() {
        java.sql.Date leavingDate;
        java.sql.Date leavingHour;
        System.out.println("enter delivery id");
        String deliveryId = reader.next();
        System.out.println("enter date in format: 'dd.MM.yyyy' ");
        leavingDate = readDate(format, "dd.MM.yyyy");
        System.out.println("enter hour in format: 'h:mm a' ");
        leavingHour = readDate(Hourformat, "h:mm a");
        System.out.println("enter truck id");
        String truckId = reader.next();
        System.out.println("enter driver id");
        String driverId = reader.next();
        System.out.println("enter order id");
        String orderId = reader.next();
        System.out.println("enter place id");
        //TODO:: think maybe enter a place *name* and then look for it's identifier in the data base
        String placeId = reader.next();
        Delivery delivery = new Delivery(deliveryId, leavingDate, leavingHour, truckId, driverId, orderId, placeId);
        DeliveryFunctions.insertDelivery(delivery);
        System.out.println("Success!!!!");
    }

    private static java.sql.Date readDate(SimpleDateFormat format ,String form){
        String dateString = reader.next();
        java.sql.Date sqlDate;
        java.util.Date date = format.parse(dateString, new ParsePosition(0));
        if (date!=null) {
            sqlDate = new java.sql.Date(date.getTime());
            java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
            while (sqlDate==null){
                System.out.println("insert legal date - the format is: " + form);
                sqlDate = readDate(format, form);
            }
            return sqlDate;
        }
        System.out.println("insert legal date - the format is: "+ form);
        return readDate(format, form);
    }
}
