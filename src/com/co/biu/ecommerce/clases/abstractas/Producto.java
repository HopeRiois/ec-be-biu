package com.co.biu.ecommerce.clases.abstractas;

import java.time.Instant;

import com.co.biu.ecommerce.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Producto {

	private Long id;

	private Long idCategoria;

	private String nombre;

	private String tipoProducto;

	private float porcentajeDescuento;

	private float descuento;

	private float valorReal;

	private float valorActual;

	private float valoracion;

	private Long cantidadValoraciones;

	private String imagen;

	private String estado;

	public Producto(Long idCategoria, String nombre, String tipoProducto, float porcentajeDescuento, float descuento,
			float valorReal, float valorActual, float valoracion, Long cantidadValoraciones, String imagen,
			String estado) {
		this.id = Instant.now().toEpochMilli();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
		this.porcentajeDescuento = porcentajeDescuento;
		this.descuento = descuento;
		this.valorReal = valorReal;
		this.valorActual = valorActual;
		this.valoracion = valoracion;
		this.cantidadValoraciones = cantidadValoraciones;
		this.imagen = imagen;
		this.estado = estado;
	}

	public Producto() {
	}

	public void editarProducto() {

	}

	/**
	 * Este método imprime los detalles de un producto
	 */
	public void consultarDetalleProducto() {
		System.out.println("Producto: " + this.nombre + ". Tipo Producto: " + this.tipoProducto + ". Valor real: "
				+ this.valorReal + "$. Descuento: " + this.descuento + "$. Valor Actual: " + this.valorActual
				+ "$. Valoración: " + this.valoracion + ". CantidadValoraciones: " + this.cantidadValoraciones
				+ ". Imagen: " + this.imagen);
	}

	/**
	 * Este método valida que los parametros ingresados de un producto sean validos.
	 * @return booleano indicando si el producto es valido o no.
	 */
	public boolean esProductoValido() {
		return this.idCategoria > 0L && StringUtils.isNullOrEmpty(this.nombre)
				&& !StringUtils.isNullOrEmpty(this.tipoProducto) && this.porcentajeDescuento >= 0 && this.descuento >= 0
				&& this.valorActual > 0 && this.valorReal > 0 && this.cantidadValoraciones >= 0
				&& !StringUtils.isNullOrEmpty(this.imagen) && !StringUtils.isNullOrEmpty(this.estado);
	}

}
