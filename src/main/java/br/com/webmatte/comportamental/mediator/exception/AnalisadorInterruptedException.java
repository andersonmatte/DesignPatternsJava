package br.com.webmatte.comportamental.mediator.exception;

/**
 * Exception thrown when a thread is interrupted while waiting for analyzer.
 * @author Anderson Matte
 */
public class AnalisadorInterruptedException extends RuntimeException {

    public AnalisadorInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalisadorInterruptedException(String message) {
        super(message);
    }
}
