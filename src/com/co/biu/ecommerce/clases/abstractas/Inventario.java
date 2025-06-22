package com.co.biu.ecommerce.clases.abstractas;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.co.biu.ecommerce.clases.Administrativo;
import com.co.biu.ecommerce.clases.ProductoInventario;
import com.co.biu.ecommerce.excepciones.InventarioExcepcion;
import com.co.biu.ecommerce.observers.InventarioObserver;
import com.co.biu.ecommerce.utils.CollectionUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Inventario {

	protected Long id;

	protected List<ProductoInventario> productosInventario;

	protected LocalDateTime fechaModificacion;

	protected List<String> reportes;

	public Inventario(Long id, List<ProductoInventario> productosInventario, LocalDateTime fechaModificacion,
			List<String> reportes) {
		super();
		this.id = Instant.now().toEpochMilli();
		this.productosInventario = productosInventario;
		this.fechaModificacion = fechaModificacion;
		this.reportes = reportes;
	}

	public Inventario() {

	}

	/**
	 * Este método permite gestionar el stock de productos registrados en el
	 * inventario.
	 * 
	 * @param producto           Producto
	 * @param eliminaProducto    boolean
	 * @param administrativo     Administrativo
	 * @param cantidadDisponible boolean
	 * @return null en caso de que falle el proceso de administrar stock, si
	 *         funciona correctamente, devuelve un listado de productos inventario.
	 * @throws InventarioExcepcion
	 */
	public abstract List<ProductoInventario> administrarStock(Producto producto, boolean eliminaProducto,
			int cantidadDisponible, Administrativo administrativo, String reporte) throws InventarioExcepcion;

	private List<InventarioObserver> observadores;

	public void agregarObservador(InventarioObserver observador) {
		if (CollectionUtils.isListNullOrEmpty(observadores)) {
			observadores = new ArrayList<>();
		}
		observadores.add(observador);
	}

	public void eliminarObservador(InventarioObserver observador) {
		observadores.remove(observador);
	}

	public void notificarObservadores() {
		for (InventarioObserver o : observadores) {
			o.notificar(this);
		}
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
		notificarObservadores();
	}

}
