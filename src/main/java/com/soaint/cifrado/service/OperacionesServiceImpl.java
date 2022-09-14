/**
 * 
 */
package com.soaint.cifrado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soaint.cifrado.Dao.OperacionesDao;
import com.soaint.cifrado.model.Operaciones;

/**
 * @author Daniel Perez Palma
 *
 */
@Service
public class OperacionesServiceImpl implements OperacionesService{
	
	@Autowired
	private OperacionesDao dao;
	
	@Override
	public Operaciones agregar(Operaciones o) {
		return dao.save(o);
	}

	@Override
	public Operaciones buscarId(int id) {
		Operaciones ope = dao.findById(id);
		return ope;
	}



}
