package com.skd.exception;

public class UploadException extends RuntimeException {

	private static final long serialVersionUID = 4505693091551477231L;

	public UploadException() {
		super();
	}

	public UploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public UploadException(String message) {
		super(message);
	}

	public UploadException(Throwable cause) {
		super(cause);
	}

}
