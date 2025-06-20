package com.co.biu.ecommerce.clases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pago {

	private Long id;

	private Cliente cliente;

	private OrdenCompra ordenCompra;

	private double subtotal;

	private double impuestos;

	private double total;

	private String metodoPago;

	private String estado;

	private String informacionExtra;

}
