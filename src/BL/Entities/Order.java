package BL.Entities;
import java.util.Map;

/**
 * Created by Naama on 25/04/2018.
 */
public class Order
{
    private String orderNumber;
    private Map<String, Integer> Itemquantities;

    public Order(String orderNumber, Map<String, Integer> itemquantities) {
        this.orderNumber = orderNumber;
        Itemquantities = itemquantities;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Map<String, Integer> getItemquantities() {
        return Itemquantities;
    }

    @Override
    public String toString() {
        String quans = "{";
        for (Map.Entry entry: Itemquantities.entrySet())
            quans = quans + entry.getKey()+": "+entry.getValue()+ ", ";
        if (quans.length()>1)
            quans = quans.substring(0, quans.length()-2);
        return "Order{" +
                "orderNumber =" + orderNumber +
                ", Item quantities =" + Itemquantities +
                '}';
    }
}
