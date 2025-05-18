package com.co.biu.ecommerce.clases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	private Long id;
	
	private String nombre;
	
	private String descripcion;

	public void crearCategoria() {
		
	}
	
	public void editarCategoria() {
		
	}
}
