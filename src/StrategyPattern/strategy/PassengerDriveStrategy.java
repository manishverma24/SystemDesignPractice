package StrategyPattern.strategy;

public class PassengerDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.print("Passenger Drive Strategy");
    }
}
