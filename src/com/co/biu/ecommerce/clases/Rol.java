package com.co.biu.ecommerce.clases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

	private Long id;
	
	private String nombre;
	
	private String descripcion;

	public void crearRol() {
		
	}
	
	public void editarRol() {
		
	}
}
