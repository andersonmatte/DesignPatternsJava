package br.com.webmatte.comportamental.command.exception;

/**
 * Exception thrown when command execution fails.
 * @author Anderson Matte
 */
public class ComandoExecutionException extends RuntimeException {

    public ComandoExecutionException(String message) {
        super(message);
    }

    public ComandoExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComandoExecutionException(Throwable cause) {
        super(cause);
    }
}
