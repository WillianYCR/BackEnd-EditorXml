package com.novatronic.das.controller.exception;

import com.novatronic.das.util.out.Respuesta;

/**
 * @author wcahuaya
 *
 */
public class ControllerException extends RuntimeException{

	private Respuesta respuesta = null;
	
    public ControllerException(String message) {
        super(message);
        respuesta = new Respuesta();
        respuesta.setCodigo("99");
        respuesta.setDescripcion(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
        respuesta = new Respuesta();
        respuesta.setCodigo("99");
        respuesta.setDescripcion(message);
        respuesta.setException(cause.getMessage());
    }

    public ControllerException(Throwable cause) {
        super(cause);
        respuesta = new Respuesta();
        respuesta.setCodigo("99");
        respuesta.setDescripcion(cause.getMessage());
    }

	public Respuesta getRespuesta() {
		return respuesta;
	}

    
}
