/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs.listener;

import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.estandares.helper.ResourceHelper;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ofernandez
 */
public class ConfigListener implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(ConfigListener.class);
    private static final String CONFIG_FILE = "config.properties";
    private Properties props;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Iniciando servicio ...");
        try {
            
            props = ResourceHelper.findAsProperties(CONFIG_FILE);
            log.info("Properties : " + props);
            SingletonConnectionFactory.init(props);
            
            log.info("Proceso de inicio del Servicio realizado correctamente");

        } catch (Exception ex) {
            log.error("No fue posible inciar el servicio", ex); 
            throw new RuntimeException("No fue posible inciar el servicio", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Deteniendo el servicio ...");
        try {
        	SingletonConnectionFactory.destroy();
            log.info("Contexto terminado correctamente");
        } catch (Exception ex) {
            log.error("Se tuvo problemas al finalizar el servicio", ex);
            throw new RuntimeException("Se tuvo problemas al finalizar el servicio", ex);
        }
    }
}
