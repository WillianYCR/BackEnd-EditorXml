package com.novatronic.das.controller;

import java.util.List;

import com.novatronic.das.util.out.Respuesta;

/**
 * @author wcahuaya
 *
 * @param <T>
 */
public interface BaseController<T> {

	List<T> obtener();
	
	Respuesta insertar(T t);
	
	Respuesta actualizar(T t);
	
	Respuesta eliminar(String s);
	
}
