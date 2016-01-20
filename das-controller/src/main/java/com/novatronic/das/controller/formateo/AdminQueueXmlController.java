package com.novatronic.das.controller.formateo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.controller.AdminQueueController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.AdminQueue;

/**
 * @author wcahuaya
 *
 */
public class AdminQueueXmlController implements AdminQueueController{
	private final static Logger log = LoggerFactory.getLogger(AdminQueueXmlController.class.getName());

	@Override
	public List<AdminQueue> obtener() {
		List<AdminQueue> lista = null;
		try {
			lista = XmlDAOFactory.getInstance().getAdminQueueDAO().get();
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
	public Respuesta insertar(AdminQueue t) {
		try { 
			XmlDAOFactory.getInstance().getAdminQueueDAO().create(t);
			log.debug("Insert: [" + t + "]");
			return new Respuesta("00", "Se realiazo la insercion satisfactoriamente");
		} catch (DAOException e) {
			log.error("No se realizo la insersion", e);
			throw new ControllerException("No se realizo la insersion", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
	}

	@Override
	public Respuesta actualizar(AdminQueue t) {
		try { 
			XmlDAOFactory.getInstance().getAdminQueueDAO().update(t);
			log.debug("Update: [" + t + "]");
			return new Respuesta("00", "Se realiazo la actualizacion satisfactoriamente");
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
			XmlDAOFactory.getInstance().getAdminQueueDAO().delete(s);
			log.debug("Delete: [" + s + "]");
			return new Respuesta("00", "Se realiazo la eliminacion satisfactoriamente");
		} catch (DAOException e) {
			log.error("No se realizo la eliminacion", e);
			throw new ControllerException("No se realizo la eliminacion", e);
		} catch (Exception e) {
			log.error("Error de sistema", e);
			throw new ControllerException("Error de sistema", e);
		}
	}

	

}
