package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.co.biu.ecommerce.clases.Administrativo;
import com.co.biu.ecommerce.clases.InventarioFisico;
import com.co.biu.ecommerce.clases.ProductoFisico;
import com.co.biu.ecommerce.clases.ProductoInventario;

public class InventarioTest {

	@Test
	public void testAdministrarInventarioFisicoExitoso() {

		try {

			List<String> reportes = new ArrayList<>();

			List<ProductoInventario> productosInventario = new ArrayList<>();

			ProductoFisico producto1 = new ProductoFisico(1L, "MacbookAir M1", "Laptops", 0.1f, 100f, 1000f, 900f, 4.6f,
					50L, "urlImagen", "activo", 800f, "13 pulgadas", "Sección tecnologia");
			productosInventario.add(new ProductoInventario(producto1, LocalDateTime.now(), LocalDateTime.now(), 5,
					"Se agregan 5 equipos totalmente sellados y embalados."));
			ProductoFisico producto2 = new ProductoFisico(22L, "Olla de presión Universal", "Utenzilios", 0.2f, 20f,
					100f, 80f, 4.9f, 500L, "urlImagen", "activo", 250f, "20cmx40cmx10cm", "Sección cocina");
			productosInventario.add(new ProductoInventario(producto2, LocalDateTime.now(), LocalDateTime.now(), 50,
					"Se lleva a la bodega 48 unidades y se toman 2 para exhibición."));

			Administrativo administrativo = new Administrativo(1L, "Marco", "Soliz", "marco.soliz@correo.co",
					"3001123453", LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", true,
					"Encargado de bodega", "AKS12344");

			InventarioFisico inventarioFisico = new InventarioFisico(4L, productosInventario, LocalDateTime.now(),
					reportes, "HomeCenter", "Calle 12#2-14", "Nicolas Mora");

			List<ProductoInventario> aux = inventarioFisico.administrarStock(producto1, false, 4, administrativo,
					"Se realiza la distribución del producto.");

			if (aux == null) {
				System.out.println("Fallo en el proceso de actualización de inventario.");
			} else {
				productosInventario = aux;
				System.out.println("Se actualizó exitosamente el inventario.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAdministrarInventarioFisicoReporteVacio() {

		try {

			List<String> reportes = new ArrayList<>();

			List<ProductoInventario> productosInventario = new ArrayList<>();

			ProductoFisico producto1 = new ProductoFisico(1L, "MacbookAir M1", "Laptops", 0.1f, 100f, 1000f, 900f, 4.6f,
					50L, "urlImagen", "activo", 800f, "13 pulgadas", "Sección tecnologia");
			productosInventario.add(new ProductoInventario(producto1, LocalDateTime.now(), LocalDateTime.now(), 5,
					"Se agregan 5 equipos totalmente sellados y embalados."));
			ProductoFisico producto2 = new ProductoFisico(22L, "Olla de presión Universal", "Utenzilios", 0.2f, 20f,
					100f, 80f, 4.9f, 500L, "urlImagen", "activo", 250f, "20cmx40cmx10cm", "Sección cocina");
			productosInventario.add(new ProductoInventario(producto2, LocalDateTime.now(), LocalDateTime.now(), 50,
					"Se lleva a la bodega 48 unidades y se toman 2 para exhibición."));

			Administrativo administrativo = new Administrativo(1L, "Marco", "Soliz", "marco.soliz@correo.co",
					"3001123453", LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", true,
					"Encargado de bodega", "AKS12344");

			InventarioFisico inventarioFisico = new InventarioFisico(4L, productosInventario, LocalDateTime.now(),
					reportes, "HomeCenter", "Calle 12#2-14", "Nicolas Mora");

			List<ProductoInventario> aux = inventarioFisico.administrarStock(producto1, false, 4, administrativo, "");
			if (aux == null) {
				System.out.println("Fallo en el proceso de actualización de inventario.");
			} else {
				productosInventario = aux;
				System.out.println("Se actualizó exitosamente el inventario.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testAdministrarInventarioEliminarProductoInexistente() {

		try {

			List<String> reportes = new ArrayList<>();

			List<ProductoInventario> productosInventario = new ArrayList<>();

			ProductoFisico producto1 = new ProductoFisico(1L, "MacbookAir M1", "Laptops", 0.1f, 100f, 1000f, 900f, 4.6f,
					50L, "urlImagen", "activo", 800f, "13 pulgadas", "Sección tecnologia");
			productosInventario.add(new ProductoInventario(producto1, LocalDateTime.now(), LocalDateTime.now(), 5,
					"Se agregan 5 equipos totalmente sellados y embalados."));
			ProductoFisico producto2 = new ProductoFisico(22L, "Olla de presión Universal", "Utenzilios", 0.2f, 20f,
					100f, 80f, 4.9f, 500L, "urlImagen", "activo", 250f, "20cmx40cmx10cm", "Sección cocina");

			Administrativo administrativo = new Administrativo(1L, "Marco", "Soliz", "marco.soliz@correo.co",
					"3001123453", LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", true,
					"Encargado de bodega", "AKS12344");

			InventarioFisico inventarioFisico = new InventarioFisico(4L, productosInventario, LocalDateTime.now(),
					reportes, "HomeCenter", "Calle 12#2-14", "Nicolas Mora");

			List<ProductoInventario> aux = inventarioFisico.administrarStock(producto2, true, 0, administrativo, "Se realiza la distribución del producto.");
			if (aux == null) {
				System.out.println("Fallo en el proceso de actualización de inventario.");
			} else {
				productosInventario = aux;
				System.out.println("Se actualizó exitosamente el inventario.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
