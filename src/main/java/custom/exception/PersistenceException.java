package custom.exception;

import java.io.Serializable;

public class PersistenceException extends Exception implements Serializable {

	private static final long serialVersionUID = 181958045708563771L;

	public PersistenceException() {
		super();

	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PersistenceException(String message) {
		super(message);

	}

	public PersistenceException(Throwable cause) {
		super(cause);

	}

}
