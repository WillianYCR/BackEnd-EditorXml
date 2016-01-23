/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.DriverController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.DriverXmlController;
import com.novatronic.das.service.rs.DriverService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Driver;
import com.novatronic.das.xml.config.Drivers;

/**
 * 
 * @author wcahuaya
 */
public class DriverJsonService implements DriverService {

	public DriverJsonService() {
	}

	@Override
	public Drivers obtener() {
		try {
			DriverController c = new DriverXmlController();
			Drivers mfs = new Drivers();
			mfs.setDrivers(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(Driver t) {
		try {
			DriverController c = new DriverXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(Driver t) {
		try {
			DriverController c = new DriverXmlController();
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
			DriverController c = new DriverXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
