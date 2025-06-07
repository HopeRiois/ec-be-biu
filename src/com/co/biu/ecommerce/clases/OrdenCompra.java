package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompra {

private Long id;
	
	private Long idCliente;
	
	private List<ProductoOrden> productosOrden;
	
	private LocalDateTime fechaOrden;
	
	private String estado;
	
	public void consultarCarrito() {

	}
	
	public void editarCarrito() {
		
	}
	
	public void calcularTotalOrden() {
		
	}
	
}
