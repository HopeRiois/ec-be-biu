package com.co.biu.ecommerce;

import com.co.biu.ecommerce.clases.*;
import com.co.biu.ecommerce.clases.abstractas.Producto;
import com.co.biu.ecommerce.clases.abstractas.Usuario;

public class EcommerceApplication {

	public static void main(String[] args) {

		Categoria cat = new Categoria();
		Inventario inv = new Inventario();
		InventarioHistorico invHist = new InventarioHistorico();
		OrdenCompra orden = new OrdenCompra();
		Pedido pedido = new Pedido();
		Producto prodDigital = new ProductoDigital();
		Producto prodFisico = new ProductoFisico();
		ProductoOrden productoOrd = new ProductoOrden();
		Cliente usuario = new Cliente();
		usuario.getId();
		System.out.println("Main");
	}
}
