package com.novatronic.das.dao.conn;

import java.util.logging.Logger;

public class CompBDConnection {
/*
    private static final Logger log = Logger.getLogger(CompBDConnection.class);

    private BDConnectionFactory factory;

    public void connectionValidate() {
        BDConnection conection = null;
        
        conection = get();
        try {
            conection.validate();
        } catch (BDException ex) {
            throw new WFDBConnectionException("Error al validar la conexion", SProcedureExpCode.SQL_ERROR, ex);
        } finally {
            if (conection != null) {
                try {
                    conection.close();
                } catch (BDException ex) {
                    log.warn("No se pudo cerrar la conexion [" + ex.getMessage() + "]");
                }
            }
        }
    }

    public BDConnection get() {
        try {
            return factory.getConnection();
        } catch (BDException ex) {
            throw new WFDBConnectionException("Error al obtener la conexion", SProcedureExpCode.SQL_ERROR, ex);
        }
    }

    public void config(String config) {
        Properties param;

        param = readConfig(config);
        try {
            factory = BDConnectionFactory.createConnectionFactory(param, param);
        } catch (BDException ex) {
            throw new WFDBConnectionException("Error al configurar la conexion [" + config + "]", SProcedureExpCode.SQL_ERROR, ex);
        }

    }

    private Properties readConfig(String configfile) {
        Properties config = new Properties();
        try {
            URL url = ResourceHelper.find(configfile);
            config.load(url.openStream());
            return config;
        } catch (Exception ex) {
            throw new WFDBConnectionException("Error al cargar la configuracion [" + configfile + "]", SProcedureExpCode.SQL_ERROR, ex);
        } 
    }

    public void destroy() {        
        try {
            factory.destroy();
        } catch (BDException ex) {
            throw new WFDBConnectionException("Error al destruir el factory", SProcedureExpCode.SQL_ERROR, ex);
        }
    }
*/
}
