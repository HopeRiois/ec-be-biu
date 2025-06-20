package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.co.biu.ecommerce.clases.abstractas.Inventario;
import com.co.biu.ecommerce.clases.abstractas.Producto;
import com.co.biu.ecommerce.utils.CollectionUtils;
import com.co.biu.ecommerce.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventarioFisico extends Inventario {

	private String nombreEstablecimiento;

	private String direccionEstablecimiento;

	private String responsable;

	public InventarioFisico() {

	}

	public InventarioFisico(Long id, List<ProductoInventario> productosInventario, LocalDateTime fechaModificacion,
			List<String> reportes, String nombreEstablecimiento, String direccionEstablecimiento, String responsable) {
		super(id, productosInventario, fechaModificacion, reportes);
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.direccionEstablecimiento = direccionEstablecimiento;
		this.responsable = responsable;
	}

	@Override
	public List<ProductoInventario> administrarStock(Producto producto, boolean eliminaProducto, int cantidadDisponible,
			Administrativo administrativo, String reporte) {
		// Verifica que el producto sea valido
		if (!producto.esProductoValido() || producto.getId() <= 0) {
			return null;
		}

		// Valida si el listado de ordenes de productos esta vacio y se intenta eliminar
		// producto
		if (CollectionUtils.isListNullOrEmpty(this.productosInventario) && eliminaProducto) {
			return null;
		}

		// Comprueba que el reporte no sea null o vacio.
		if (StringUtils.isNullOrEmpty(reporte)) {
			return null;
		}

		// El usuario administrativo debe estar logeado para poder actualizar el stock
		if (!administrativo.isLogeado()) {
			return null;
		}

		// Filtrado mediante lambda para determinar si el producto existe en listado de
		// ordenes de productos
		Optional<ProductoInventario> value = this.productosInventario.stream()
				.filter(op -> op.getProducto().getId() == producto.getId()).findFirst();

		if (value.isEmpty()) {
			// En el caso de que el producto no exista, no puede ser eliminado
			if (eliminaProducto) {
				return null;
			}

			// No se puede agregar productos al carrito con cantidad menor a 0
			if (cantidadDisponible < 0) {
				return null;
			}
			// Utiliza el builder para crear el objeto con los atributos deseados sin usar
			// el constructor
			// Y luego lo agrega al listado de productos inventario
			this.productosInventario.add(
					ProductoInventario.builder().producto(producto).cantidadDisponible(cantidadDisponible).build());

		} else {
			// En caso de que se desee eliminar el producto y exista, se remueve del listado
			if (eliminaProducto) {
				this.productosInventario.remove(value.get());
			}

			// Si el producto existe pero la cantidad disponible es menor que 0 entonces se
			// elimina del
			// listado
			if (cantidadDisponible < 0) {
				this.productosInventario.remove(value.get());
			}

			// En el caso de que el producto exista y la cantidad disponible sea mayor o
			// igual a 0,
			// entonces se actualiza la cantidad disponible
			this.productosInventario.stream().filter(op -> op.getProducto().getId().equals(producto.getId()))
					.forEach(op -> op.setCantidadDisponible(cantidadDisponible));

		}
		// Si el proceso es éxitoso, agrega el reporte de control de stock
		this.reportes.add(reporte);
		this.fechaModificacion = LocalDateTime.now();
		return this.productosInventario;

	}

}
