package repository;

import exception.GateNotFoundExceptioin;
import exception.ParkingSlotNotFoundExceptioin;
import model.Gate;
import model.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {
    private HashMap<Integer, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        this.parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int parkingSlotId) throws ParkingSlotNotFoundExceptioin {
        ParkingSlot parkingSlot = parkingSlotMap.get(parkingSlotId);
        if(parkingSlot == null){
            throw new ParkingSlotNotFoundExceptioin("Parking Slot not found for Id : " + parkingSlotId);
        }
        return parkingSlot;
    }

    public ParkingSlot put(ParkingSlot parkingSlot){
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
        return parkingSlot;
    }
}
