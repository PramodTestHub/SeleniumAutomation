package exceptions;

public class PageNotLoadedException extends RuntimeException{

	public PageNotLoadedException(String message) {
        super(message);
    }

    public PageNotLoadedException(String message, Throwable cause) {
        super(message, cause);
    }
}
