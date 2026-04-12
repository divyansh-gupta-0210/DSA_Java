package LLDPractise.ParkingLot.Entities;

import LLDPractise.ParkingLot.Vehicle.Vehicle;
import LLDPractise.ParkingLot.Vehicle.VehicleSize;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpots(ParkingSpot spot){
        spots.putIfAbsent(spot.getSpotId(), spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        ParkingSpot bestSpot = null;
        for(ParkingSpot spot : spots.values()){
            if(!spot.isOccupied() && spot.canFit(vehicle)){
                if(bestSpot == null || spot.canFit(vehicle)){
                    bestSpot = spot;
                }
            }
        }
        return Optional.ofNullable(bestSpot);
    }

    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorNumber);
        Map<VehicleSize, Long> availableCounts = new HashMap<>();

        for (ParkingSpot spot : spots.values()) {
            if (!spot.isOccupied()) {
                VehicleSize size = spot.getSpotSize();
                availableCounts.put(size, availableCounts.getOrDefault(size, 0L) + 1);
            }
        }

        for (VehicleSize size : VehicleSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }

}
