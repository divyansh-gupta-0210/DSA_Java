package LLDPractise.ParkingLot.Strategy.Parking;

import LLDPractise.ParkingLot.Entities.ParkingFloor;
import LLDPractise.ParkingLot.Entities.ParkingSpot;
import LLDPractise.ParkingLot.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class BestFitStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle){
        Optional<ParkingSpot> bestSpot = Optional.empty();
        for(ParkingFloor floor: floors){
            Optional<ParkingSpot> spotOnFloor = floor.findAvailableSpot(vehicle);
            if(spotOnFloor.isPresent()){
                if(bestSpot.isEmpty()){
                    bestSpot = spotOnFloor;
                }
                else{
                    if(spotOnFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()){
                        bestSpot = spotOnFloor;
                    }
                }
            }
        }
        return bestSpot;
    }
}
