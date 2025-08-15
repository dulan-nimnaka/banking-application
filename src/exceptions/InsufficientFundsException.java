package exceptions;

// This is used to represent situations where there insufficient funds or overdraft
public class InsufficientFundsException extends Exception{

    // Constructor that takes a String parameter 'message' will describe the specific error that occurred
    public InsufficientFundsException(String message) {

        // Calls the parent class(Exception)
        super(message);
    }
}

