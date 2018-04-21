package BL;
import DAL.LicenseForTruck;

public class LicenseTypeForTruck {

    private String licenseType;
    private String truckModel;

    public LicenseTypeForTruck(String licenseType, String truckModel) {
        this.licenseType = licenseType;
        this.truckModel = truckModel;
    }

    public void insertLicense(){
        LicenseForTruck.insertLicense(truckModel, licenseType);
    }
}
