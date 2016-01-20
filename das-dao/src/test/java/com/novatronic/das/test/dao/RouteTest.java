package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.Route;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class RouteTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = XmlDAOFactory.getInstance().getRouteDAO().get();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Route route = new Route("rutaServicio3", "Ruta de prueba PPV CORRECTO", "balancerPPV", "AVAILABLE");
    	XmlDAOFactory.getInstance().getRouteDAO().create(route);
    	
    	lista = XmlDAOFactory.getInstance().getRouteDAO().get();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Route route = new Route("rutaServicio3", "Ruta de prueba PPV CORREGIDO", "balancerPPV", "AVAILABLE");
    	XmlDAOFactory.getInstance().getRouteDAO().update(route);
    	
    	lista = XmlDAOFactory.getInstance().getRouteDAO().get();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "rutaServicio3";
    	XmlDAOFactory.getInstance().getRouteDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getRouteDAO().get();
    	assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
