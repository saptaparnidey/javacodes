package exception;

public class ParkingSlotNotFoundExceptioin extends Exception{
    public ParkingSlotNotFoundExceptioin() {
        super();
    }

    public ParkingSlotNotFoundExceptioin(String message) {
        super(message);
    }
}
