package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

	@XmlElement(name = "service-id")
	private String serviceId;
	@XmlElement(name = "service-desc")
	private String serviceDesc;
	@XmlElement(name = "discriminationRules")
	private String discriminationRules;
	@XmlElement(name = "authorization-bins")
	private AuthorizationBins authorizationBins;
	@XmlElement(name = "routes")
	private ServiceRoutes routes;

	public Service() {
	}

	public Service(String serviceId, String serviceDesc,
			String discriminationRules, AuthorizationBins authorizationBins,
			ServiceRoutes routes) {
		super();
		this.serviceId = serviceId;
		this.serviceDesc = serviceDesc;
		this.discriminationRules = discriminationRules;
		this.authorizationBins = authorizationBins;
		this.routes = routes;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getDiscriminationRules() {
		return discriminationRules;
	}

	public void setDiscriminationRules(String discriminationRules) {
		this.discriminationRules = discriminationRules;
	}

	public AuthorizationBins getAuthorizationBins() {
		return authorizationBins;
	}

	public void setAuthorizationBins(AuthorizationBins authorizationBins) {
		this.authorizationBins = authorizationBins;
	}

	public ServiceRoutes getRoutes() {
		return routes;
	}

	public void setRoutes(ServiceRoutes routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceDesc="
				+ serviceDesc + ", discriminationRules=" + discriminationRules
				+ ", authorizationBins=" + authorizationBins + ", routes="
				+ routes + "]";
	}

}
