package com.co.biu.ecommerce.clases.abstractas;

import java.time.Instant;

import com.co.biu.ecommerce.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Producto extends Item {

	protected Long idCategoria;

	protected String tipoProducto;

	protected float porcentajeDescuento;

	protected float descuento;

	protected float valorActual;

	protected float valoracion;

	protected Long cantidadValoraciones;

	protected String imagen;

	protected String estado;

	public Producto(Long idCategoria, String tipoProducto, String nombre, float precio, float porcentajeDescuento,
			float descuento, float valorActual, float valoracion, Long cantidadValoraciones, String imagen,
			String estado) {
		// Se llama al constructor de item asignandole el primer parametro id con la
		// hora desde 1970
		super(Instant.now().toEpochMilli(), nombre, precio);
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
		this.porcentajeDescuento = porcentajeDescuento;
		this.descuento = descuento;
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
				+ this.precio + "$. Descuento: " + this.descuento + "$. Valor Actual: " + this.valorActual
				+ "$. Valoración: " + this.valoracion + ". CantidadValoraciones: " + this.cantidadValoraciones
				+ ". Imagen: " + this.imagen);
	}

	/**
	 * Este método valida que los parametros ingresados de un producto sean validos.
	 * 
	 * @return booleano indicando si el producto es valido o no.
	 */
	public boolean esProductoValido() {
		return this.idCategoria > 0L && !StringUtils.isNullOrEmpty(this.nombre)
				&& !StringUtils.isNullOrEmpty(this.tipoProducto) && this.porcentajeDescuento >= 0 && this.descuento >= 0
				&& this.valorActual > 0 && this.precio > 0 && this.cantidadValoraciones >= 0
				&& !StringUtils.isNullOrEmpty(this.imagen) && !StringUtils.isNullOrEmpty(this.estado);
	}

}
