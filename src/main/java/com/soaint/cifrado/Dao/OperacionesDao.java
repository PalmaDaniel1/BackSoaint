/**
 * 
 */
package com.soaint.cifrado.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.soaint.cifrado.model.Operaciones;

/**
 * @author Daniel Pérez Palma
 *
 */
public interface OperacionesDao extends CrudRepository<Operaciones, Integer>{
	Operaciones findById(int id);
	@SuppressWarnings("unchecked")
	Operaciones  save(Operaciones frut);
}
