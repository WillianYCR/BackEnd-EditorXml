package com.novatronic.das.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.controller.formateo.ServiceNodeXmlController;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.xml.config.AdminChannel;
import com.novatronic.das.xml.config.AuthorizedServices;
import com.novatronic.das.xml.config.DefaultChannel;
import com.novatronic.das.xml.config.ServiceChannel;
import com.novatronic.das.xml.config.ServiceChannels;
import com.novatronic.das.xml.config.ServiceNode;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class ServiceNodeTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = new ServiceNodeXmlController().obtener();
		assertNotNull(lista);
        assertEquals(4, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		AdminChannel admChan = new AdminChannel("5", "130", "120", "1", "10", "30", "999", "10",
				"AQ_Node5_Adminchannel", "8880", "AVAILABLE", "120", "10", "120", "10");
		DefaultChannel defChan = new DefaultChannel("5", "130", "120", "1", "10", "30", "999", "10",
				"DefaultChannel5", "8880", "AVAILABLE", "15", "true", "120", "10", "120", "10", "40", "100");
		List<ServiceChannel> listServChann = new ArrayList<ServiceChannel>();
		ServiceChannel servChan;
		List<String> autId = new ArrayList<String>();
		autId.add("servicio1");
		AuthorizedServices autServ = new AuthorizedServices(autId);
		servChan = new ServiceChannel("5", "130", "120", "5", "10", "30", "999", "10",
				"ServChanel5", "AVAILABLE", "8880", "15", autServ, "true", "120", "10", "120", "10", "40", "100");
		listServChann.add(servChan);
		ServiceChannels servChannels = new ServiceChannels(listServChann);
		ServiceNode tag = new ServiceNode("Node5", "172.20.20.20", "50-CORREGIDO", admChan, defChan, servChannels);
		new ServiceNodeXmlController().insertar(tag);
    	
    	lista = new ServiceNodeXmlController().obtener();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	AdminChannel admChan = new AdminChannel("5", "130", "120", "1", "10", "30", "999", "10",
				"AQ_Node5_Adminchannel", "8880", "AVAILABLE", "120", "10", "120", "10");
		DefaultChannel defChan = new DefaultChannel("5", "130", "120", "1", "10", "30", "999", "10",
				"DefaultChannel5", "8880", "AVAILABLE", "15", "true", "120", "10", "120", "10", "40", "100");
		List<ServiceChannel> listServChann = new ArrayList<ServiceChannel>();
		ServiceChannel servChan;
		List<String> autId = new ArrayList<String>();
		autId.add("servicio1");
		autId.add("servicio2");
		autId.add("servicio3");
		AuthorizedServices autServ = new AuthorizedServices(autId);
		servChan = new ServiceChannel("5", "130", "120", "5", "10", "30", "999", "10",
				"ServChanel5", "AVAILABLE", "8880", "15", autServ, "true", "120", "10", "120", "10", "40", "100");
		listServChann.add(servChan);
		ServiceChannels servChannels = new ServiceChannels(listServChann);
		ServiceNode tag = new ServiceNode("Node5", "172.20.20.20", "50-CORREGIDO", admChan, defChan, servChannels);
		new ServiceNodeXmlController().actualizar(tag);
    	
    	lista = new ServiceNodeXmlController().obtener();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "Node5";
    	new ServiceNodeXmlController().eliminar(s);
    	
    	lista = new ServiceNodeXmlController().obtener();
		assertNotNull(lista);
        assertEquals(4, lista.size());
    }
}
