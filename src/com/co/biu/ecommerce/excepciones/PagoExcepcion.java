package com.co.biu.ecommerce.excepciones;

import com.co.biu.ecommerce.enums.TipoExcepcionPago;

import lombok.Getter;

@Getter
public class PagoExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	private final TipoExcepcionPago error;

	public PagoExcepcion(String mensaje, TipoExcepcionPago error) {
		super(mensaje);
		this.error = error;
	}
}
