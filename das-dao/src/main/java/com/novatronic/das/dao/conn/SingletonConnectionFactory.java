package com.novatronic.das.dao.conn;

import java.util.Properties;

import com.novatronic.das.dao.xml.ConexionXml;

/**
 * @author wcahuaya
 *
 */
public class SingletonConnectionFactory {

	public static final int BD = 0;
	public static final int XML = 1;
	private static Properties fileProp;
	
	public static void init(Properties props){
		fileProp = props;
	}
	
	public static Object getConnection(int tipo) throws Exception{
		switch(tipo){
		case BD: return new CompBDConnection();
		case XML: return new ConexionXml(fileProp);
		default: throw new Exception();
		}
	}
	
	public static void destroy(){
		fileProp = null;
	}
}
