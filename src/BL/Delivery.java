package BL;
import DAL.Deliveries;

import java.sql.Date;

public class Delivery {
    private String id;
    private java.sql.Date date;
    private java.sql.Date hour;
    private String truckId;
    private String driverId;
    private String orderId;
    private String sourceId;

    public Delivery(String id, Date date, Date hour, String truckId, String driverId, String orderId, String sourceId) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.truckId = truckId;
        this.driverId = driverId;
        this.orderId = orderId;
        this.sourceId = sourceId;
    }

    public void insertDelivery() {
        Deliveries.insertDeivery(id, date, hour, truckId, driverId, orderId, sourceId);
    }
}
