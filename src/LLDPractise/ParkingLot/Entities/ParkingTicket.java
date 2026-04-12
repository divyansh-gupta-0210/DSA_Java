package LLDPractise.ParkingLot.Entities;

import LLDPractise.ParkingLot.Vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketID;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTimestamp;
    private long exitTimestamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketID = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTimestamp = new Date().getTime();
    }

    public String getTicketID() {
        return ticketID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getExitTimestamp() {
        return exitTimestamp;
    }

    public void setExitTimestamp() {
        this.exitTimestamp = new Date().getTime();
    }
}
