package br.com.webmatte.comportamental.mediator.exception;

/**
 * Exception thrown when a thread is interrupted while waiting for a taxi.
 * @author Anderson Matte
 */
public class TaxiInterruptedException extends RuntimeException {

    public TaxiInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxiInterruptedException(String message) {
        super(message);
    }
}
