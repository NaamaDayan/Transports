package BL.Entities;
import DAL.Drivers;

public class Driver{

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Driver(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id ='" + id + '\'' +
                ", firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", phoneNumber ='" + phoneNumber + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
