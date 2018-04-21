package BL;


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

    public void insertDriver() {
        Drivers.insertDriver(id, firstName, lastName, phoneNumber);
    }
}
