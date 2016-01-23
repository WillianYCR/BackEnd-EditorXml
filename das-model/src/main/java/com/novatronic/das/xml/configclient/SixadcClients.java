package com.novatronic.das.xml.configclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author wcahuaya
 * 
 */
@XmlRootElement(name = "sixadc-clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class SixadcClients {

	@XmlElement(name = "sixadc-client")
	private List<SixadcClient> sixadcClients;

	public SixadcClients() {
		sixadcClients = new ArrayList<SixadcClient>();
	}

	public List<SixadcClient> getSixadcClients() {
		return sixadcClients;
	}

	public void setSixadcClients(List<SixadcClient> sixadcClients) {
		this.sixadcClients = sixadcClients;
	}

	@Override
	public String toString() {
		return "SixadcClients [sixadcClients=" + sixadcClients + "]";
	}

}
