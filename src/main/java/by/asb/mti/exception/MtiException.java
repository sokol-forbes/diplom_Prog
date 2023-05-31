package by.asb.mti.exception;

public class MtiException extends RuntimeException {
    public MtiException() {
        super();
    }

    public MtiException(String message) {
        super(message);
    }

    public MtiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MtiException(Throwable cause) {
        super(cause);
    }

    protected MtiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
