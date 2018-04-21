package BL.Entities;
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

    @Override
    public String toString() {
        return "Place{" +
                "id ='" + id + '\'' +
                ", address ='" + address + '\'' +
                ", phoneNumber ='" + phoneNumber + '\'' +
                ", contactName ='" + contactName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }



}
