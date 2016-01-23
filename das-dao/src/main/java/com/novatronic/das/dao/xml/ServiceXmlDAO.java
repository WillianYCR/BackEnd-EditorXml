package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.ServiceDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.Service;
import com.novatronic.das.xml.config.Services;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class ServiceXmlDAO implements ServiceDAO{
	private final static Logger log = LoggerFactory.getLogger(ServiceXmlDAO.class.getName());
	
	@Override
	public List<Service> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Services tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServices();
			log.debug("Read: " + tag.getServices().size() + " [" + tag + "]");
			return tag.getServices();
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
	public void create(Service t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Services tag = null;
		List<Service> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServices();
			lista = tag.getServices();
			for (Service serv : lista) {
				if(serv.getServiceId().equals(t.getServiceId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setServices(lista);
			sixXml.setServices(tag);
			conn.save(sixXml);
			
			log.debug("Create: [" + t + "]");
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
	public void update(Service t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Services tag = null;
		List<Service> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServices();
			lista = tag.getServices();
			for (int i = 0; i < lista.size(); i++) {
				Service serv = lista.get(i);
				if(serv.getServiceId().equals(t.getServiceId())){
					lista.set(i, t);
					break;
				}
			}
			
			tag.setServices(lista);
			sixXml.setServices(tag);
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
		Services tag = null;
		List<Service> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServices();
			lista = tag.getServices();
			for (int i = 0; i < lista.size(); i++) {
				Service adminQueue = lista.get(i);
				if(adminQueue.getServiceId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			tag.setServices(lista);
			sixXml.setServices(tag);
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
