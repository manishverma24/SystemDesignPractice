package StrategyPattern;

import StrategyPattern.Vehicle;
import StrategyPattern.strategy.PassengerDriveStrategy;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new PassengerDriveStrategy());
    }
}
