package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.ServiceNodeDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.ServiceNode;
import com.novatronic.das.xml.config.ServiceNodes;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class ServiceNodeXmlDAO implements ServiceNodeDAO{
	private final static Logger log = LoggerFactory.getLogger(ServiceNodeXmlDAO.class.getName());
	
	@Override
	public List<ServiceNode> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		ServiceNodes tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServiceNodes();
			log.debug("Read: " + tag.getServiceNodes().size() + " [" + tag + "]");
			return tag.getServiceNodes();
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
	public void create(ServiceNode t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		ServiceNodes tag = null;
		List<ServiceNode> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServiceNodes();
			lista = tag.getServiceNodes();
			for (ServiceNode servNod : lista) {
				if(servNod.getServiceNodeId().equals(t.getServiceNodeId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setServiceNodes(lista);
			sixXml.setServiceNodes(tag);
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
	public void update(ServiceNode t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		ServiceNodes tag = null;
		List<ServiceNode> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getServiceNodes();
			lista = tag.getServiceNodes();
			for (int i = 0; i < lista.size(); i++) {
				ServiceNode servNod = lista.get(i);
				if(servNod.getServiceNodeId().equals(t.getServiceNodeId())){
					lista.set(i, t);
					break;
				}
			}
			
			tag.setServiceNodes(lista);
			sixXml.setServiceNodes(tag);
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
		ServiceNodes queues = null;
		List<ServiceNode> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			queues = sixXml.getServiceNodes();
			lista = queues.getServiceNodes();
			for (int i = 0; i < lista.size(); i++) {
				ServiceNode servNod = lista.get(i);
				if(servNod.getServiceNodeId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			queues.setServiceNodes(lista);
			sixXml.setServiceNodes(queues);
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
