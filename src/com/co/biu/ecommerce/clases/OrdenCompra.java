package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompra {

private Long id;
	
	private Long idUsuario;
	
	private List<Producto> productos;
	
	private LocalDateTime fechaOrden;
	
	private String estado;
	
	public void consultarCarrito() {
		
	}
	
	public void editarCarrito() {
		
	}
	
}
