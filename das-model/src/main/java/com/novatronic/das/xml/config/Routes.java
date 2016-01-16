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
public class Routes {

	@XmlElement(name = "route")
	private List<Route> listRoute;

	public Routes() {
	}

	public Routes(List<Route> listRoute) {
		super();
		this.listRoute = listRoute;
	}

	public List<Route> getListRoute() {
		return listRoute;
	}

	public void setListRoute(List<Route> listRoute) {
		this.listRoute = listRoute;
	}

	@Override
	public String toString() {
		return "Routes [listRoute=" + listRoute + "]";
	}

}
