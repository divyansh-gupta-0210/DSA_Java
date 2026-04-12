package LLDPractise.ParkingLot.Strategy.Fee;

import LLDPractise.ParkingLot.Entities.ParkingTicket;

public interface ParkingFeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
