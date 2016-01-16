package com.novatronic.das.xml.configclient;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IpAddresses {

	@XmlElement(name = "ip-address")
	private List<String> ipAddress;

	public IpAddresses() {

	}

	public IpAddresses(List<String> ipAddress) {
		super();
		this.ipAddress = ipAddress;
	}

	public List<String> getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(List<String> ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "IpAddresses [ipAddress=" + ipAddress + "]";
	}

}
