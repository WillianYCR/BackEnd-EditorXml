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
	private List<Service> service;

	public Services() {

	}

	public Services(List<Service> service) {
		super();
		this.service = service;
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Services [service=" + service + "]";
	}

}
