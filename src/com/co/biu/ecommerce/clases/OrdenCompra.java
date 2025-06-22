package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.co.biu.ecommerce.clases.abstractas.Producto;
import com.co.biu.ecommerce.enums.TipoExcepcionOrden;
import com.co.biu.ecommerce.excepciones.OrdenCompraExcepcion;
import com.co.biu.ecommerce.utils.CollectionUtils;

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
public class OrdenCompra {

	private Long id;

	private Long idCliente;

	private List<ProductoOrden> productosOrden;

	private LocalDateTime fechaOrden;

	private String estado;

	/**
	 * Consulta los productos, imprime el nombre del producto, el valor, la cantidad
	 * y el total del producto.
	 */
	public void consultarCarrito() {
		System.out.println("Producto:    Valor:   Cantidad:  Total: ");
		for (ProductoOrden po : this.productosOrden) {
			String info = po.getProducto().getNombre() + ". " + po.getProducto().getValorActual() + ". "
					+ po.getCantidad() + ". " + po.getProducto().getValorActual() * po.getCantidad();
			System.out.println(info);
		}
	}

	/**
	 * Sobrecarga del método que imprime únicamente los productos que coincidan el
	 * Id.
	 * 
	 * @param productoId Long
	 */
	public void consultarCarrito(Long productoId) {
		// Se busca los productos cuyo id coincida
		List<ProductoOrden> productosOrden = this.productosOrden.stream()
				.filter(op -> op.getProducto().getId() == productoId).toList();

		if (CollectionUtils.isListNullOrEmpty(productosOrden)) {
			System.out.println("No se encontró el producto en el carrito de compras.");
		} else {
			System.out.println("Producto:    Valor:   Cantidad:  Total: ");
			for (ProductoOrden po : productosOrden) {
				String info = po.getProducto().getNombre() + ". " + po.getProducto().getValorActual() + ". "
						+ po.getCantidad() + ". " + po.getProducto().getValorActual() * po.getCantidad();
				System.out.println(info);
			}
		}
	}

	/**
	 * Sobrecarga de método que imprime los productos que coincidan con el tipo de
	 * producto.
	 * 
	 * @param nombreProducto String
	 */
	public void consultarCarrito(String tipoProducto) {
		// Se busca los productos cuyo nombre coincida
		List<ProductoOrden> productosOrden = this.productosOrden.stream()
				.filter(op -> op.getProducto().getTipoProducto() == tipoProducto).toList();

		if (CollectionUtils.isListNullOrEmpty(productosOrden)) {
			System.out.println("No se encontraron productos del tipo: " + tipoProducto + " en el carrito de compras.");
		} else {
			System.out.println("Producto:    Valor:   Cantidad:  Total: ");
			for (ProductoOrden po : productosOrden) {
				String info = po.getProducto().getNombre() + ". " + po.getProducto().getValorActual() + ". "
						+ po.getCantidad() + ". " + po.getProducto().getValorActual() * po.getCantidad();
				System.out.println(info);
			}
		}
	}

	/**
	 * Sobrecarga de método que imprime los productos cuya categoria sea la
	 * indicada.
	 * 
	 * @param categoria Categoria
	 */
	public void consultarCarrito(Categoria categoria) {
		// Se busca los productos cuyo id coincida
		List<ProductoOrden> productosOrden = this.productosOrden.stream()
				.filter(op -> op.getProducto().getIdCategoria() == categoria.getId()).toList();

		if (CollectionUtils.isListNullOrEmpty(productosOrden)) {
			System.out.println("No se encontraron productos de la categoria: " + categoria.getNombre()
					+ " en el carrito de compras.");
		} else {
			System.out.println("Producto:    Valor:   Cantidad:  Total: ");
			for (ProductoOrden po : productosOrden) {
				String info = po.getProducto().getNombre() + ". " + po.getProducto().getValorActual() + ". "
						+ po.getCantidad() + ". " + po.getProducto().getValorActual() * po.getCantidad();
				System.out.println(info);
			}
		}
	}

