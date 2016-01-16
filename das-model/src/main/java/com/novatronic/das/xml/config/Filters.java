package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters {

	@XmlElement(name = "in-filters")
	private InFilters inFilters;
	@XmlElement(name = "out-filters")
	private OutFilters outFilters;

	public Filters() {

	}

	public Filters(InFilters inFilters, OutFilters outFilters) {
		super();
		this.inFilters = inFilters;
		this.outFilters = outFilters;
	}

	public InFilters getInFilters() {
		return inFilters;
	}

	public void setInFilters(InFilters inFilters) {
		this.inFilters = inFilters;
	}

	public OutFilters getOutFilters() {
		return outFilters;
	}

	public void setOutFilters(OutFilters outFilters) {
		this.outFilters = outFilters;
	}

	@Override
	public String toString() {
		return "Filters [inFilters=" + inFilters + ", outFilters=" + outFilters
				+ "]";
	}

}
