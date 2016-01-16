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
public class Atributos {

	@XmlElement(name = "atributo")
	private List<Atributo> atributo;

	public Atributos() {

	}

	public Atributos(List<Atributo> atributo) {
		super();
		this.atributo = atributo;
	}

	public List<Atributo> getAtributo() {
		return atributo;
	}

	public void setAtributo(List<Atributo> atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Atributos [atributo=" + atributo + "]";
	}
}
