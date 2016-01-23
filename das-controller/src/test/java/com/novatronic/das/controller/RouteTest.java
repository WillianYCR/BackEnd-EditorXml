package com.novatronic.das.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.controller.formateo.RouteXmlController;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
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

		lista = new RouteXmlController().obtener();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Route route = new Route("rutaServicio3", "Ruta de prueba PPV CORRECTO", "balancerPPV", "AVAILABLE");
    	new RouteXmlController().insertar(route);
    	
    	lista = new RouteXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Route route = new Route("rutaServicio3", "Ruta de prueba PPV CORREGIDO", "balancerPPV", "AVAILABLE");
    	new RouteXmlController().actualizar(route);
    	
    	lista = new RouteXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "rutaServicio3";
    	new RouteXmlController().eliminar(s);
    	
    	lista = new RouteXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
