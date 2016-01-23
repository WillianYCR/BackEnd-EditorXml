package com.novatronic.das.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.configclient.Atributo;
import com.novatronic.das.xml.configclient.Atributos;
import com.novatronic.das.xml.configclient.IpAddresses;
import com.novatronic.das.xml.configclient.SixadcClient;
import com.novatronic.das.xml.configclient.SixadcClientProfiles;
import com.novatronic.estandares.helper.ResourceHelper;

/**
 * @author wcahuaya
 *
 */
public class SixadcClientTest {
	
	@Test
	public void get() {
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		lista = XmlDAOFactory.getInstance().getSixAdcClientDAO().get();
		assertNotNull(lista);
        assertEquals(169, lista.size());
    }
	
	public void create(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<Atributo> atributo;
    	List<String> ipAddress;
    	List<String> profileId;
    	Atributos atributos;
    	IpAddresses ipAddresses;
    	SixadcClientProfiles sixadcClientProfiles;
    	SixadcClient sixadcClient;
    	//SixadcClient1
    	atributo = new ArrayList<Atributo>();
    	atributo.add(new Atributo("binAdq", "222185", ""));
    	atributos = new Atributos(atributo);
    	ipAddress = new ArrayList<String>();
    	ipAddress.add(new String("172.19.103.29"));
    	ipAddresses = new IpAddresses(ipAddress);
    	profileId = new ArrayList<String>();
    	profileId.add(new String("perfil1"));
    	profileId.add(new String("perfil2"));
    	sixadcClientProfiles = new SixadcClientProfiles(profileId);
    	
    	sixadcClient = new SixadcClient("adc500", "CONEXION CORRECTA", atributos, ipAddresses, "none100", "none100", "", "true", sixadcClientProfiles);
		XmlDAOFactory.getInstance().getSixAdcClientDAO().create(sixadcClient);
    	
		lista = XmlDAOFactory.getInstance().getSixAdcClientDAO().get();
		assertNotNull(lista);
        assertEquals(170, lista.size());
    }
	
	public void update(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
		List<Atributo> atributo;
    	List<String> ipAddress;
    	List<String> profileId;
    	Atributos atributos;
    	IpAddresses ipAddresses;
    	SixadcClientProfiles sixadcClientProfiles;
    	SixadcClient sixadcClient;
    	//SixadcClient1
    	atributo = new ArrayList<Atributo>();
    	atributo.add(new Atributo("binAdq", "222185", ""));
    	atributos = new Atributos(atributo);
    	ipAddress = new ArrayList<String>();
    	ipAddress.add(new String("172.19.103.29"));
    	ipAddresses = new IpAddresses(ipAddress);
    	profileId = new ArrayList<String>();
    	profileId.add(new String("perfil1"));
    	profileId.add(new String("perfil2"));
    	sixadcClientProfiles = new SixadcClientProfiles(profileId);
    	
    	sixadcClient = new SixadcClient("adc500", "CONEXION CORREGIDA", atributos, ipAddresses, "none100", "none100", "", "true", sixadcClientProfiles);
		XmlDAOFactory.getInstance().getSixAdcClientDAO().update(sixadcClient);
    	
		lista = XmlDAOFactory.getInstance().getSixAdcClientDAO().get();
		assertNotNull(lista);
        assertEquals(170, lista.size());
    }
	
	public void delete(){
		Properties props = null;
		List lista;
    	props = ResourceHelper.findAsProperties("config.properties");
    	SingletonConnectionFactory.init(props);
    	
    	String s = "adc500";
    	XmlDAOFactory.getInstance().getSixAdcClientDAO().delete(s);
    	
    	lista = XmlDAOFactory.getInstance().getSixAdcClientDAO().get();
    	assertNotNull(lista);
        assertEquals(169, lista.size());
    }
}
