package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.Driver;
import com.novatronic.das.xml.config.Filters;
import com.novatronic.das.xml.config.InFilters;
import com.novatronic.das.xml.config.OutFilters;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class DriverTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = XmlDAOFactory.getInstance().getDriverDAO().get();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<String> inS = new ArrayList<String>();
		inS.add("com.novatronic.loadbalancer.driver.filters.PutTokenBinAdqFilter");
		InFilters inFi = new InFilters(inS);
		List<String> outS = new ArrayList<String>();
		outS.add("com.novatronic.loadbalancer.driver.filters.PutTokenBinAdqFilter");
		OutFilters outFi = new OutFilters(outS);
		Filters fi = new Filters(inFi, outFi);
		Driver tag = new Driver("driver6", "adminCorrecta", "ASYNCRONOUS", "5", "5", "5", "28", 
				"tcp_drvVISA", "4230", "50", "ISOINTST", "true", "false", fi);
    	XmlDAOFactory.getInstance().getDriverDAO().create(tag);
    	
    	lista = XmlDAOFactory.getInstance().getDriverDAO().get();
		assertNotNull(lista);
        assertEquals(6, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	List<String> inS = new ArrayList<String>();
		inS.add("com.novatronic.loadbalancer.driver.filters.PutTokenBinAdqFilter");
		InFilters inFi = new InFilters(inS);
		List<String> outS = new ArrayList<String>();
		outS.add("com.novatronic.loadbalancer.driver.filters.PutTokenBinAdqFilter1");
		outS.add("com.novatronic.loadbalancer.driver.filters.PutTokenBinAdqFilter2");
		OutFilters outFi = new OutFilters(outS);
		Filters fi = new Filters(inFi, outFi);
		Driver tag = new Driver("driver6", "adminCorregida", "ASYNCRONOUS", "5", "5", "5", "28", 
				"tcp_drvVISA", "4230", "50", "ISOINTST", "true", "false", fi);
    	XmlDAOFactory.getInstance().getDriverDAO().update(tag);
    	
    	lista = XmlDAOFactory.getInstance().getDriverDAO().get();
		assertNotNull(lista);
        assertEquals(6, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "driver6";
    	XmlDAOFactory.getInstance().getDriverDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getDriverDAO().get();
		assertNotNull(lista);
        assertEquals(5, lista.size());
    }
}
