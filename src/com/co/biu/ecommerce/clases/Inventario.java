package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

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
public class Inventario {

	private Long id;

	private Long idProducto;

	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaModificacion;

	private Long cantidadDisponible;

	private String observaciones;
	
	public void modificarInventario() {
		
	}
	
	public void consultarInventario() {
		
	}
}
