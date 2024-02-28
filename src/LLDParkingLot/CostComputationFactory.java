package LLDParkingLot;

public class CostComputationFactory {
    CostComputation getCostComputationStrategy(Ticket ticket) {
        if (ticket.getVehicle().getVehicleType() == VehicleType.TwoWheeler)
            return new TwoWheelerCostComputation();
        else
            return null;
    }
}
