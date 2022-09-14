/**
 * 
 */
package com.soaint.cifrado.service;

import com.soaint.cifrado.model.Operaciones;

/**
 * @author Daniel Perez Palma
 *
 */
public interface OperacionesService {
	Operaciones agregar(Operaciones o);
	Operaciones buscarId(int id);

}
