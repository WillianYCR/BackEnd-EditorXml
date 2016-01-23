package com.novatronic.das.dao;

import com.novatronic.das.xml.config.AdminQueue;
import com.novatronic.das.xml.config.AdminQueues;

/**
 * @author wcahuaya
 *
 */
public interface AdminQueueDAO extends BaseDao<AdminQueue>{
	
	AdminQueues getObj();
}
