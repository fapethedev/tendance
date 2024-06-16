package com.fapethedev.tendance.main.cdn;

/**
 * <p>Cdn relative operation failure exception.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public class CdnException extends RuntimeException
{
    /**
     * <p>Constructor matching super with string param.</p>
     *
     * @param message the exception message.
     */
    public CdnException(String message) {
        super(message) ;
    }

    /**
     * <p>Constructor matching super with string param and throwable cause.</p>
     *
     * @param message the exception message.
     * @param cause the exception itself.
     */
    public CdnException(String message, Throwable cause) {
        super(message, cause) ;
    }
}