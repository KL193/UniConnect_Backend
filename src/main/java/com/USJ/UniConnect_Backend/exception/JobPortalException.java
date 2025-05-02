package com.USJ.UniConnect_Backend.exception;

public class JobPortalException extends RuntimeException {

    public JobPortalException() {
        super();
    }

    public JobPortalException(String message) {
        super(message);
    }

    public JobPortalException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobPortalException(Throwable cause) {
        super(cause);
    }
}
