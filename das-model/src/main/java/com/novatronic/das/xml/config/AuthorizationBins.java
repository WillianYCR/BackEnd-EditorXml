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
public class AuthorizationBins {

	@XmlElement(name = "bin")
	private List<Bin> bin;

	public AuthorizationBins() {
	}

	public AuthorizationBins(List<Bin> bin) {
		super();
		this.bin = bin;
	}

	public List<Bin> getBin() {
		return bin;
	}

	public void setBin(List<Bin> bin) {
		this.bin = bin;
	}

	@Override
	public String toString() {
		return "AuthorizationBins [bin=" + bin + "]";
	}

}
