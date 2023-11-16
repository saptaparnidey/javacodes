package exception;

public class NoEmptyParkingSlotAvailableException extends Exception{
    public NoEmptyParkingSlotAvailableException() {
        super();
    }

    public NoEmptyParkingSlotAvailableException(String message) {
        super(message);
    }
}
