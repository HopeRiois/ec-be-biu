package com.co.biu.ecommerce.excepciones;

import com.co.biu.ecommerce.enums.TipoExcepcionInventario;

import lombok.Getter;

@Getter
public class InventarioExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private final TipoExcepcionInventario error;

	public InventarioExcepcion(String mensaje, TipoExcepcionInventario error) {
		super(mensaje);
		this.error = error;
	}
}
