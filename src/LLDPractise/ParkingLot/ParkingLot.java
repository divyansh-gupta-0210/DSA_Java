package LLDPractise.ParkingLot;

import LLDPractise.ParkingLot.Entities.ParkingFloor;
import LLDPractise.ParkingLot.Entities.ParkingSpot;
import LLDPractise.ParkingLot.Entities.ParkingTicket;
import LLDPractise.ParkingLot.Strategy.Fee.ParkingFeeStrategy;
import LLDPractise.ParkingLot.Strategy.Fee.VehicleSizeFeeStrategy;
import LLDPractise.ParkingLot.Strategy.Parking.BestFitStrategy;
import LLDPractise.ParkingLot.Strategy.Parking.ParkingStrategy;
import LLDPractise.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets;
    private ParkingFeeStrategy parkingFeeStrategy;
    private ParkingStrategy parkingStrategy;


    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    private ParkingLot(){
        this.parkingFeeStrategy = new VehicleSizeFeeStrategy();
        this.parkingStrategy = new BestFitStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public void setParkingFeeStrategy(ParkingFeeStrategy parkingFeeStrategy){
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);
        if(availableSpot.isPresent()){
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicenseNumber(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenseNumber(), spot.getSpotId(), ticket.getTicketID());
            return Optional.of(ticket);
        }
        System.out.println("No available spot for " + vehicle.getLicenseNumber());
        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String licenseNumber){
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if(ticket == null){
            System.out.println("Ticket not found");
            return Optional.empty();
        }
        ticket.setExitTimestamp();
        ticket.getParkingSpot().unparkVehicle();
        Double parkingFee = parkingFeeStrategy.calculateFee(ticket);
        return Optional.of(parkingFee);
    }

}















