package LLDParkingLot;

public abstract class CostComputation {
    PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    int calculateCost(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket);
    }
}
