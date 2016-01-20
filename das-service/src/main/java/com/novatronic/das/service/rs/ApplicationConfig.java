/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.das.service.rs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @author wcahuaya
 *
 */
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    	resources.add(com.novatronic.das.service.rs.json.AdminQueueJsonService.class);
    	resources.add(com.novatronic.das.service.rs.json.MessageFormatJsonService.class);
        resources.add(com.novatronic.das.service.rs.filter.LoggingFilter.class);
        resources.add(com.novatronic.das.service.rs.filter.ResponseCorsFilter.class);
        resources.add(com.novatronic.das.service.rs.interceptor.LoggingInterceptor.class);
    }

}
