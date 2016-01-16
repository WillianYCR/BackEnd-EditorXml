package com.novatronic.das.dao.xml;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.novatronic.das.dao.MessageFormatDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.dao.xml.format.MessageFormatXml;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatXmlDAO implements MessageFormatDAO{
	private final static Logger log = Logger.getLogger(MessageFormatXmlDAO.class.getName());
	
	@Override
	public List<MessageFormat> get(){
		ConexionXml conn = null;
		MessageFormatXml mfx = null;
		MessageFormats mfs = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(MessageFormatXml.class);
			mfx = (MessageFormatXml)conn.read();
			mfs = mfx.getMessageFormats();
			log.debug("ReadOK: [" + mfs + "]");
			return mfs.getMessageFormats();
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
		List<MessageFormat> lista = null;
		try {
			lista = get();
			for (MessageFormat mf : lista) {
				if(mf.getMessageFormatId().equals(t.getMessageFormatId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(MessageFormatXml.class);
			conn.save(getFormat(addRegistros(t)));
			
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
	public void createLista(List<MessageFormat> t) {
		ConexionXml conn = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(MessageFormatXml.class);
			conn.save(getFormat(t));
			
			log.debug("CreateListaOK: [" + t + "]");
		} catch (Exception e) {
			log.error("No se pudo insertar los registros", e);
			throw new DAOException("No se pudo insertar los registros", e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	
	@Override
	public void update(MessageFormat t) {
		ConexionXml conn = null;
		List<MessageFormat> lista = null;
		List<MessageFormat> listaReturn = null;
		try {
			listaReturn = new ArrayList<MessageFormat>();
			lista = get();
			for (MessageFormat mf : lista) {
				if(mf.getMessageFormatId().equals(t.getMessageFormatId())){
					if(!mf.getMessageFormatDesc().equals(t.getMessageFormatDesc()))
						mf.setMessageFormatDesc(t.getMessageFormatDesc());
					if(!mf.getRouterConfigFile().equals(t.getRouterConfigFile()))
						mf.setRouterConfigFile(t.getRouterConfigFile());
					if(!mf.getTransformerConfigFile().equals(t.getTransformerConfigFile()))
						mf.setTransformerConfigFile(t.getTransformerConfigFile());
					if(!mf.getTransformerStruct().equals(t.getTransformerStruct()))
						mf.setTransformerStruct(t.getTransformerStruct());
				}
				listaReturn.add(mf);
			}
			
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(MessageFormatXml.class);
			conn.save(getFormat(listaReturn));
			
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
		List<MessageFormat> lista = null;
		List<MessageFormat> listaReturn = null;
		try {
			if(s == null || s.isEmpty())
				throw new DAOException("Parametro vacio");
			
			listaReturn = new ArrayList<MessageFormat>();
			lista = get();
			for (MessageFormat mf : lista) {
				if(!mf.getMessageFormatId().equals(s)){
					listaReturn.add(mf);
				}
			}
			
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(MessageFormatXml.class);
			conn.save(getFormat(listaReturn));
			
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
	
	private MessageFormatXml getFormat(List<MessageFormat> lista){
		MessageFormats mfs = null;
		MessageFormatXml mfx = null;
		mfs = new MessageFormats();
		mfx = new MessageFormatXml();
		
		mfs.setMessageFormats(lista);
		mfx.addMessageFormats(mfs);
		return mfx;
	}
	
	
	private List<MessageFormat> addRegistros(MessageFormat t){
		List<MessageFormat> lista = null;
		lista = get();
		lista.add(t);
		return lista;
	}
	

}
