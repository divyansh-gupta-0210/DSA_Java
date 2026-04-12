package LLDPractise.ParkingLot.Entities;

import LLDPractise.ParkingLot.Vehicle.Vehicle;
import LLDPractise.ParkingLot.Vehicle.VehicleSize;

public class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private final VehicleSize spotSize;

    public ParkingSpot(String spotId, VehicleSize spotSize){
        this.spotId = spotId;
        this.spotSize = spotSize;
        isOccupied = false;
        parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unparkVehicle(){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean canFit(Vehicle vehicle){
        if(isOccupied){
            return false;
        }
        switch (vehicle.getVehicleSize())
        {
            case SMALL: return spotSize == VehicleSize.SMALL;
            case MEDIUM: return spotSize == VehicleSize.MEDIUM;
            case LARGE: return spotSize == VehicleSize.LARGE;
            default: return false;
        }
    }
}
