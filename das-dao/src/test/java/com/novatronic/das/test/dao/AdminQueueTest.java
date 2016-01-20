package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.AdminQueue;
import com.novatronic.das.xml.config.MessageType;
import com.novatronic.das.xml.config.SupportedMessageFormats;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class AdminQueueTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = XmlDAOFactory.getInstance().getAdminQueueDAO().get();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<String> s = new ArrayList<String>();
		s.add("ISOINTST-A");
		s.add("ISOINTST-B");
		MessageType mt = new MessageType("TipoMensajeSIX", "Tipo de mensaje via drivers SIX", new SupportedMessageFormats(s));
		AdminQueue aq = new AdminQueue("adminCola6", "10", mt);
    	XmlDAOFactory.getInstance().getAdminQueueDAO().create(aq);
    	
    	lista = XmlDAOFactory.getInstance().getAdminQueueDAO().get();
		assertNotNull(lista);
        assertEquals(6, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<String> s = new ArrayList<String>();
		s.add("ISOINTST-C");
		MessageType mt = new MessageType("TipoMensajeSIX", "Tipo de mensaje via drivers SIX", new SupportedMessageFormats(s));
		AdminQueue aq = new AdminQueue("adminCola6", "10", mt);
    	XmlDAOFactory.getInstance().getAdminQueueDAO().update(aq);
    	
    	lista = XmlDAOFactory.getInstance().getAdminQueueDAO().get();
		assertNotNull(lista);
        assertEquals(6, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "adminCola6";
    	XmlDAOFactory.getInstance().getAdminQueueDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getAdminQueueDAO().get();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
}
