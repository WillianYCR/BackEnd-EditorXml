/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.dao.factory;

import com.novatronic.das.dao.DAOFactory;
import com.novatronic.das.dao.MessageFormatDAO;
import com.novatronic.das.dao.SixAdcClientDAO;
import com.novatronic.das.dao.xml.MessageFormatXmlDAO;
import com.novatronic.das.dao.xml.SixAdcClientXmlDAO;

/**
 * @author wcahuaya
 * 
 */
public class XmlDAOFactory implements DAOFactory {

	private static XmlDAOFactory instance;
	private final MessageFormatXmlDAO messageFormatXmlDAO;
	private final SixAdcClientDAO sixAdcClientDAO;

	public static XmlDAOFactory getInstance() {
		if (instance == null) {
			instance = new XmlDAOFactory();
		}
		return instance;
	}

	public XmlDAOFactory() {
		messageFormatXmlDAO = new MessageFormatXmlDAO();
		sixAdcClientDAO = new SixAdcClientXmlDAO();
	}

	@Override
	public MessageFormatDAO getMessageFormatDAO() {
		return this.messageFormatXmlDAO;
	}

	@Override
	public SixAdcClientDAO getSixAdcClientDAO() {
		return this.sixAdcClientDAO;
	}

	@Override
	public void destroy() {
		instance = null;
	}
}
