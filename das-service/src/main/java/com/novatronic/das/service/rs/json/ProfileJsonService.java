/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.ProfileController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.ProfileXmlController;
import com.novatronic.das.service.rs.ProfileService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Profile;
import com.novatronic.das.xml.config.Profiles;

/**
 * 
 * @author wcahuaya
 */
public class ProfileJsonService implements ProfileService {

	public ProfileJsonService() {
	}

	@Override
	public Profiles obtener() {
		try {
			ProfileController c = new ProfileXmlController();
			Profiles mfs = new Profiles();
			mfs.setProfiles(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(Profile t) {
		try {
			ProfileController c = new ProfileXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(Profile t) {
		try {
			ProfileController c = new ProfileXmlController();
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
			ProfileController c = new ProfileXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
