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
public class Services {

	@XmlElement(name = "service")
	private List<Service> services;

	public Services() {

	}

	public Services(List<Service> services) {
		super();
		this.services = services;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Services [services=" + services + "]";
	}

}
