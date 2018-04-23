package PL.insertHandlers;


import BL.Entities.*;
import BL.EntitiyFunctions.*;
import PL.Functor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import PL.Utils;

public class InsertDelivery extends Functor{

    static Scanner reader = new Scanner(System.in);
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat Hourformat = new SimpleDateFormat("h:mm");


    @Override
    public void execute() {
        java.sql.Date leavingDate;
        java.sql.Time leavingHour;
        System.out.println("enter delivery id");
        String deliveryId = reader.next();
        try {
            if (DeliveryFunctions.isExist(deliveryId)){
                System.out.println("delivery already exists");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("enter date in format: 'dd.MM.yyyy' ");
        leavingDate = Utils.readDate(format);
        System.out.println("enter hour in format: 'h:mm' ");
        try {
            leavingHour = Utils.readHour(Hourformat);
        } catch (ParseException e) {
            System.out.println("error: insertion failed");
            return;
        }
        System.out.println("enter truck id");
        String truckId = reader.next();
        try {
            if (!TruckFunctions.isExist(truckId)){
                System.out.println("truck does not exists");
                return;
            }
        } catch (Exception e) {
            System.out.println("error: insertion failed");
            return;
        }
        Truck truck = TruckFunctions.retrieveTruck(truckId);
        System.out.println("enter driver id");
        String driverId = reader.next();
        try {
            if (!DriverFunctions.isExist(driverId)){
                System.out.println("driver does not exist");
                return;
            }
        } catch (Exception e) {
            System.out.println("error: insertion failed");
            return;
        }
        Driver driver = DriverFunctions.retrieveDriver(driverId);
        if (!DeliveryFunctions.isDriverSuitableForTruck(driver, truck)){
            System.out.println("driver cannot drive this truck!");
            return;
        }
        System.out.println("enter source id");
        String placeId = reader.next();
        try {
            if (!PlaceFunctions.isExist(placeId)){
                System.out.println("place does not exist");
                return;
            }
        } catch (Exception e) {
            System.out.println("error: insertion failed");
            return;
        }
        Place place = PlaceFunctions.retrievePlace(placeId);
        String firstDest = InsertDeliveryDestination.insertDestination(deliveryId); //insert first dest
        if (firstDest==null)
            return;
        while (Utils.boolQuery("do you want to add destination? y/n")) {
            String dest = InsertDeliveryDestination.insertDestination(deliveryId);
        }
        List dests = DeliveryDestinationFunctions.retrieveDeliveryDestination(deliveryId);

        //TODO:: think maybe enter a place *name* and then look for it's identifier in the data base
        Delivery delivery = new Delivery(deliveryId, leavingDate, leavingHour, truck, driver, place, dests);
        DeliveryFunctions.insertDelivery(delivery);
        System.out.println("Success!!!!");
    }
}
