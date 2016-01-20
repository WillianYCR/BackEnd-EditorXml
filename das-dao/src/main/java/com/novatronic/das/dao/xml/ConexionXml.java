package com.novatronic.das.dao.xml;

import java.io.File;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.novatronic.das.dao.exception.DAOException;
import com.novatronic.das.xml.config.SixAdcConfig;

/**
 * @author wcahuaya
 *
 */
public class ConexionXml{
	private final static Logger log = Logger.getLogger(ConexionXml.class.getName());
	
	private File filesource;
	private JAXBContext jc;
	private Properties prop;
	
	public ConexionXml(){            
		
	}
        
	public ConexionXml(Properties prop){
		this.prop = prop;
    }
        
		
	public void open(Class c, String resource){
		String path = prop.getProperty(Constante.Xml.SIXADC_PATH);
		String config = prop.getProperty(resource);
        File f = new File (path, config);
		if(f.exists()){
			this.filesource = f;
		}else{
			throw new DAOException("El archivo no existe.");
		}
		try {
    		jc = JAXBContext.newInstance(c);
        } catch (JAXBException e) {
        	log.error("No se pudo instanciar el contexto de JAXB", e);
        }
    }
	//public static <C> C getInstance(Class<C> claz) 
	public <C> C read(Class<C> claz){
		Object obj;
		try {
			log.info(claz);
			log.info(filesource);
	        Unmarshaller u = jc.createUnmarshaller();
	        obj = u.unmarshal(filesource);
	        return claz.cast(obj);
	    }catch (UnmarshalException e) {
	    	log.error("error al leer el xml ["+ filesource +"]", e);
	    	throw new DAOException("error al leer el xml ["+ filesource +"]", e);
	    }catch (JAXBException e) {
	    	log.error("No se pudo crear el objeto Unmarshaller", e);
	        throw new DAOException("Error al crear el objeto Unmarshaller", e);
	    }catch (Exception e) {
	    	log.error("Proceso desconocido en conexion", e);
	        throw new DAOException("Error desconocido en conexion", e);
	    }
	}

	public void save(Object obj){
		try {
	        Marshaller jaxbMarshaller = jc.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, filesource);
            jaxbMarshaller.marshal(obj, System.out);
	    }catch (UnmarshalException e) {
	    	log.error("El archivo ["+ filesource +"] no existe en la ruta especificada", e);
	    	throw new DAOException("El archivo ["+ filesource +"] no existe en la ruta especificada", e);
	    }catch (JAXBException e) {
	    	log.error("Error al crear el objeto marshaller", e);
	        throw new DAOException("Error al crear el objeto marshaller", e);
	    }catch (Exception e) {
	    	log.error("Error desconocido en conexion", e);
	        throw new DAOException("Error desconocido en conexion", e);
	    }
	}
	
	public void close(){
		filesource = null;
	} 
}
