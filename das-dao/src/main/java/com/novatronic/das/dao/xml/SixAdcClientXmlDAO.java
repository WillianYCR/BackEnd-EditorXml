package com.novatronic.das.dao.xml;

import java.util.List;

import org.apache.log4j.Logger;

import com.novatronic.das.dao.SixAdcClientDAO;
import com.novatronic.das.dao.conn.SingletonConnectionFactory;
import com.novatronic.das.dao.xml.format.SixAdcClientXml;
import com.novatronic.das.util.RespuestaServicio;
import com.novatronic.das.util.out.Respuesta;

/**
 * @author wcahuaya
 *
 */
public class SixAdcClientXmlDAO implements SixAdcClientDAO{
	private final static Logger log = Logger.getLogger(SixAdcClientXmlDAO.class.getName());
	
	@Override
	public List<SixAdcClientXml> get() {
		ConexionXml conn = null;
		SixAdcClientXml mf = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcClientXml.class);
			mf = (SixAdcClientXml)conn.read();
			log.debug("ReadOk: " + mf.getSixadcClient());
			//return mf;
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public void create(SixAdcClientXml t) {
		ConexionXml conn = null;
		try {
			conn = (ConexionXml) SingletonConnectionFactory.getConnection(SingletonConnectionFactory.XML);
			conn.open(SixAdcClientXml.class);
			conn.save(t); 
			log.debug("SaveOk: " + t.getSixadcClient());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	
	@Override
	public void createLista(List<SixAdcClientXml> t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(SixAdcClientXml t) {
	}

	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
	}

}
