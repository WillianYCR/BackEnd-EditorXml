package com.novatronic.das.util.out;

/**
 * @author wcahuaya
 *
 */
public class Respuesta {

	private String codigo;
	private String descripcion;
	private String exception;
	private String proceso;

	public Respuesta() {

	}
	
	public Respuesta(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public Respuesta(String codigo, String descripcion, String exception) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.exception = exception;
	}
	
	public Respuesta(String codigo, String descripcion, String exception,
			String proceso) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.exception = exception;
		this.proceso = proceso;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	
	@Override
	public String toString() {
		return "ResponseJson [codigo=" + codigo + ", descripcion="
				+ descripcion + ", exception=" + exception + ", proceso="
				+ proceso + "]";
	}

}
