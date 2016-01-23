package com.novatronic.das.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.controller.formateo.BalancerXmlController;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
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

		lista = new BalancerXmlController().obtener();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Balancer mf = new Balancer("balancerOK", "ROUND_ROBIN_CORRECTO", "15");
    	new BalancerXmlController().insertar(mf);
    	
    	lista = new BalancerXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(4, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	Balancer mf = new Balancer("balancerOK", "ROUND_ROBIN_CORREGIDO", "15");
    	new BalancerXmlController().actualizar(mf);
    	
    	lista = new BalancerXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(4, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "balancerOK";
    	new BalancerXmlController().eliminar(s);
    	
    	lista = new BalancerXmlController().obtener();
    	assertNotNull(lista);
        assertEquals(3, lista.size());
    }
}
