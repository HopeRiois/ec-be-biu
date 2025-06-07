package com.co.biu.ecommerce.clases;

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
public class Categoria {

	private Long id;
	
	private String nombre;
	
	private String descripcion;

	public void crearCategoria() {
		
	}
	
	public void editarCategoria() {
		
	}
}
