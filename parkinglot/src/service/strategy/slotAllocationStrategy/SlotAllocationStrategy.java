package service.strategy.slotAllocationStrategy;

import model.Gate;
import model.ParkingLot;
import model.ParkingSlot;
import model.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
