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
public class InFilters {

	@XmlElement(name = "in-filter")
	private List<String> inFilter;

	public InFilters() {
	}

	public InFilters(List<String> inFilter) {
		super();
		this.inFilter = inFilter;
	}

	public List<String> getInFilter() {
		return inFilter;
	}

	public void setInFilter(List<String> inFilter) {
		this.inFilter = inFilter;
	}

	@Override
	public String toString() {
		return "InFilters [inFilter=" + inFilter + "]";
	}

}
