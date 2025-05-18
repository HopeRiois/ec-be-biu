package com.co.biu.ecommerce.clases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	private Long id;
	
	private Long idCategoria;
	
	private String nombre;
	
	private String tipoProducto;
	
	private float porcentajeDescuento;
	
	private float descuento;
	
	private float valorActual;
	
	private float valoracion;
	
	private Long cantidadValoraciones;
	
	private String imagen;
	
	private String estado;
	
	public void crearProducto() {
		
	}
	
	public void editarProducto() {
		
	}
	
	public void consultarProducto() {
		
	}
}
