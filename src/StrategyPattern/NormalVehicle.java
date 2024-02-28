package StrategyPattern;

import StrategyPattern.Vehicle;
import StrategyPattern.strategy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle {
    public NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
