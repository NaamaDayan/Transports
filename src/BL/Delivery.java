package BL;
import DAL.Deliveries;

public class Delivery {
    public static void insertDelivery(String id, java.sql.Date date, java.sql.Date hour, String truckId, String driverId, String orderId, String placeId) {
        Deliveries.insertDeivery(id, date, hour, truckId, driverId, orderId, placeId);
    }
}
