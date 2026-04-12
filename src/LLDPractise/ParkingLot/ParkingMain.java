package LLDPractise.ParkingLot;

import LLDPractise.ParkingLot.Entities.ParkingFloor;
import LLDPractise.ParkingLot.Entities.ParkingSpot;
import LLDPractise.ParkingLot.Entities.ParkingTicket;
import LLDPractise.ParkingLot.Strategy.Fee.VehicleSizeFeeStrategy;
import LLDPractise.ParkingLot.Vehicle.*;

import java.util.Optional;

public class ParkingMain {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpots(new ParkingSpot("F1-S1", VehicleSize.SMALL));
        floor1.addSpots(new ParkingSpot("F1-M1", VehicleSize.MEDIUM));
        floor1.addSpots(new ParkingSpot("F1-L1", VehicleSize.LARGE));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpots(new ParkingSpot("F2-M1", VehicleSize.MEDIUM));
        floor2.addSpots(new ParkingSpot("F2-M2", VehicleSize.MEDIUM));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setParkingFeeStrategy(new VehicleSizeFeeStrategy());

        System.out.println("\n--- Vehicle Entries ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Car("C-456");
        Vehicle truck = new Truck("T-789");

        Optional<ParkingTicket> bikeTicketOpt = parkingLot.parkVehicle(bike);

        Optional<ParkingTicket> carTicketOpt = parkingLot.parkVehicle(car);

        Optional<ParkingTicket> truckTicketOpt = parkingLot.parkVehicle(truck);

        System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();


        Vehicle car2 = new Car("C-999");
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);

        Vehicle bike2 = new Bike("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        System.out.println("\n--- Vehicle Exits ---");

        if (carTicketOpt.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unparkVehicle(car.getLicenseNumber());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

    }
}
