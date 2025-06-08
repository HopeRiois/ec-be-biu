package com.co.biu.ecommerce.clases;

import com.co.biu.ecommerce.clases.abstractas.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDigital extends Producto {

	private String urlProducto;

	private String formatoArchivo;

	private String pesoArchivo;

	public ProductoDigital() {
		super();
	}

	public ProductoDigital(Long idCategoria, String nombre, String tipoProducto, float porcentajeDescuento,
			float descuento, float valorReal, float valorActual, float valoracion, Long cantidadValoraciones,
			String imagen, String estado, String urlProducto, String formatoArchivo, String pesoArchivo) {
		super(idCategoria, nombre, tipoProducto, porcentajeDescuento, descuento, valorReal, valorActual, valoracion,
				cantidadValoraciones, imagen, estado);
		this.urlProducto = urlProducto;
		this.formatoArchivo = formatoArchivo;
		this.pesoArchivo = pesoArchivo;
	}

	@Override
	public void consultarDetalleProducto() {
		super.consultarDetalleProducto();
		System.out.print(". Url Producto: " + this.urlProducto + ". Formato Archivo: " + this.formatoArchivo
				+ ". Peso Archivo: " + this.pesoArchivo + ".");
	}

}
