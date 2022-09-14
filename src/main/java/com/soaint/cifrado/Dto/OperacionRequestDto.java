/**
 * 
 */
package com.soaint.cifrado.Dto;

import java.io.Serializable;

/**
 * @author Daniel Perez Palma
 *
 */
public class OperacionRequestDto implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	Integer numero_1;
	Integer numero_2;
	String operacion;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numero_1
	 */
	public Integer getNumero_1() {
		return numero_1;
	}
	/**
	 * @param numero_1 the numero_1 to set
	 */
	public void setNumero_1(Integer numero_1) {
		this.numero_1 = numero_1;
	}
	/**
	 * @return the numero_2
	 */
	public Integer getNumero_2() {
		return numero_2;
	}
	/**
	 * @param numero_2 the numero_2 to set
	 */
	public void setNumero_2(Integer numero_2) {
		this.numero_2 = numero_2;
	}
	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}
	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	@Override
	public String toString() {
		return "{\"id\" : " + id + ", \"numero_1\" : " + numero_1 + ", \"numero_2\" : " + numero_2 + ", \"operacion\" : "
				+ operacion + "}";
	}

	

}
