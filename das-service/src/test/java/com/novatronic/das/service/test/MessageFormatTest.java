package com.novatronic.das.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.novatronic.das.service.rs.xml.MessageFormatXmlJson;
import com.novatronic.das.xml.config.MessageFormat;
import com.novatronic.das.xml.config.MessageFormats;


/**
 * @author wcahuaya
 *
 */
public class MessageFormatTest {
	
	public void get() {
		new MessageFormatXmlJson().obtener();
    }
	
	public void create(){
    	MessageFormat mf = new MessageFormat("RERERE", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "777777");
    	
    	new MessageFormatXmlJson().insertar(mf);
    }
	
	
	public void createLista(){
		List<MessageFormat> lista;
    	lista = new ArrayList<MessageFormat>();
    	lista.add(new MessageFormat("ISOINTST", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "ISO8583"));
    	lista.add(new MessageFormat("UNIINTER", "Tramas Planas", "transformer-canal-interno.xml", "configRuteo-canal-interno.xml", "PLAIN"));
    	lista.add(new MessageFormat("OSMONTER", "Tramas Oblicuas", "transformer-interno.xml", "configRuteo-canal.xml", "WWWWWW"));
    	
    	MessageFormats mfs = new MessageFormats();
    	mfs.setMessageFormats(lista);
    	new MessageFormatXmlJson().insertarLista(mfs);
    }
	
	public void update(){
    	MessageFormat mf = new MessageFormat("RERERE", "Trama de Prueba", "transformerConfig.xml", "routerConfig.xml", "888888");
    	
    	new MessageFormatXmlJson().actualizar(mf);
    }
	//@Test
	public void delete(){
		String s = "RERERE";
    	
    	new MessageFormatXmlJson().eliminar(s);
    }
}
