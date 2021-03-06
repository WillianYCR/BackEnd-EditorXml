package com.novatronic.das.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.controller.formateo.MessageFormatXmlController;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		lista = new MessageFormatXmlController().obtener();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		MessageFormat mf = new MessageFormat("OK", "NUEVO REGISTRO", "transformerConfig.xml", "routerConfig.xml", "777777");
    	new MessageFormatXmlController().insertar(mf);
    	
    	lista = new MessageFormatXmlController().obtener();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		MessageFormat mf = new MessageFormat("OK", "CORRECCION", "transformerConfig.xml", "routerConfig.xml", "888888");
    	new MessageFormatXmlController().actualizar(mf);
    	
    	lista = new MessageFormatXmlController().obtener();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		String s = "OK";
    	new MessageFormatXmlController().eliminar(s);
    	
    	lista = new MessageFormatXmlController().obtener();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
