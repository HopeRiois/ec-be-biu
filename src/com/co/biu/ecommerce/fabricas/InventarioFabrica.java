package com.co.biu.ecommerce.fabricas;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import com.co.biu.ecommerce.clases.InventarioDigital;
import com.co.biu.ecommerce.clases.InventarioFisico;
import com.co.biu.ecommerce.clases.ProductoInventario;
import com.co.biu.ecommerce.clases.abstractas.Inventario;
import com.co.biu.ecommerce.enums.TipoInventario;

public class InventarioFabrica {

	public static Inventario crearInventario(TipoInventario tipo) {
		switch (tipo) {
		case FISICO:
			return new InventarioFisico();
		case DIGITAL:
			return new InventarioDigital();
		default:
			return null;
		}
	}

	public static Inventario crearInventarioDatos(TipoInventario tipo, List<ProductoInventario> productosInventario,
			LocalDateTime fechaModificacion, List<String> reportes) {
		Inventario inventario = crearInventario(tipo);

		inventario.setId(Instant.now().toEpochMilli());
		inventario.setProductosInventario(productosInventario);
		inventario.setFechaModificacion(fechaModificacion);
		inventario.setReportes(reportes);
		return inventario;
	}

}
