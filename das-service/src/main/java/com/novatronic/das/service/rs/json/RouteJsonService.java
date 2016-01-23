/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.RouteController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.RouteXmlController;
import com.novatronic.das.service.rs.RouteService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Route;
import com.novatronic.das.xml.config.Routes;

/**
 * 
 * @author wcahuaya
 */
public class RouteJsonService implements RouteService {

	public RouteJsonService() {
	}

	@Override
	public Routes obtener() {
		try {
			RouteController c = new RouteXmlController();
			Routes mfs = new Routes();
			mfs.setRoutes(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(Route t) {
		try {
			RouteController c = new RouteXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(Route t) {
		try {
			RouteController c = new RouteXmlController();
			return c.actualizar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta eliminar(String s) {
		try {
			RouteController c = new RouteXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
