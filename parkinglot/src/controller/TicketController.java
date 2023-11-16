package controller;

import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.GateNotFoundExceptioin;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundExceptioin;
import model.Ticket;
import model.Vehicle;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.TicketService;
import service.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {

    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository){
        this.ticketService = new TicketServiceImpl(parkingLotRepository, gateRepository,ticketRepository);
    }
    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws GateNotFoundExceptioin, NoEmptyParkingSlotAvailableException, ParkingLotNotFoundExceptioin {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());
        return ticketResponseDTO;
    }
}
