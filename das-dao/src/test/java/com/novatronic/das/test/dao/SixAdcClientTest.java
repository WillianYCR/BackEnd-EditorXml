package com.novatronic.das.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.dao.xml.format.SixAdcClientXml;
import com.novatronic.das.xml.configclient.Atributo;
import com.novatronic.das.xml.configclient.Atributos;
import com.novatronic.das.xml.configclient.IpAddresses;
import com.novatronic.das.xml.configclient.SixadcClient;
import com.novatronic.das.xml.configclient.SixadcClientProfiles;

/**
 * @author wcahuaya
 *
 */
public class SixAdcClientTest {
	private static final  Logger log = Logger.getLogger(SixAdcClientTest.class.getName());
	
	
	public void testerXml() {
		XmlDAOFactory.getInstance().getSixAdcClientDAO().get();
    }
	
	//@Test
	public void cargarSixAdcClient(){
		SixAdcClientXml sac = new SixAdcClientXml();
		
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
    	sixadcClient = new SixadcClient("adc100", "CONEXION NAVSAT", atributos, ipAddresses, "none100", "none100", "", "true", sixadcClientProfiles);
    	sac.addSixadcClient(sixadcClient);
    	//SixadcClient2
    	atributo = new ArrayList<Atributo>();
    	atributo.add(new Atributo("binAdq", "222185", ""));
    	atributos = new Atributos(atributo);
    	ipAddress = new ArrayList<String>();
    	ipAddress.add(new String("172.19.103.45"));
    	ipAddresses = new IpAddresses(ipAddress);
    	profileId = new ArrayList<String>();
    	profileId.add(new String("perfil1"));
    	profileId.add(new String("perfil2"));
    	sixadcClientProfiles = new SixadcClientProfiles(profileId);
    	sixadcClient = new SixadcClient("adc100B", "CONEXION NAVSAT 2", atributos, ipAddresses, "none100", "none100b", "", "true", sixadcClientProfiles);
		sac.addSixadcClient(sixadcClient);
		//SixadcClient2
    	atributo = new ArrayList<Atributo>();
    	atributo.add(new Atributo("binAdq", "222185", ""));
    	atributos = new Atributos(atributo);
    	ipAddress = new ArrayList<String>();
    	ipAddress.add(new String("172.108.108.108"));
    	ipAddresses = new IpAddresses(ipAddress);
    	profileId = new ArrayList<String>();
    	profileId.add(new String("perfil3"));
    	profileId.add(new String("perfil4"));
    	sixadcClientProfiles = new SixadcClientProfiles(profileId);
    	sixadcClient = new SixadcClient("adc100C", "CONEXION NAVSAT 3", atributos, ipAddresses, "none100", "none100b", "", "true", sixadcClientProfiles);
		sac.addSixadcClient(sixadcClient);
    	
		XmlDAOFactory.getInstance().getSixAdcClientDAO().create(sac);
    	log.debug("OK : ");
    }
}
