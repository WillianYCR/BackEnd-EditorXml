package com.novatronic.das.dao;

/**
 * @author wcahuaya
 *
 */
public interface DAOFactory {
    
    void destroy();

    MessageFormatDAO getMessageFormatDAO();
    
    AdminQueueDAO getAdminQueueDAO();
    
    SixAdcClientDAO getSixAdcClientDAO();
    
    DriverDAO getDriverDAO(); 
    
    BalancerDAO getBalancerDAO();
    
    RouteDAO getRouteDAO();
}
