/**
 * 
 */
package com.soaint.cifrado.operaciones;

/**
 * @author Daniel Perez Palma
 *
 */
public class OperacionesBasicas {
	//private int a;
	//private int b;
	
	public int suma(int a, int b) {
		return (a + b);
	}
	
	public int resta(int a, int b) {
		return (a - b);
	}
	
	public int multiplicacion(int a, int b) {
		return(a * b);
	}
	
	public int divicion(int a, int b) {
		int res = 0;
		try {
			res = (a / b);
		} catch (Exception e) {
			System.err.print("Divicion entre cero no posible");
		}
		return res;
	}

}
