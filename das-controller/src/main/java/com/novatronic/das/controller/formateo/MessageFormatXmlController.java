package com.novatronic.das.controller.formateo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.controller.MessageFormatController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.MessageFormat;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatXmlController implements MessageFormatController{
	private final static Logger log = LoggerFactory.getLogger(MessageFormatXmlController.class.getName());

	@Override
	public List<MessageFormat> obtener() {
		List<MessageFormat> lista = null;
		try {
			lista = XmlDAOFactory.getInstance().getMessageFormatDAO().get();
			log.debug("Obtener lista: [" + lista + "]");
			return lista;
		} catch (DAOException e) {
			log.error("No se obtubo la consulta", e);
			throw new ControllerException("No se obtubo la consulta", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
		
	}
	
	@Override
	public Respuesta insertar(MessageFormat t) {
		try { 
			XmlDAOFactory.getInstance().getMessageFormatDAO().create(t);
			log.debug("Insert: [" + t + "]");
			return new Respuesta("00", "La insercion se realizo satisfactoriamente");
		} catch (DAOException e) {
			log.error("No se realizo la insersion", e);
			throw new ControllerException("No se realizo la insersion", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
	}

	@Override
	public Respuesta actualizar(MessageFormat t) {
		try { 
			XmlDAOFactory.getInstance().getMessageFormatDAO().update(t);
			log.debug("Update: [" + t + "]");
			return new Respuesta("00", "La actualizacion se realizo satisfactoriamente");
		} catch (DAOException e) {
			log.error("No se realizo la actualizacion", e);
			throw new ControllerException("No se realizo la actualizacion", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
	}

	@Override
	public Respuesta eliminar(String s) {
		try { 
			XmlDAOFactory.getInstance().getMessageFormatDAO().delete(s);
			log.debug("Delete: [" + s + "]");
			return new Respuesta("00", "La eliminacion se realizo satisfactoriamente");
		} catch (DAOException e) {
			log.error("No se realizo la eliminacion", e);
			throw new ControllerException("No se realizo la eliminacion", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
	}

	

}
