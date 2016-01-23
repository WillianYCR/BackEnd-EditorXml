package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.AuthServices;
import com.novatronic.das.xml.config.Profile;
import com.novatronic.das.xml.config.ProfileDrivers;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class ProfileTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);

		lista = XmlDAOFactory.getInstance().getProfileDAO().get();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<String> profId = new ArrayList<String>();
		profId.add("driver1");
		profId.add("driver2");
		ProfileDrivers pd = new ProfileDrivers(profId);
		
		List<String> autId = new ArrayList<String>();
		autId.add("servicio1");
		autId.add("servicio2");
		AuthServices as = new AuthServices(autId);
		Profile tag = new Profile("perfil3", "Perfild de prueba3 CORRECTA", pd, as);
    	XmlDAOFactory.getInstance().getProfileDAO().create(tag);
    	
    	lista = XmlDAOFactory.getInstance().getProfileDAO().get();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	List<String> profId = new ArrayList<String>();
		profId.add("driver1");
		profId.add("driver2");
		profId.add("driver3");
		ProfileDrivers pd = new ProfileDrivers(profId);
		
		List<String> autId = new ArrayList<String>();
		autId.add("servicio1");
		autId.add("servicio2");
		autId.add("servicio3");
		autId.add("servicio4");
		AuthServices as = new AuthServices(autId);
		Profile tag = new Profile("perfil3", "Perfild de prueba3 CORREGIDO", pd, as);
    	XmlDAOFactory.getInstance().getProfileDAO().update(tag);
    	
    	lista = XmlDAOFactory.getInstance().getProfileDAO().get();
		assertNotNull(lista);
        assertEquals(3, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "perfil3";
    	XmlDAOFactory.getInstance().getProfileDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getProfileDAO().get();
		assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
