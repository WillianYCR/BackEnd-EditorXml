package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.MessageFormatDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.SixAdcConfig;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatXmlDAO implements MessageFormatDAO{
	private final static Logger log = LoggerFactory.getLogger(MessageFormatXmlDAO.class.getName());
	
	@Override
	public List<MessageFormat> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		MessageFormats tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			tag = sixXml.getMessageFormats();
			log.debug(tag.getMessageFormats().size() + " [" + tag + "]");
			return tag.getMessageFormats();
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
	public void create(MessageFormat t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		MessageFormats tag = null;
		List<MessageFormat> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getMessageFormats();
			lista = tag.getMessageFormats();
			for (MessageFormat mf : lista) {
				if(mf.getMessageFormatId().equals(t.getMessageFormatId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setMessageFormats(lista);
			sixXml.setMessageFormats(tag);
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
	public void update(MessageFormat t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		MessageFormats tag = null;
		List<MessageFormat> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getMessageFormats();
			lista = tag.getMessageFormats();
			for (int i = 0; i < lista.size(); i++) {
				MessageFormat messageFormat = lista.get(i);
				if(messageFormat.getMessageFormatId().equals(t.getMessageFormatId())){
					lista.set(i, t);
					break;
				}
			}

			tag.setMessageFormats(lista);
			sixXml.setMessageFormats(tag);			
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
		MessageFormats tag = null;
		List<MessageFormat> lista = null;
		try {
			if(s == null || s.isEmpty())
				throw new DAOException("Parametro vacio");

			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getMessageFormats();
			lista = tag.getMessageFormats();
			for (int i = 0; i < lista.size(); i++) {
				MessageFormat messageFormat = lista.get(i);
				if(messageFormat.getMessageFormatId().equals(s)){
					lista.remove(i);
					break;
				}
			}

			tag.setMessageFormats(lista);
			sixXml.setMessageFormats(tag);	
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
