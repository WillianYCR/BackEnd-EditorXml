package com.novatronic.das.controller;

import com.novatronic.das.xml.config.AdminQueue;
import com.novatronic.das.xml.config.AdminQueues;

/**
 * @author wcahuaya
 *
 */
public interface AdminQueueController extends BaseController<AdminQueue>{
	
	AdminQueues obtenerObjeto();
}
