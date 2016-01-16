package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Route {

	@XmlElement(name = "route-id")
	private String routeId;
	@XmlElement(name = "route-desc")
	private String routeDesc;
	@XmlElement(name = "balancer-id")
	private String balancerId;
	@XmlElement(name = "status")
	private String status;

	public Route() {
	}

	public Route(String routeId, String routeDesc, String balancerId,
			String status) {
		super();
		this.routeId = routeId;
		this.routeDesc = routeDesc;
		this.balancerId = balancerId;
		this.status = status;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRouteDesc() {
		return routeDesc;
	}

	public void setRouteDesc(String routeDesc) {
		this.routeDesc = routeDesc;
	}

	public String getBalancerId() {
		return balancerId;
	}

	public void setBalancerId(String balancerId) {
		this.balancerId = balancerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeDesc=" + routeDesc
				+ ", balancerId=" + balancerId + ", status=" + status + "]";
	}

}
