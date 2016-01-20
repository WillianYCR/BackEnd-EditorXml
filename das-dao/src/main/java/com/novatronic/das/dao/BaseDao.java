package com.novatronic.das.dao;

import java.util.List;

/**
 * @author wcahuaya
 *
 * @param <T>
 */
public interface BaseDao<T> {

    List<T> get();

    void create(T t);

    void update(T t);
    
    void delete(String s);
}
