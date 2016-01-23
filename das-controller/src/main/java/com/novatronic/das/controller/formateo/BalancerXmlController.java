package com.novatronic.das.controller.formateo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.controller.BalancerController;
import com.novatronic.das.controller.exception.ControllerException;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.config.Balancer;

/**
 * @author wcahuaya
 *
 */
public class BalancerXmlController implements BalancerController{
	private final static Logger log = LoggerFactory.getLogger(BalancerXmlController.class.getName());

	@Override
	public List<Balancer> obtener() {
		List<Balancer> lista = null;
		try {
			lista = XmlDAOFactory.getInstance().getBalancerDAO().get();
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
	public Respuesta insertar(Balancer t) {
		try { 
			XmlDAOFactory.getInstance().getBalancerDAO().create(t);
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
	public Respuesta actualizar(Balancer t) {
		try { 
			XmlDAOFactory.getInstance().getBalancerDAO().update(t);
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
			XmlDAOFactory.getInstance().getBalancerDAO().delete(s);
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
