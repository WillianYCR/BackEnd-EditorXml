/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.SixadcClientController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.SixadcClientXmlController;
import com.novatronic.das.service.rs.SixadcClientService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.configclient.SixadcClient;
import com.novatronic.das.xml.configclient.SixadcClients;

/**
 * 
 * @author wcahuaya
 */
public class SixadcClientJsonService implements SixadcClientService {

	public SixadcClientJsonService() {
	}

	@Override
	public SixadcClients obtener() {
		try {
			SixadcClientController c = new SixadcClientXmlController();
			SixadcClients mfs = new SixadcClients();
			mfs.setSixadcClients(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(SixadcClient t) {
		try {
			SixadcClientController c = new SixadcClientXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(SixadcClient t) {
		try {
			SixadcClientController c = new SixadcClientXmlController();
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
			SixadcClientController c = new SixadcClientXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
