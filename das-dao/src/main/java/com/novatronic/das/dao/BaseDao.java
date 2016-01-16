package com.novatronic.das.dao;

import java.util.List;

import com.novatronic.das.util.out.Respuesta;

/**
 * @author wcahuaya
 *
 * @param <T>
 */
public interface BaseDao<T> {

    List<T> get();

    void create(T t);
    
    void createLista(List<T> t);

    void update(T t);
    
    void delete(String s);
}
