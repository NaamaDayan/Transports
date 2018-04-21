package BL.Entities;
import DAL.Deliveries;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Delivery {
    private String id;
    private java.sql.Date date;
    private java.sql.Time hour;
    private String truckId;
    private String driverId;
    private String orderId;
    private String sourceId;
    private List<String> destinations;

    public Delivery(String id, Date date, Time hour, String truckId, String driverId, String orderId, String sourceId, List<String> destinations) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.truckId = truckId;
        this.driverId = driverId;
        this.orderId = orderId;
        this.sourceId = sourceId;
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        String dests = "{";
        for (String dest: destinations)
            dests= dests+ dest+ ", ";
        dests = dests.substring(0, dests.length()-2);
        dests += "}";
        return "Delivery{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", truckId='" + truckId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", sourceId='" + sourceId + '\'' +
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

    public String getTruckId() {
        return truckId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public List<String> getDestinations() {
        return destinations;
    }
}
