package com.skd.exception;

public class QueryException extends RuntimeException {

	private static final long serialVersionUID = 7781461066719823474L;

	public QueryException() {
		super();
	}

	public QueryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QueryException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryException(String message) {
		super(message);
	}

	public QueryException(Throwable cause) {
		super(cause);
	}

}
