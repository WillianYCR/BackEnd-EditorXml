package com.novatronic.das.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.novatronic.das.dao.factory.XmlDAOFactory;
import com.novatronic.das.xml.config.MessageFormat;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatTest {
	
	public void get() {
		XmlDAOFactory.getInstance().getMessageFormatDAO().get();
    }
	
	public void create(){
    	MessageFormat mf = new MessageFormat("RERERE", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "777777");
    	
    	XmlDAOFactory.getInstance().getMessageFormatDAO().create(mf);
    }
	
	public void createLista(){
    	List<MessageFormat> lista;
    	lista = new ArrayList<MessageFormat>();
    	lista.add(new MessageFormat("ISOINTST", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "ISO8583"));
    	lista.add(new MessageFormat("UNIINTER", "Tramas Planas", "transformer-canal-interno.xml", "configRuteo-canal-interno.xml", "PLAIN"));
    	lista.add(new MessageFormat("OSMONTER", "Tramas Oblicuas", "transformer-interno.xml", "configRuteo-canal.xml", "HHHHH"));
    	
    	XmlDAOFactory.getInstance().getMessageFormatDAO().createLista(lista);
    }
	//@Test
	public void update(){
    	MessageFormat mf = new MessageFormat("RERERE", "Trama de Prueba", "transformerConfig.xml", "routerConfig.xml", "888888");
    	
    	XmlDAOFactory.getInstance().getMessageFormatDAO().update(mf);
    }
	
	public void delete(){
    	String s = "RERERE";
    	
    	XmlDAOFactory.getInstance().getMessageFormatDAO().delete(s);
    }
}
