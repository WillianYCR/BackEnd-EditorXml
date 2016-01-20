/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.json;

import com.novatronic.das.controller.MessageFormatController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.controller.formateo.MessageFormatXmlController;
import com.novatronic.das.service.rs.MessageFormatService;
import com.novatronic.das.service.rs.exception.ServiceException;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;

/**
 * 
 * @author wcahuaya
 */
public class MessageFormatJsonService implements MessageFormatService {

	public MessageFormatJsonService() {
	}

	@Override
	public MessageFormats obtener() {
		MessageFormatController c;
		MessageFormats mfs = null;
		try {
			c = new MessageFormatXmlController();
			mfs = new MessageFormats();
			mfs.setMessageFormats(c.obtener());
			return mfs;
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Respuesta insertar(MessageFormat t) {
		try {
			MessageFormatController c = new MessageFormatXmlController();
			return c.insertar(t);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Respuesta actualizar(MessageFormat t) {
		try {
			MessageFormatController c = new MessageFormatXmlController();
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
			MessageFormatController c = new MessageFormatXmlController();
			return c.eliminar(s);
		}catch (ControllerException e) {
			throw new ServiceException(e);
		}catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
