package com.novatronic.das.dao;

/**
 * @author wcahuaya
 *
 */
public interface DAOFactory {
    
    void destroy();

    MessageFormatDAO getMessageFormatDAO();
    
    SixAdcClientDAO getSixAdcClientDAO();
    
}
