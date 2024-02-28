package LLDParkingLot;

import java.util.ArrayList;

public class ExitGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;

    CostComputationFactory costComputationFactory;

    ExitGate(ParkingSpotManagerFactory factory) {
        this.parkingSpotManagerFactory = factory;
    }

    void removeVehicle(Ticket ticket) {
        ParkingSpotManger manager = parkingSpotManagerFactory.getParkingSpotManager(ticket.vehicle.vehicleType, new ArrayList<>());
        manager.removeVehicle(ticket.vehicle);
    }

    void calculatePrice(Ticket ticket) {
        CostComputation costComputation = costComputationFactory.getCostComputationStrategy(ticket);
        costComputation.calculateCost(ticket);
    }
}
