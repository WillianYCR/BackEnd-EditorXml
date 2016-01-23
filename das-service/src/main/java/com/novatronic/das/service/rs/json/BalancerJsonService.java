/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.BalancerController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.BalancerXmlController;
import com.novatronic.das.service.rs.BalancerService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Balancer;
import com.novatronic.das.xml.config.Balancers;

/**
 * 
 * @author wcahuaya
 */
public class BalancerJsonService implements BalancerService {

	public BalancerJsonService() {
	}

	@Override
	public Balancers obtener() {
		try {
			BalancerController c = new BalancerXmlController();
			Balancers mfs = new Balancers();
			mfs.setBalancers(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(Balancer t) {
		try {
			BalancerController c = new BalancerXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(Balancer t) {
		try {
			BalancerController c = new BalancerXmlController();
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
			BalancerController c = new BalancerXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
