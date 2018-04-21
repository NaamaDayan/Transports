package BL.Entities;
import DAL.DriversLicenses;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverLicense {

    private String driverId;
    private String licenseType;

    public DriverLicense(String driverId, String licenseType) {
        this.driverId = driverId;
        this.licenseType = licenseType;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getLicenseType() {
        return licenseType;
    }

}
