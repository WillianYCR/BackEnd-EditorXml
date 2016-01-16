package com.novatronic.das.dao.exception;

/**
 * @author wcahuaya
 *
 */
public class DAOException extends RuntimeException{

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
    
}