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
import com.novatronic.das.xml.config.Service;
import com.novatronic.das.xml.config.Services;

/**
 *
 * @author wcahuaya
 */
@Consumes("application/json")
@Produces("application/json")
@Path("Service")
public interface ServiceService {
	//http://localhost:8080/ResDAS/Service
    @GET
    Services obtener();

    @POST 
    Respuesta insertar(Service service);
    
    @PUT
    Respuesta actualizar(Service service);
    
    @DELETE
    @Path("/{id}")
    Respuesta eliminar(@PathParam("id") String s);
}