	/**
	 * Este metodo actualiza el carrito de compras, funciona con polimorfismo tanto
	 * para productos fisicos como digitales.
	 * 
	 * @param producto        Producto
	 * @param eliminaProducto boolean
	 * @param cantidad        boolean
	 * @return null en caso de que falle el proceso de editar el carrito de compras,
	 *         sino devuelve el listado del carrito de compras.
	 * @throws OrdenCompraException
	 */
	public List<ProductoOrden> editarCarrito(Producto producto, boolean eliminaProducto, int cantidad)
			throws OrdenCompraExcepcion {
		try {
			// Verifica que el producto sea valido
			if (!producto.esProductoValido() || producto.getId() <= 0) {
				throw new OrdenCompraExcepcion("El producto que desea agregar al carrito es invalido.",
						TipoExcepcionOrden.PRODUCTO_INVALIDO);
			}

			// Valida si el listado de ordenes de productos esta vacio y se intenta eliminar
			// producto
			if (CollectionUtils.isListNullOrEmpty(this.productosOrden) && eliminaProducto) {
				throw new OrdenCompraExcepcion("No se puede eliminar productos cuando el carrito se encuentra vacio.",
						TipoExcepcionOrden.ELIMINAR_PRODUCTO_CARRITO_VACIO);
			}

			// Filtrado mediante lambda para determinar si el producto existe en listado de
			// ordenes de productos
			Optional<ProductoOrden> value = this.productosOrden.stream()
					.filter(op -> op.getProducto().getId() == producto.getId()).findFirst();

			if (value.isEmpty()) {
				// En el caso de que el producto no exista, no puede ser eliminado
				if (eliminaProducto) {
					throw new OrdenCompraExcepcion("No se puede eliminar un producto que no exista en el carrito.",
							TipoExcepcionOrden.ELIMINAR_PRODUCTO_INEXISTENTE);
				}

				// No se puede agregar productos al carrito con cantidad menor a 1
				if (cantidad < 1) {
					throw new OrdenCompraExcepcion(
							"No se puede agregar productos al carrito con una cantidad menor a 1.",
							TipoExcepcionOrden.AGREGAR_PRODUCTO_CANTIDAD_INVALIDA);
				}
				// Utiliza el builder para crear el objeto con los atributos deseados sin usar
				// el constructor
				// Y luego lo agrega al listado de ordenes de producto
				this.productosOrden.add(ProductoOrden.builder().producto(producto).cantidad(cantidad).build());

			} else {
				// En caso de que se desee eliminar el producto y exista, se remueve del listado
				if (eliminaProducto) {
					this.productosOrden.remove(value.get());
				}

				// Si el producto existe pero la cantidad es menor que 1 entonces se elimina del
				// listado
				if (cantidad < 1) {
					this.productosOrden.remove(value.get());
				}

				// En el caso de que el producto exista y la cantidad sea mayor a 0, entonces se
				// actualiza la cantidad
				this.productosOrden.stream().filter(op -> op.getProducto().getId().equals(producto.getId()))
						.forEach(op -> op.setCantidad(cantidad));

			}

			return this.productosOrden;
		} catch (OrdenCompraExcepcion e) {
			System.out.println(e.getMessage() + " Tipo excepcion: " + e.getError());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Calcula el valor total del carrito de compras
	 * 
	 * @return un double con el valor total del carrito de compras.
	 */
	public double calcularTotalOrden() {

		if (CollectionUtils.isListNullOrEmpty(this.productosOrden)) {
			return 0;
		}
		// Utiliza un lambda para realizar la operación entre el valor actual del
		// producto y la cantidad de productos Seleccionados.
		return this.productosOrden.stream().mapToDouble(op -> op.getProducto().getValorActual() * op.getCantidad())
				.sum();
	}

}
