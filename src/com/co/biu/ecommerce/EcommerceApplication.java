package com.co.biu.ecommerce;

import java.util.ArrayList;
import java.util.List;

import com.co.biu.ecommerce.clases.*;
import com.co.biu.ecommerce.clases.abstractas.Producto;

public class EcommerceApplication {

	public static void main(String[] args) {
		//Prueba de constructores de clases
		Categoria cat = new Categoria();
		Inventario inv = new Inventario();
		InventarioHistorico invHist = new InventarioHistorico();
		OrdenCompra orden = new OrdenCompra();
		Pedido pedido = new Pedido();
		ProductoDigital prodDigital = new ProductoDigital();
		ProductoFisico prodFisico = new ProductoFisico();
		ProductoOrden productoOrd = new ProductoOrden();
		
		//Prueba de polimorfismo productos
		List<Producto> prods = new ArrayList<>();
		prods.add(prodDigital);
		prods.add(prodFisico);
		
		//Prueba de polimorfismo con productos digitales y fisicos
//		orden.editarCarrito(prodDigital, false, 5);
//		orden.editarCarrito(prodFisico, false, 2);

		Cliente usuario = new Cliente();
		usuario.getId();
		System.out.println("Main");
	}
}
