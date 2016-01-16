package com.novatronic.das.service.rs.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.util.out.Respuesta;

public class ServiceException extends WebApplicationException{

	private static final long serialVersionUID = 1L;

	public ServiceException(ControllerException ce){
		super(Response.status(500).entity(ce.getRespuesta()).build());
	}
	
	public ServiceException(Exception e){
		super(Response.status(500).entity(new Respuesta("99", e.getMessage())).build());
	}
	
	
}
