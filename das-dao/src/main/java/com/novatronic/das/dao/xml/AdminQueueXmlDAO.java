package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.AdminQueueDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.AdminQueue;
import com.novatronic.das.xml.config.AdminQueues;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class AdminQueueXmlDAO implements AdminQueueDAO{
	private final static Logger log = LoggerFactory.getLogger(AdminQueueXmlDAO.class.getName());
	
	@Override
	public List<AdminQueue> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		AdminQueues tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getAdminQueues();
			log.debug("ReadOK: " + tag.getAdminQueues().size() + " [" + tag + "]");
			return tag.getAdminQueues();
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
	public void create(AdminQueue t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		AdminQueues tag = null;
		List<AdminQueue> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getAdminQueues();
			lista = tag.getAdminQueues();
			for (AdminQueue adm : lista) {
				if(adm.getAdminQueueId().equals(t.getAdminQueueId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setAdminQueues(lista);
			sixXml.setAdminQueues(tag);
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
	public void update(AdminQueue t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		AdminQueues tag = null;
		List<AdminQueue> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getAdminQueues();
			lista = tag.getAdminQueues();
			for (int i = 0; i < lista.size(); i++) {
				AdminQueue adminQueue = lista.get(i);
				if(adminQueue.getAdminQueueId().equals(t.getAdminQueueId())){
					lista.set(i, t);
					break;
				}
			}
			
			tag.setAdminQueues(lista);
			sixXml.setAdminQueues(tag);
			conn.save(sixXml);
			
			log.debug("UpdateOK: [" + t + "]");
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
		AdminQueues queues = null;
		List<AdminQueue> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			queues = sixXml.getAdminQueues();
			lista = queues.getAdminQueues();
			for (int i = 0; i < lista.size(); i++) {
				AdminQueue adminQueue = lista.get(i);
				if(adminQueue.getAdminQueueId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			queues.setAdminQueues(lista);
			sixXml.setAdminQueues(queues);
			conn.save(sixXml);
			
			log.debug("DeleteOK: [" + s + "]");
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
