package LLDParkingLot;

import java.util.List;

public class FourWheelerManager extends ParkingSpotManger {
    public FourWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    ParkingSpot findParkingSpace() {
        return null;
    }
}
