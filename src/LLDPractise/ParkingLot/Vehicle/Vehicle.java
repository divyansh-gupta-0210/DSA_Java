package LLDPractise.ParkingLot.Vehicle;

public abstract class Vehicle {

    private final String licenseNumber;
    private final VehicleSize vehicleSize;

    public Vehicle(String licenseNumber, VehicleSize vehicleSize){
        this.licenseNumber = licenseNumber;
        this.vehicleSize = vehicleSize;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleSize getVehicleSize(){
        return vehicleSize;
    }
}
