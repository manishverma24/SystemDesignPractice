package StrategyPattern;

public class Main {
    public static void main(String[] args) {
//        Vehicle vehicle = new NormalVehicle();
//        Vehicle vehicle = new PassengerVehicle();
        Vehicle vehicle = new SportVehicle();
        vehicle.drive();
    }
}
