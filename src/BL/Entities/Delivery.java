package BL.Entities;
import DAL.Deliveries;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Delivery {
    private String id;
    private java.sql.Date date;
    private java.sql.Time hour;
    private Truck truck;
    private Driver driver;
    private Place source;
    private List<DeliveryDestination> destinations;

    public Delivery(String id, Date date, Time hour, Truck truckId, Driver driverId, Place source, List<DeliveryDestination> destinations) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.truck= truckId;
        this.driver= driverId;
        this.source = source;
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        String dests = "{";
        for (DeliveryDestination dest: destinations)
            dests= dests+ dest.toString()+ ", ";
        dests = dests.substring(0, dests.length()-2);
        dests += "}";
        return "Delivery{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", truckId='" + truck.toString()+ '\'' +
                ", driverId='" + driver.toString() + '\'' +
                ", sourceId='" + source.toString() + '\'' +
                ", destinations ='" + dests+ '\''+
                '}';
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Time getHour() {
        return hour;
    }

    public Truck getTruck() {
        return truck;
    }

    public Driver getDriver() {
        return driver;
    }

    public Place getSource() {
        return source;
    }

    public List<DeliveryDestination> getDestinations() {
        return destinations;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setSource(Place source) {
        this.source = source;
    }

    public void setDestinations(List<DeliveryDestination> destinations) {
        this.destinations = destinations;
    }
}
