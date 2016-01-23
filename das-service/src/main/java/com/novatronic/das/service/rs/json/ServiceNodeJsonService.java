/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.ServiceNodeController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.ServiceNodeXmlController;
import com.novatronic.das.service.rs.ServiceNodeService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.ServiceNode;
import com.novatronic.das.xml.config.ServiceNodes;

/**
 * 
 * @author wcahuaya
 */
public class ServiceNodeJsonService implements ServiceNodeService {

	public ServiceNodeJsonService() {
	}

	@Override
	public ServiceNodes obtener() {
		try {
			ServiceNodeController c = new ServiceNodeXmlController();
			ServiceNodes mfs = new ServiceNodes();
			mfs.setServiceNodes(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(ServiceNode t) {
		try {
			ServiceNodeController c = new ServiceNodeXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(ServiceNode t) {
		try {
			ServiceNodeController c = new ServiceNodeXmlController();
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
			ServiceNodeController c = new ServiceNodeXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
