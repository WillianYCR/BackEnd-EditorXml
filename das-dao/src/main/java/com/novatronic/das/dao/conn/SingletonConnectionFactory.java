package com.novatronic.das.dao.conn;

import com.novatronic.das.dao.xml.ConexionXml;

/**
 * @author wcahuaya
 *
 */
public class SingletonConnectionFactory {

	public static final int BD = 0;
	public static final int XML = 1;
	
	public static void init(){
	}
	
	public static Object getConnection(int tipo) throws Exception{
		switch(tipo){
		case BD: return new CompBDConnection();
		case XML: return new ConexionXml();
		default: throw new Exception();
		}
	}
}
