package BL.Entities;

import DAL.LicenseForTruck;

/**
 * Created by Naama on 21/04/2018.
 */
public class DriverLicense {

    private String driverId;
    private LicenseTypeForTruck license;

    public DriverLicense(String driver, LicenseTypeForTruck license) {
        this.driverId = driver;
        this.license = license;
    }

    public String getDriver() {
        return driverId;
    }

    public LicenseTypeForTruck getLicense() {
        return license;
    }


}
