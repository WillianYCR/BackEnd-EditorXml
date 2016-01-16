package com.novatronic.das.xml.configclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Atributo {

	@XmlAttribute(name = "nombre")
	private String nombre;
	@XmlAttribute(name = "valor")
	private String valor;

	@XmlValue
	private String atributo;

	public Atributo() {

	}

	public Atributo(String nombre, String valor, String atributo) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.atributo = atributo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Atributo [nombre=" + nombre + ", valor=" + valor
				+ ", atributo=" + atributo + "]";
	}

}
