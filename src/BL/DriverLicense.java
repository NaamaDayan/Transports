package BL;
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

    public void insertDriverLicense(){
        DriversLicenses.insertDriverLicense(driverId, licenseType);
    }
}
