package by.htp.shop.service.exception;

public class ClientNameError extends Exception {
	private static final long serialVersionUID = 1L;

	public ClientNameError() {
		super();
	}

	public ClientNameError(String message) {
		super(message);
	}

	public ClientNameError(Exception e) {
		super(e);
	}

	public ClientNameError(String message, Exception e) {
		super(message, e);
	}

}
