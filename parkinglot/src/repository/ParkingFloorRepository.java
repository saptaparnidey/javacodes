package repository;

import exception.ParkingSlotNotFoundExceptioin;
import model.ParkingFloor;
import model.ParkingSlot;

import java.util.HashMap;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId) throws ParkingSlotNotFoundExceptioin {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null){
            throw new ParkingSlotNotFoundExceptioin("Parking Floor not found for Id : " + parkingFloorId);
        }
        return parkingFloor;
    }

    public ParkingFloor put(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        return parkingFloor;
    }
}
