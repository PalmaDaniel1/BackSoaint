/**
 * 
 */
package com.soaint.cifrado.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.cifrado.AES.EncriptarAES;
import com.soaint.cifrado.Dto.OperacionRequestDto;
import com.soaint.cifrado.Dto.OperacionesResponseDto;
import com.soaint.cifrado.model.Operaciones;
import com.soaint.cifrado.operaciones.OperacionesBasicas;
import com.soaint.cifrado.service.OperacionesService;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author Daniel Perez Palma
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/soaint")
public class OperacionController {
	
	@Autowired
	OperacionesService service;
	
	@PostMapping("/operaciones")
	public @ResponseBody OperacionesResponseDto guardar(@RequestBody OperacionRequestDto o) {
		String option = o.getOperacion();
		OperacionesResponseDto opDto = new OperacionesResponseDto();
		
		if (option.equals("suma")) {
			opDto = Suma(o);
		}
		
		if (option.equals("resta")) {
			opDto = Resta(o);
		}
		
		if (option.equals("multiplicacion")) {
			opDto = Multiplicacion(o);
		}
		
		if (option.equals("divicion")) {
			opDto = Divicion(o);
		}
		
		return opDto;
	}
	
	public OperacionesResponseDto Suma(OperacionRequestDto o) {
		int suma;
		String encriptado;
		String desencriptar;
		
		Operaciones op = new Operaciones();
		OperacionesResponseDto opDto = new OperacionesResponseDto();
		OperacionesBasicas operaciones = new OperacionesBasicas();
		
		op.setId(o.getId());
		op.setContenido(o.toString());
		suma = operaciones.suma(o.getNumero_1(), o.getNumero_2());
		
		encriptado = Encriptar(String.valueOf(suma));
		op.setResultado(encriptado);
		service.agregar(op);
		
		op = find(o.getId());
		desencriptar = Desencriptar(op.getResultado());
		
		opDto.setId(op.getId());
		opDto.setResultado(Integer.valueOf(desencriptar));
		
		return opDto;
	}
	
	public OperacionesResponseDto Multiplicacion(OperacionRequestDto o) {
		int multiplicacion;
		String encriptado;
		String desencriptar;
		
		Operaciones op = new Operaciones();
		OperacionesResponseDto opDto = new OperacionesResponseDto();
		OperacionesBasicas operaciones = new OperacionesBasicas();
		
		op.setId(o.getId());
		op.setContenido(o.toString());
		multiplicacion = operaciones.multiplicacion(o.getNumero_1(), o.getNumero_2());
		
		encriptado = Encriptar(String.valueOf(multiplicacion));
		op.setResultado(encriptado);
		service.agregar(op);
		
		op = find(o.getId());
		desencriptar = Desencriptar(op.getResultado());
		
		opDto.setId(op.getId());
		opDto.setResultado(Integer.valueOf(desencriptar));
		
		return opDto;
	}
	
	public OperacionesResponseDto Divicion(OperacionRequestDto o) {
		int divicion;
		String encriptado;
		String desencriptar;
		
		Operaciones op = new Operaciones();
		OperacionesResponseDto opDto = new OperacionesResponseDto();
		OperacionesBasicas operaciones = new OperacionesBasicas();
		
		op.setId(o.getId());
		op.setContenido(o.toString());
		divicion = operaciones.divicion(o.getNumero_1(), o.getNumero_2());
		
		encriptado = Encriptar(String.valueOf(divicion));
		op.setResultado(encriptado);
		service.agregar(op);
		
		op = find(o.getId());
		desencriptar = Desencriptar(op.getResultado());
		
		opDto.setId(op.getId());
		opDto.setResultado(Integer.valueOf(desencriptar));
		
		return opDto;
	}
	public OperacionesResponseDto Resta(OperacionRequestDto o) {
		int resta;
		String encriptado;
		String desencriptar;
		
		Operaciones op = new Operaciones();
		OperacionesResponseDto opDto = new OperacionesResponseDto();
		OperacionesBasicas operaciones = new OperacionesBasicas();
		
		op.setId(o.getId());
		op.setContenido(o.toString());
		resta = operaciones.resta(o.getNumero_1(), o.getNumero_2());
		
		encriptado = Encriptar(String.valueOf(resta));
		op.setResultado(encriptado);
		service.agregar(op);
		
		op = find(o.getId());
		desencriptar = Desencriptar(op.getResultado());
		
		opDto.setId(op.getId());
		opDto.setResultado(Integer.valueOf(desencriptar));
		
		return opDto;
	}
	
	
	public String Encriptar(String dato) {
		String encriptado = null;
		
		try {
			final String claveEncriptacion = "soaint";
			
			EncriptarAES aes = new EncriptarAES();
			encriptado = aes.encriptar(String.valueOf(dato), claveEncriptacion);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(EncriptarAES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return encriptado;
	}
	
	public String Desencriptar(String dato) {
String encriptado = null;
		
		try {
			final String claveEncriptacion = "soaint";
			
			EncriptarAES aes = new EncriptarAES();
			encriptado = aes.desencriptar(String.valueOf(dato), claveEncriptacion);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(EncriptarAES.class.getName()).log(Level.SEVERE, null, ex);
		}
		return encriptado;
	}
	

	public Operaciones find(Integer id) {
		Operaciones oper = service.buscarId(id);
		return oper;
	}
}
