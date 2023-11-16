package repository;

import exception.ParkingLotNotFoundExceptioin;
import exception.ParkingSlotNotFoundExceptioin;
import model.ParkingLot;
import model.ParkingSlot;

import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId) throws ParkingLotNotFoundExceptioin {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundExceptioin("Parking Lot not found for Id : " + parkingLotId);
        }
        return parkingLot;
    }

    public ParkingLot put(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
