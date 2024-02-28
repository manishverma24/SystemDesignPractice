package StrategyPattern.strategy;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.print("Sports Drive Strategy");
    }
}
