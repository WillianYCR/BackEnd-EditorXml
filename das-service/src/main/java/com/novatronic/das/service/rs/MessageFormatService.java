/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;

/**
 *
 * @author wcahuaya
 */
@Consumes("application/json")
@Produces("application/json")
@Path("MessageFormat")
public interface MessageFormatService {
	//http://localhost:8080/ResDAS/MessageFormat
    @GET
    MessageFormats obtener();

    @POST 
    Respuesta insertar(MessageFormat messageFormat);
    
    @PUT
    Respuesta actualizar(MessageFormat messageFormat);
    
    @DELETE
    @Path("/{id}")
    Respuesta eliminar(@PathParam("id") String s);
}
