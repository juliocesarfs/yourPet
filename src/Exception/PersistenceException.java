package exception;

public class PersistenceException extends RuntimeException {
	
	public PersistenceException(String message, Throwable e) {
		super(message, e);
	}

}
