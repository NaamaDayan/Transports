package BL.Entities;

public class LicenseTypeForTruck {

    private String licenseType;
    private TruckModel truckModelId;

    public LicenseTypeForTruck(String licenseType, TruckModel truckModel) {
        this.licenseType = licenseType;
        this.truckModelId = truckModel;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public TruckModel getTruckModelId() {
        return truckModelId;
    }

    @Override
    public String toString() {
        return "License {" +
                "license id='" + licenseType + '\'' +
                ", truck Model='" + truckModelId + '\'' +
                '}';
    }
    public void setTruckModelId(TruckModel truckModelId) {
        this.truckModelId = truckModelId;
    }
}
