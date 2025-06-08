package com.co.biu.ecommerce.clases;

import com.co.biu.ecommerce.clases.abstractas.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoFisico extends Producto {

	private float peso;

	private String dimensiones;

	private String ubicacionTienda;

	public ProductoFisico(Long idCategoria, String nombre, String tipoProducto, float porcentajeDescuento,
			float descuento, float valorReal, float valorActual, float valoracion, Long cantidadValoraciones,
			String imagen, String estado, float peso, String dimensiones, String ubicacionTienda) {
		super(idCategoria, nombre, tipoProducto, porcentajeDescuento, descuento, valorReal, valorActual, valoracion,
				cantidadValoraciones, imagen, estado);
		this.peso = peso;
		this.dimensiones = dimensiones;
		this.ubicacionTienda = ubicacionTienda;
	}

	public ProductoFisico() {
		super();
	}

	@Override
	public void consultarDetalleProducto() {
		super.consultarDetalleProducto();
		System.out.print(". Peso: " + this.peso + ". Dimensiones: " + this.dimensiones + ". Ubicacion Tienda: "
				+ this.ubicacionTienda + ".");
	}

}
