package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Bin {

	@XmlElement(name = "bin-id")
	private String binId;
	@XmlElement(name = "bin-status")
	private String binStatus;

	public Bin() {

	}

	public Bin(String binId, String binStatus) {
		super();
		this.binId = binId;
		this.binStatus = binStatus;
	}

	public String getBinId() {
		return binId;
	}

	public void setBinId(String binId) {
		this.binId = binId;
	}

	public String getBinStatus() {
		return binStatus;
	}

	public void setBinStatus(String binStatus) {
		this.binStatus = binStatus;
	}

	@Override
	public String toString() {
		return "Bin [binId=" + binId + ", binStatus=" + binStatus + "]";
	}

}
