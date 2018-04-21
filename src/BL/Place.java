package BL;
import DAL.Places;

public class Place {

    private String id;
    private String address;
    private String phoneNumber;
    private String contactName;

    public Place(String id, String address, String phoneNumber, String contactName) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
    }

    public void insertPlace(){
        Places.insertPlace(id, address, phoneNumber, contactName);
    }


}
