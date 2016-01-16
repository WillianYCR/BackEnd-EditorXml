package com.novatronic.das.xml.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthServices {

	@XmlElement(name = "service-id")
	private List<String> serviceId;

	public AuthServices() {

	}

	public AuthServices(List<String> serviceId) {
		super();
		this.serviceId = serviceId;
	}

	public List<String> getServiceId() {
		return serviceId;
	}

	public void setServiceId(List<String> serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String toString() {
		return "AuthServices [serviceId=" + serviceId + "]";
	}

}
