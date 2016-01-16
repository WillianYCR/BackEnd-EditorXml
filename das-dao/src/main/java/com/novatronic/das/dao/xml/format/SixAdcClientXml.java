package com.novatronic.das.dao.xml.format;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.novatronic.das.xml.configclient.SixadcClient;

/**
 * @author wcahuaya
 *
 */
@XmlRootElement(name = "sixadc-clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class SixAdcClientXml {
	
	@XmlElement(name = "sixadc-client")
    private List<SixadcClient> sixadcClient;
	
	public SixAdcClientXml() {
		sixadcClient = new ArrayList<SixadcClient>();
	}
	
	public void addSixadcClient(SixadcClient sixadcClient) {
    	this.sixadcClient.add(sixadcClient);
    }
	
	public List<SixadcClient> getSixadcClient() {
		return sixadcClient;
	}
}
