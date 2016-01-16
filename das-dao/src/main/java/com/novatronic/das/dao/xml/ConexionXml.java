package com.novatronic.das.dao.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.novatronic.das.dao.exception.DAOException;

/**
 * @author wcahuaya
 *
 */
public class ConexionXml{
	private final static Logger log = Logger.getLogger(MessageFormatXmlDAO.class.getName());
	
	private File filesource;
	private JAXBContext jc;
	
	public ConexionXml(){
		this.filesource = new File (Constante.Xml.SIXADC_CONFIGURATOR);
	}
		
	@SuppressWarnings("rawtypes")
	public void open(Class c){
		try {
    		jc = JAXBContext.newInstance(c);
        } catch (JAXBException e) {
        	log.error("No se pudo instanciar el contexto de JAXB", e);
        }
    }
	
	public Object read(){
		Object obj;
		try {
	        Unmarshaller u = jc.createUnmarshaller();
	        obj = u.unmarshal(filesource);
	    }catch (UnmarshalException e) {
	    	log.error("El archivo ["+ filesource +"] no existe en la ruta especificada", e);
	    	throw new DAOException("El archivo ["+ filesource +"] no existe en la ruta especificada", e);
	    }catch (JAXBException e) {
	    	log.error("No se pudo crear el objeto Unmarshaller", e);
	        throw new DAOException("Error al crear el objeto Unmarshaller", e);
	    }catch (Exception e) {
	    	log.error("Proceso desconocido en conexion", e);
	        throw new DAOException("Error desconocido en conexion", e);
	    }
		return obj;
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
