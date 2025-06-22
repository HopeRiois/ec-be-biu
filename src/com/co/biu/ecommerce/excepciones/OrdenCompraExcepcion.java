package com.co.biu.ecommerce.excepciones;

import com.co.biu.ecommerce.enums.TipoExcepcionOrden;

import lombok.Getter;

@Getter
public class OrdenCompraExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private final TipoExcepcionOrden error;

	public OrdenCompraExcepcion(String mensaje, TipoExcepcionOrden error) {
		super(mensaje);
		this.error = error;
	}
}
