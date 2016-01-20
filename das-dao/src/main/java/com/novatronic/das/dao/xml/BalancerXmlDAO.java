package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.BalancerDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.SixAdcConfig;
import com.novatronic.das.xml.config.Balancer;
import com.novatronic.das.xml.config.Balancers;

/**
 * @author wcahuaya
 *
 */
public class BalancerXmlDAO implements BalancerDAO{
	private final static Logger log = LoggerFactory.getLogger(BalancerXmlDAO.class.getName());
	
	@Override
	public List<Balancer> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Balancers tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getBalancers();
			log.debug(tag.getBalancers().size() + " [" + tag + "]");
			return tag.getBalancers();
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
	public void create(Balancer t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Balancers tag = null;
		List<Balancer> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getBalancers();
			lista = tag.getBalancers();
			for (Balancer bal : lista) {
				if(bal.getId().equals(t.getId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setBalancers(lista);
			sixXml.setBalancers(tag);
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
	public void update(Balancer t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Balancers tag = null;
		List<Balancer> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getBalancers();
			lista = tag.getBalancers();
			for (int i = 0; i < lista.size(); i++) {
				Balancer balancer = lista.get(i);
				if(balancer.getId().equals(t.getId())){
					lista.set(i, t);
					break;
				}
			}

			tag.setBalancers(lista);
			sixXml.setBalancers(tag);			
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
		Balancers tag = null;
		List<Balancer> lista = null;
		try {
			if(s == null || s.isEmpty())
				throw new DAOException("Parametro vacio");

			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getBalancers();
			lista = tag.getBalancers();
			for (int i = 0; i < lista.size(); i++) {
				Balancer balancer = lista.get(i);
				if(balancer.getId().equals(s)){
					lista.remove(i);
					break;
				}
			}

			tag.setBalancers(lista);
			sixXml.setBalancers(tag);	
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
