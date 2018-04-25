package BL.Entities;

public class LicenseTypeForTruck {

    private String licenseType;
    private String truckModelId;

    public LicenseTypeForTruck(String licenseType, String truckModel) {
        this.licenseType = licenseType;
        this.truckModelId = truckModel;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getTruckModelId() {
        return truckModelId;
    }

    @Override
    public String toString() {
        return "License {" +
                "license id='" + licenseType + '\'' +
                ", truck Model='" + truckModelId + '\'' +
                '}';
    }
    public void setTruckModelId(String truckModelId) {
        this.truckModelId = truckModelId;
    }
}
