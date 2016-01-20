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
	private List<SixadcClient> sixadcClient;

	public SixadcClients() {
		sixadcClient = new ArrayList<SixadcClient>();
	}

	public List<SixadcClient> getSixadcClient() {
		return sixadcClient;
	}

	public void setSixadcClient(List<SixadcClient> sixadcClient) {
		this.sixadcClient = sixadcClient;
	}

	@Override
	public String toString() {
		return "SixAdcClients [sixadcClient=" + sixadcClient + "]";
	}

}
