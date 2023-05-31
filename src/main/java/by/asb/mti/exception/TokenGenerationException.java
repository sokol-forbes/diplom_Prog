package by.asb.mti.exception;

public class TokenGenerationException extends RuntimeException{
    public TokenGenerationException() {
        super();
    }

    public TokenGenerationException(String message) {
        super(message);
    }

    public TokenGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenGenerationException(Throwable cause) {
        super(cause);
    }

    protected TokenGenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
