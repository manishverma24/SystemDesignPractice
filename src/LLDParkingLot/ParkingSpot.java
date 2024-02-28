package LLDParkingLot;

public class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle vehicle;
    int price;

    ParkingSpot(int id, int price) {
        this.id = id;
        this.isEmpty = true;
        this.vehicle = null;
        this.price = price;
    }

    void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.isEmpty = false;
    }

    void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }
}
