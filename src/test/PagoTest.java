package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.OrdenCompra;
import com.co.biu.ecommerce.clases.Pago;
import com.co.biu.ecommerce.clases.ProductoDigital;
import com.co.biu.ecommerce.clases.ProductoFisico;
import com.co.biu.ecommerce.clases.ProductoOrden;
import com.co.biu.ecommerce.interfaces.impl.PagoPaypal;

public class PagoTest {

	@Test
	public void testCompraPaypalExitoso() {

		try {
			List<ProductoOrden> productosOrden = new ArrayList<>();

			ProductoDigital producto1 = new ProductoDigital(1L, "Macbook air M1", "Laptop", 0.1f, 100f, 1000f, 900f,
					4.6f, 10L, "urlImagen", "activo", "urlProducto", "html", "12KB");
			productosOrden.add(new ProductoOrden(producto1, 1));
			ProductoFisico producto2 = new ProductoFisico(22L, "Olla de presión Universal", "Utenzilios", 0.2f, 20f,
					100f, 80f, 4.9f, 500L, "urlImagen", "activo", 250f, "20cmx40cmx10cm", "Sección cocina");
			productosOrden.add(new ProductoOrden(producto2, 3));

			Cliente cliente = new Cliente(1L, "Marco", "Soliz", "marco.soliz@correo.co", "3001123453",
					LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", true, "CC", "111555666", true);
			OrdenCompra ordenCompra = new OrdenCompra(1134444421L, cliente.getId(), productosOrden, LocalDateTime.now(),
					"pendiente");

			PagoPaypal paypal = new PagoPaypal();
			Pago pago = paypal.iniciarPago(ordenCompra, cliente);
			if (pago == null) {
				System.out.println("Fallo en el proceso de pago");
			} else {
				System.out.println("Pago realizado de forma exitosa: " + pago.getId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testCompraPaypalClienteNoLogeado() {

		try {
			List<ProductoOrden> productosOrden = new ArrayList<>();

			ProductoDigital producto1 = new ProductoDigital(1L, "Macbook air M1", "Laptop", 0.1f, 100f, 1000f, 900f,
					4.6f, 10L, "urlImagen", "activo", "urlProducto", "html", "12KB");
			productosOrden.add(new ProductoOrden(producto1, 1));
			ProductoFisico producto2 = new ProductoFisico(22L, "Olla de presión Universal", "Utenzilios", 0.2f, 20f,
					100f, 80f, 4.9f, 500L, "urlImagen", "activo", 250f, "20cmx40cmx10cm", "Sección cocina");
			productosOrden.add(new ProductoOrden(producto2, 3));

			Cliente cliente = new Cliente(1L, "Marco", "Soliz", "marco.soliz@correo.co", "3001123453",
					LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", false, "CC", "111555666", true);
			OrdenCompra ordenCompra = new OrdenCompra(1134444421L, cliente.getId(), productosOrden, LocalDateTime.now(),
					"pendiente");

			PagoPaypal paypal = new PagoPaypal();
			Pago pago = paypal.iniciarPago(ordenCompra, cliente);
			if (pago == null) {
				System.out.println("Fallo en el proceso de pago");
			} else {
				System.out.println("Pago realizado de forma exitosa: " + pago.getId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testCompraPaypalSinProductos() {

		try {
			List<ProductoOrden> productosOrden = new ArrayList<>();
			Cliente cliente = new Cliente(1L, "Marco", "Soliz", "marco.soliz@correo.co", "3001123453",
					LocalDateTime.now().plusYears(-15), "Calle 2#12-1", "admin", true, "CC", "111555666", true);
			OrdenCompra ordenCompra = new OrdenCompra(1134444421L, cliente.getId(), productosOrden, LocalDateTime.now(),
					"pendiente");

			PagoPaypal paypal = new PagoPaypal();
			Pago pago = paypal.iniciarPago(ordenCompra, cliente);
			if (pago == null) {
				System.out.println("Fallo en el proceso de pago");
			} else {
				System.out.println("Pago realizado de forma exitosa: " + pago.getId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
