/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.AdminQueueController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.AdminQueueXmlController;
import com.novatronic.das.service.rs.AdminQueueService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.AdminQueue;
import com.novatronic.das.xml.config.AdminQueues;

/**
 * 
 * @author wcahuaya
 */
public class AdminQueueJsonService implements AdminQueueService {

	public AdminQueueJsonService() {
	}

	@Override
	public AdminQueues obtener() {
		try {
			AdminQueueController c = new AdminQueueXmlController();
			AdminQueues mfs = new AdminQueues();
			mfs.setAdminQueues(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(AdminQueue t) {
		try {
			AdminQueueController c = new AdminQueueXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(AdminQueue t) {
		try {
			AdminQueueController c = new AdminQueueXmlController();
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
			AdminQueueController c = new AdminQueueXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
