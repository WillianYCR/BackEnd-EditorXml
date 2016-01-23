package com.novatronic.das.dao.xml;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novatronic.das.dao.ProfileDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.Profile;
import com.novatronic.das.xml.config.Profiles;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class ProfileXmlDAO implements ProfileDAO{
	private final static Logger log = LoggerFactory.getLogger(ProfileXmlDAO.class.getName());
	
	@Override
	public List<Profile> get(){
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Profiles tag = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getProfiles();
			log.debug("Read: " + tag.getProfiles().size() + " [" + tag + "]");
			return tag.getProfiles();
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
	public void create(Profile t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Profiles tag = null;
		List<Profile> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getProfiles();
			lista = tag.getProfiles();
			for (Profile prof : lista) {
				if(prof.getProfileId().equals(t.getProfileId())){
					throw new DAOException("Identificador ya existe");
				}
			}
			lista.add(t);
			
			tag.setProfiles(lista);
			sixXml.setProfiles(tag);
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
	public void update(Profile t) {
		ConexionXml conn = null;
		SixAdcConfig sixXml = null;
		Profiles tag = null;
		List<Profile> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getProfiles();
			lista = tag.getProfiles();
			for (int i = 0; i < lista.size(); i++) {
				Profile prof = lista.get(i);
				if(prof.getProfileId().equals(t.getProfileId())){
					lista.set(i, t);
					break;
				}
			}
			
			tag.setProfiles(lista);
			sixXml.setProfiles(tag);
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
		Profiles tag = null;
		List<Profile> lista = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcConfig.class, Constante.Xml.SIXADC_CONFIG_FILE);
			sixXml = conn.read(SixAdcConfig.class);
			
			tag = sixXml.getProfiles();
			lista = tag.getProfiles();
			for (int i = 0; i < lista.size(); i++) {
				Profile prof = lista.get(i);
				if(prof.getProfileId().equals(s)){
					lista.remove(i);
					break;
				}
			}
			
			tag.setProfiles(lista);
			sixXml.setProfiles(tag);
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
