package BL.Entities;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverLicense {

    private String driverId;
    private String licenseId;

    public DriverLicense(String driverId, String licenseId) {
        this.driverId = driverId;
        this.licenseId = licenseId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getLicenseId() {
        return licenseId;
    }


}
