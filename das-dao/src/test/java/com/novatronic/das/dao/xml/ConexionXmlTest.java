/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.dao.xml;

import com.novatronic.das.xml.config.SixAdcConfig;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;
import com.novatronic.das.xml.configclient.SixadcClients;
import com.novatronic.estandares.helper.ResourceHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rcastillejo
 */
public class ConexionXmlTest {

    public ConexionXmlTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    
    public void read() {
        ConexionXml conn = null;
        SixAdcConfig adcConfig;
        Properties props = null;
		List lista;
        try {
        	props = ResourceHelper.findAsProperties("config.properties");
            conn = new ConexionXml(props);
            conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);

            adcConfig = conn.read(SixAdcConfig.class);
            
            assertNotNull(adcConfig.getMessageFormats());
            assertEquals(2, adcConfig.getMessageFormats().getMessageFormats().size());
            
            assertNotNull(adcConfig.getAdminQueues());
            assertEquals(5, adcConfig.getAdminQueues().getAdminQueues().size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    //@Test
    public void readClient() {
        ConexionXml conn = null;
        SixadcClients adcClient;
        Properties props = null;
        try {
        	props = ResourceHelper.findAsProperties("config.properties");
            conn = new ConexionXml(props);
            conn.open(SixadcClients.class, Constante.Xml.SIXADC_CLIENT_FILE);

            adcClient = conn.read(SixadcClients.class);
            
            assertNotNull(adcClient.getSixadcClient());
            assertEquals(169, adcClient.getSixadcClient().size());
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    //@Test
    public void save() {
    	ConexionXml conn = null;
        SixAdcConfig adcConfig;
        Properties props = null;
		List lista;
        try {
        	props = ResourceHelper.findAsProperties("config.properties");
            conn = new ConexionXml(props);
            conn.open(SixAdcConfig.class,  Constante.Xml.SIXADC_CONFIG_FILE);
            
            adcConfig = new SixAdcConfig();
            MessageFormats fmt = new  MessageFormats();
            List<MessageFormat> formats = new  ArrayList<MessageFormat>();
            formats.add(new MessageFormat());
            fmt.setMessageFormats(formats);
            
            adcConfig.setMessageFormats(fmt);

            conn.save(adcConfig);
            
            assertEquals(1, adcConfig.getMessageFormats().getMessageFormats().size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
