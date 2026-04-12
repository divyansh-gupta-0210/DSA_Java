package LLDPractise.ParkingLot.Strategy.Parking;

import LLDPractise.ParkingLot.Entities.ParkingFloor;
import LLDPractise.ParkingLot.Entities.ParkingSpot;
import LLDPractise.ParkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
