package com.co.biu.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.co.biu.ecommerce.clases.*;
import com.co.biu.ecommerce.clases.abstractas.Producto;
import com.co.biu.ecommerce.clases.abstractas.Usuario;
import com.co.biu.ecommerce.config.ConfiguracionSistema;
import com.co.biu.ecommerce.enums.TipoUsuario;
import com.co.biu.ecommerce.fabricas.UsuarioFabrica;

public class EcommerceApplication {

	public static void main(String[] args) {
		// Prueba de constructores de clases
		Categoria cat = new Categoria();
		InventarioFisico invFis = new InventarioFisico();
		InventarioDigital invDig = new InventarioDigital();
		InventarioHistorico invHist = new InventarioHistorico();
		OrdenCompra orden = new OrdenCompra();
		Pedido pedido = new Pedido();
		ProductoDigital prodDigital = new ProductoDigital();
		ProductoFisico prodFisico = new ProductoFisico();
		ProductoOrden productoOrd = new ProductoOrden();
		// Prueba de polimorfismo productos
		List<Producto> prods = new ArrayList<>();
		prods.add(prodDigital);
		prods.add(prodFisico);

		ConfiguracionSistema config = ConfiguracionSistema.obtenerInstancia();
		config.setAmbiente("desarrollo");

		// Prueba de polimorfismo con productos digitales y fisicos
//		orden.editarCarrito(prodDigital, false, 5);
//		orden.editarCarrito(prodFisico, false, 2);

		// Prueba de fabrica
		Usuario admin = UsuarioFabrica.crearUsuario(TipoUsuario.ADMINISTRATIVO);
		if (admin instanceof Administrativo) {
			Administrativo a = (Administrativo) admin;
			a.setCargo("Jefe de IT");
			a.setCodigo("ADM001");
		}

		Usuario cliente = UsuarioFabrica.crearUsuarioDatos(TipoUsuario.CLIENTE, "Ana", "Pérez", "ana@example.com",
				"300000000", LocalDateTime.now().plusYears(-20L), "Calle 1#2-3", "admin", true);
		if (cliente instanceof Cliente) {
			Cliente c = (Cliente) cliente;
			c.setTipoIdentificacion("CC");
			c.setIdentificacion("12345678");
			c.setPersonaNatural(true);
		}
		admin.getId();
		System.out.println("Main");
	}
}
