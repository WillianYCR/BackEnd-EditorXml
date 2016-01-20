package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.RouteDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.SixAdcConfig;
import com.novatronic.das.xml.config.Route;
import com.novatronic.das.xml.config.Routes;

/**
 * @author wcahuaya
 *
 */
public class RouteXmlDAO implements RouteDAO{
	private final static Logger log = LoggerFactory.getLogger(RouteXmlDAO.class.getName());
	
	@Override
	public List<Route> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Routes tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getRoutes();
			log.debug(tag.getRoutes().size() + " [" + tag + "]");
			return tag.getRoutes();
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
	public void create(Route t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Routes tag = null;
		List<Route> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getRoutes();
			lista = tag.getRoutes();
			for (Route route : lista) {
				if(route.getRouteId().equals(t.getRouteId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setRoutes(lista);
			sixXml.setRoutes(tag);
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
	public void update(Route t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Routes tag = null;
		List<Route> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getRoutes();
			lista = tag.getRoutes();
			for (int i = 0; i < lista.size(); i++) {
				Route route = lista.get(i);
				if(route.getRouteId().equals(t.getRouteId())){
					lista.set(i, t);
					break;
				}
			}

			tag.setRoutes(lista);
			sixXml.setRoutes(tag);			
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
		Routes tag = null;
		List<Route> lista = null;
		try {
			if(s == null || s.isEmpty())
				throw new DAOException("Parametro vacio");

			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getRoutes();
			lista = tag.getRoutes();
			for (int i = 0; i < lista.size(); i++) {
				Route route = lista.get(i);
				if(route.getRouteId().equals(s)){
					lista.remove(i);
					break;
				}
			}

			tag.setRoutes(lista);
			sixXml.setRoutes(tag);	
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
