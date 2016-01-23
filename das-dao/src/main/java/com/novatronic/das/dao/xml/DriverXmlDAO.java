package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.DriverDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.Driver;
import com.novatronic.das.xml.config.Drivers;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class DriverXmlDAO implements DriverDAO{
	private final static Logger log = LoggerFactory.getLogger(DriverXmlDAO.class.getName());
	
	@Override
	public List<Driver> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Drivers tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getDrivers();
			log.debug("Read: " + tag.getDrivers().size() + " [" + tag + "]");
			return tag.getDrivers();
		} catch (Exception e) {
			log.error("No realizar la consulta", e);
			throw new DAOException("No realizar la consulta", e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public void create(Driver t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Drivers tag = null;
		List<Driver> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getDrivers();
			lista = tag.getDrivers();
			for (Driver driver : lista) {
				if(driver.getDriverId().equals(t.getDriverId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setDrivers(lista);
			sixXml.setDrivers(tag);
			conn.save(sixXml);
			
			log.debug("CreateOK: [" + t + "]");
		} catch (Exception e) {
			log.error("No se pudo insertar el registro", e);
			throw new DAOException("No se pudo insertar el registro", e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	
	@Override
	public void update(Driver t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Drivers tag = null;
		List<Driver> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getDrivers();
			lista = tag.getDrivers();
			for (int i = 0; i < lista.size(); i++) {
				Driver driver = lista.get(i);
				if(driver.getDriverId().equals(t.getDriverId())){
					lista.set(i, t);
					break;
				}
			}
			
			tag.setDrivers(lista);
			sixXml.setDrivers(tag);
			conn.save(sixXml);
			
			log.debug("Update: [" + t + "]");
		} catch (Exception e) {
			log.error("No se pudo actualizar", e);
			throw new DAOException("No se pudo actualizar", e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public void delete(String s) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Drivers tag = null;
		List<Driver> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getDrivers();
			lista = tag.getDrivers();
			for (int i = 0; i < lista.size(); i++) {
				Driver driver = lista.get(i);
				if(driver.getDriverId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			tag.setDrivers(lista);
			sixXml.setDrivers(tag);
			conn.save(sixXml);
			
			log.debug("Delete: [" + s + "]");
		} catch (Exception e) {
			log.error("No se pudo eliminar", e);
			throw new DAOException("No se pudo eliminar", e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

}
