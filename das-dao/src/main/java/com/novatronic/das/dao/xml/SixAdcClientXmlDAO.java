package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.SixAdcClientDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.configclient.SixadcClient;
import com.novatronic.das.xml.configclient.SixadcClients;

/**
 * @author wcahuaya
 *
 */
public class SixAdcClientXmlDAO implements SixAdcClientDAO{
	private final static Logger log = LoggerFactory.getLogger(SixAdcClientXmlDAO.class.getName());
	
	@Override
	public List<SixadcClient> get() {
		ConexionXml conn = null;
		SixadcClients sixCli = null;
		List<SixadcClient> tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixadcClients.class, Constante.Xml.SIXADC_CLIENT_FILE);
			sixCli = conn.read(SixadcClients.class);
			
			tag = sixCli.getSixadcClient();
			log.debug(tag.size() + " [" + tag + "]");
			return tag;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public void create(SixadcClient t) {
		ConexionXml conn = null;
		SixadcClients sixCli = null;
		List<SixadcClient> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixadcClients.class, Constante.Xml.SIXADC_CLIENT_FILE);
			sixCli = conn.read(SixadcClients.class);

			lista = sixCli.getSixadcClient();
			for (SixadcClient cli : lista) {
				if(cli.getSixadcClientId().equals(t.getSixadcClientId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			sixCli.setSixadcClient(lista);
			conn.save(sixCli);
			
			log.info("Create: [" + t + "]");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public void update(SixadcClient t) {
		ConexionXml conn = null;
		SixadcClients sixCli = null;
		List<SixadcClient> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixadcClients.class, Constante.Xml.SIXADC_CLIENT_FILE);
			sixCli = conn.read(SixadcClients.class);

			lista = sixCli.getSixadcClient();
			for (int i = 0; i < lista.size(); i++) {
				SixadcClient cli = lista.get(i);
				if(cli.getSixadcClientId().equals(t.getSixadcClientId())){
					lista.set(i, t);
					break;
				}
			}
			
			sixCli.setSixadcClient(lista);
			conn.save(sixCli);
			
			log.info("Update: [" + t + "]");
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
		SixadcClients sixCli = null;
		List<SixadcClient> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixadcClients.class, Constante.Xml.SIXADC_CLIENT_FILE);
			sixCli = conn.read(SixadcClients.class);

			lista = sixCli.getSixadcClient();
			for (int i = 0; i < lista.size(); i++) {
				SixadcClient cli = lista.get(i);
				if(cli.getSixadcClientId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			sixCli.setSixadcClient(lista);
			conn.save(sixCli);
			
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
