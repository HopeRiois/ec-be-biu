package com.co.biu.ecommerce.fabricas;

import java.time.Instant;

import com.co.biu.ecommerce.clases.ProductoDigital;
import com.co.biu.ecommerce.clases.ProductoFisico;
import com.co.biu.ecommerce.clases.abstractas.Producto;
import com.co.biu.ecommerce.enums.TipoProducto;

public class ProductoFabrica {

	public static Producto crearProducto(TipoProducto tipo) {
		switch (tipo) {
		case FISICO:
			return new ProductoFisico();
		case DIGITAL:
			return new ProductoDigital();
		default:
			return null;
		}
	}

	public static Producto crearProductoDatos(TipoProducto tipo, Long idCategoria, String tipoProducto, String nombre,
			float precio, float porcentajeDescuento, float descuento, float valorActual, float valoracion,
			Long cantidadValoraciones, String imagen, String estado) {
		Producto producto = crearProducto(tipo);

		producto.setId(Instant.now().toEpochMilli());
		producto.setIdCategoria(idCategoria);
		producto.setTipoProducto(tipoProducto);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setPorcentajeDescuento(porcentajeDescuento);
		producto.setDescuento(descuento);
		producto.setValorActual(valorActual);
		producto.setValoracion(valoracion);
		producto.setCantidadValoraciones(cantidadValoraciones);
		producto.setImagen(imagen);
		producto.setEstado(estado);
		return producto;
	}
}
