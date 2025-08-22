package exceptions;

public class DriverNotInitializedException extends RuntimeException {
	
	public DriverNotInitializedException(String message) {
        super(message);
    }

    public DriverNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

}
