import controller.TicketController;
import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.GateNotFoundExceptioin;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundExceptioin;
import model.ParkingLot;
import model.constants.VehicleType;
import repository.*;
import service.InitService;
import service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundExceptioin, GateNotFoundExceptioin, NoEmptyParkingSlotAvailableException {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingLotRepository, parkingFloorRepository, gateRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        ParkingLot parkingLot = parkingLotRepository.get(1);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("Mercedez");
        ticketRequestDTO.setColor("Blue");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("1234");

       TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
       System.out.println(ticketResponseDTO);
    }
}
