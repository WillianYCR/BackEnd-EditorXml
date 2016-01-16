package com.novatronic.das.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.novatronic.das.controller.formateo.MessageFormatXmlController;
import com.novatronic.das.xml.config.MessageFormat;

/**
 * @author wcahuaya
 *
 */
public class MessageFormatTest {
	
	public void get() {
		new MessageFormatXmlController().obtener();
    }
	
	public void create(){
    	MessageFormat mf = new MessageFormat("RERERE", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "777777");
    	
    	new MessageFormatXmlController().insertar(mf);
    }
	
	public void createLista(){
		List<MessageFormat> lista;
    	lista = new ArrayList<MessageFormat>();
    	lista.add(new MessageFormat("ISOINTST", "Tramas ISO", "transformerConfig.xml", "routerConfig.xml", "ISO8583"));
    	lista.add(new MessageFormat("UNIINTER", "Tramas Planas", "transformer-canal-interno.xml", "configRuteo-canal-interno.xml", "PLAIN"));
    	lista.add(new MessageFormat("OSMONTER", "Tramas Oblicuas", "transformer-interno.xml", "configRuteo-canal.xml", "TTTTT"));
    	
    	new MessageFormatXmlController().insertarLista(lista);
    }
	
	public void update(){
    	MessageFormat mf = new MessageFormat("RERERE", "Trama de Prueba", "transformerConfig.xml", "routerConfig.xml", "888888");
    	
    	new MessageFormatXmlController().actualizar(mf);
    }
	//@Test
	public void delete(){
		String s = "RERERE";
    	
    	new MessageFormatXmlController().eliminar(s);
    }
}
