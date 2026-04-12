package LLDPractise.ParkingLot.Strategy.Fee;

import LLDPractise.ParkingLot.Entities.ParkingTicket;
import LLDPractise.ParkingLot.Vehicle.VehicleSize;

import java.util.Map;

public class VehicleSizeFeeStrategy implements ParkingFeeStrategy{

    private static final Map<VehicleSize, Double> HOURLY_RATES = Map.of(
            VehicleSize.SMALL, 10.0,
            VehicleSize.MEDIUM, 20.0,
            VehicleSize.LARGE, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket parkingTicket){
        long duration = parkingTicket.getEntryTimestamp() - parkingTicket.getExitTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * HOURLY_RATES.get(parkingTicket.getVehicle().getVehicleSize());
    }

}
