package LLDParkingLot;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManger {
    public TwoWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    ParkingSpot findParkingSpace() {
        return null;
    }
}
