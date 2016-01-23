package com.novatronic.das.dao;

/**
 * @author wcahuaya
 *
 */
public interface DAOFactory {
    
    void destroy();

    MessageFormatDAO getMessageFormatDAO();
    
    AdminQueueDAO getAdminQueueDAO();
    
    SixadcClientDAO getSixAdcClientDAO();
    
    DriverDAO getDriverDAO(); 
    
    BalancerDAO getBalancerDAO();
    
    RouteDAO getRouteDAO();
    
    ServiceDAO getServiceDAO();
    
    ProfileDAO getProfileDAO();
    
    ServiceNodeDAO getServiceNodeDAO();
}
