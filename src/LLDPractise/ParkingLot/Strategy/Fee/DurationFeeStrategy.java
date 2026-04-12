package LLDPractise.ParkingLot.Strategy.Fee;

import LLDPractise.ParkingLot.Entities.ParkingTicket;

public class DurationFeeStrategy implements ParkingFeeStrategy{

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket parkingTicket){
        long duration = parkingTicket.getEntryTimestamp() - parkingTicket.getExitTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }

}
