package BL.Entities;
import DAL.LicenseForTruck;

public class LicenseTypeForTruck {

    private String licenseType;
    private String truckModel;

    public LicenseTypeForTruck(String licenseType, String truckModel) {
        this.licenseType = licenseType;
        this.truckModel = truckModel;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getTruckModel() {
        return truckModel;
    }

    @Override
    public String toString() {
        return "License {" +
                "license Type='" + licenseType + '\'' +
                ", truck Model='" + truckModel + '\'' +
                '}';
    }
    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }
}
