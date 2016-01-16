package com.novatronic.das.util;

import com.novatronic.das.util.out.Respuesta;

public class RespuestaServicio {
	
	public static Respuesta responseDefault(){
		return new Respuesta("ERROR", "Default", "Desconocido");
	}
	
	public static Respuesta responseOK(){
		return new Respuesta("OK", "Satisfactorio");
	}
}
