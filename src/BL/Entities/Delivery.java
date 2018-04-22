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
    private String orderId;
    private Place source;
    private List<Place> destinations;

    public Delivery(String id, Date date, Time hour, Truck truckId, Driver driverId, String orderId, Place source, List<Place> destinations) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.truck= truckId;
        this.driver= driverId;
        this.orderId = orderId;
        this.source = source;
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        String dests = "{";
        for (Place dest: destinations)
            dests= dests+ dest.toString()+ ", ";
        dests = dests.substring(0, dests.length()-2);
        dests += "}";
        return "Delivery{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", truckId='" + truck.toString()+ '\'' +
                ", driverId='" + driver.toString() + '\'' +
                ", orderId='" + orderId + '\'' +
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

    public String getOrderId() {
        return orderId;
    }

    public Place getSource() {
        return source;
    }

    public List<Place> getDestinations() {
        return destinations;
    }
}
