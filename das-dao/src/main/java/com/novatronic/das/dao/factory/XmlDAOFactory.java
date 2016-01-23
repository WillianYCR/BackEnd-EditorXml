/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.dao.factory;

import com.novatronic.das.dao.AdminQueueDAO;
import com.novatronic.das.dao.BalancerDAO;
import com.novatronic.das.dao.DAOFactory;
import com.novatronic.das.dao.DriverDAO;
import com.novatronic.das.dao.MessageFormatDAO;
import com.novatronic.das.dao.ProfileDAO;
import com.novatronic.das.dao.RouteDAO;
import com.novatronic.das.dao.ServiceDAO;
import com.novatronic.das.dao.ServiceNodeDAO;
import com.novatronic.das.dao.SixadcClientDAO;
import com.novatronic.das.dao.xml.AdminQueueXmlDAO;
import com.novatronic.das.dao.xml.BalancerXmlDAO;
import com.novatronic.das.dao.xml.DriverXmlDAO;
import com.novatronic.das.dao.xml.MessageFormatXmlDAO;
import com.novatronic.das.dao.xml.ProfileXmlDAO;
import com.novatronic.das.dao.xml.RouteXmlDAO;
import com.novatronic.das.dao.xml.ServiceNodeXmlDAO;
import com.novatronic.das.dao.xml.ServiceXmlDAO;
import com.novatronic.das.dao.xml.SixadcClientXmlDAO;

/**
 * @author wcahuaya
 * 
 */
public class XmlDAOFactory implements DAOFactory {

	private static XmlDAOFactory instance;
	private final MessageFormatXmlDAO messageFormatXmlDAO;
	private final AdminQueueXmlDAO adminQueueXmlDAO;
	private final DriverXmlDAO driverXmlDAO;
	private final BalancerXmlDAO balancerXmlDAO;
	private final RouteXmlDAO routeXmlDAO;
	private final ServiceXmlDAO serviceXmlDAO;
	private final ProfileXmlDAO profileXmlDAO;
	private final ServiceNodeXmlDAO serviceNodeXmlDAO;
	
	private final SixadcClientXmlDAO sixAdcClientXmlDAO;

	public static XmlDAOFactory getInstance() {
		if (instance == null) {
			instance = new XmlDAOFactory();
		}
		return instance;
	}

	public XmlDAOFactory() {
		messageFormatXmlDAO = new MessageFormatXmlDAO();
		adminQueueXmlDAO = new AdminQueueXmlDAO();
		driverXmlDAO = new DriverXmlDAO();
		balancerXmlDAO = new BalancerXmlDAO();
		routeXmlDAO = new RouteXmlDAO();
		serviceXmlDAO = new ServiceXmlDAO();
		profileXmlDAO = new ProfileXmlDAO();
		serviceNodeXmlDAO = new ServiceNodeXmlDAO();
		
		sixAdcClientXmlDAO = new SixadcClientXmlDAO();
	}

	@Override
	public MessageFormatDAO getMessageFormatDAO() {
		return this.messageFormatXmlDAO;
	}
	
	@Override
	public AdminQueueDAO getAdminQueueDAO() {
		return this.adminQueueXmlDAO;
	}

	@Override
	public SixadcClientDAO getSixAdcClientDAO() {
		return this.sixAdcClientXmlDAO;
	}
	
	@Override
	public DriverDAO getDriverDAO() {
		return this.driverXmlDAO;
	}

	@Override
	public BalancerDAO getBalancerDAO() {
		return this.balancerXmlDAO;
	}

	@Override
	public RouteDAO getRouteDAO() {
		return this.routeXmlDAO;
	}

	@Override
	public ServiceDAO getServiceDAO() {
		return this.serviceXmlDAO;
	}

	@Override
	public ProfileDAO getProfileDAO() {
		return this.profileXmlDAO;
	}

	@Override
	public ServiceNodeDAO getServiceNodeDAO() {
		return this.serviceNodeXmlDAO;
	}
	
	@Override
	public void destroy() {
		instance = null;
	}
}
