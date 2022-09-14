/**
 * 
 */
package com.soaint.cifrado.Dto;

import java.io.Serializable;

/**
 * @author gaite
 *
 */
public class OperacionesResponseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4816822890702102335L;
	private Integer id;
	private Integer resultado;
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
	 * @return the resultado
	 */
	public Integer getResultado() {
		return resultado;
	}
	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	
	
	

}
