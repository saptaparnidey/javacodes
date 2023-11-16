package service;

import exception.GateNotFoundExceptioin;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundExceptioin;
import model.Ticket;
import model.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundExceptioin, GateNotFoundExceptioin, NoEmptyParkingSlotAvailableException;
}
