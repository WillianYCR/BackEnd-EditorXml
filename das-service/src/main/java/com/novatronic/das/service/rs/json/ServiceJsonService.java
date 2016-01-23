/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.ServiceController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.ServiceXmlController;
import com.novatronic.das.service.rs.ServiceService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Service;
import com.novatronic.das.xml.config.Services;

/**
 * 
 * @author wcahuaya
 */
public class ServiceJsonService implements ServiceService {

	public ServiceJsonService() {
	}

	@Override
	public Services obtener() {
		try {
			ServiceController c = new ServiceXmlController();
			Services mfs = new Services();
			mfs.setServices(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(Service t) {
		try {
			ServiceController c = new ServiceXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(Service t) {
		try {
			ServiceController c = new ServiceXmlController();
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
			ServiceController c = new ServiceXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
