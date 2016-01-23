package com.novatronic.das.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.controller.formateo.ServiceXmlController;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.xml.config.AuthorizationBins;
import com.novatronic.das.xml.config.Bin;
import com.novatronic.das.xml.config.Service;
import com.novatronic.das.xml.config.ServiceRoutes;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class ServiceTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = new ServiceXmlController().obtener();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	List<Bin> bins = new ArrayList<Bin>();
    	Bin bin;
		bin= new Bin("909090", "AVAILABLE");
		bins.add(bin);
		bin = new Bin("707070", "AVAILABLE");
		bins.add(bin);
		AuthorizationBins ab = new AuthorizationBins(bins);
		
		List<String> s = new ArrayList<String>();
		s.add("rutaServicio1");
		ServiceRoutes sr = new ServiceRoutes(s);
		Service tag = new Service("servicio3", "Servicio Promocion CORRECTA", "", ab, sr);
		new ServiceXmlController().insertar(tag);
    	
    	lista = new ServiceXmlController().obtener();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	List<Bin> bins = new ArrayList<Bin>();
    	Bin bin;
		bin= new Bin("909090", "AVAILABLE");
		bins.add(bin);
		bin = new Bin("707070", "AVAILABLE");
		bins.add(bin);
		AuthorizationBins ab = new AuthorizationBins(bins);
		
		List<String> s = new ArrayList<String>();
		s.add("rutaServicio1");
		s.add("rutaServicio2");
		ServiceRoutes sr = new ServiceRoutes(s);
		Service tag = new Service("servicio3", "Servicio Promocion CORREGIDA", "", ab, sr);
		new ServiceXmlController().actualizar(tag);
    	
    	lista = new ServiceXmlController().obtener();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "servicio3";
    	new ServiceXmlController().eliminar(s);
    	
    	lista = new ServiceXmlController().obtener();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
