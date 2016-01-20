package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.Balancer;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class BalancerTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = XmlDAOFactory.getInstance().getBalancerDAO().get();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Balancer mf = new Balancer("balancerOK", "ROUND_ROBIN_CORRECTO", "15");
    	XmlDAOFactory.getInstance().getBalancerDAO().create(mf);
    	
    	lista = XmlDAOFactory.getInstance().getBalancerDAO().get();
    	assertNotNull(lista);
        assertEquals(4, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Balancer mf = new Balancer("balancerOK", "ROUND_ROBIN_CORREGIDO", "15");
    	XmlDAOFactory.getInstance().getBalancerDAO().update(mf);
    	
    	lista = XmlDAOFactory.getInstance().getBalancerDAO().get();
    	assertNotNull(lista);
        assertEquals(4, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "balancerOK";
    	XmlDAOFactory.getInstance().getBalancerDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getBalancerDAO().get();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
}
