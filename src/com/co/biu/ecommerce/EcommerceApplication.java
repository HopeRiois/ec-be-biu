package com.co.biu.ecommerce;

import com.co.biu.ecommerce.clases.*;

public class EcommerceApplication {

	public static void main(String[] args) {
		
		Categoria cat = new Categoria();
		Inventario inv = new Inventario();
		InventarioHistorico invHist = new InventarioHistorico();
		OrdenCompra orden = new OrdenCompra();
		Pedido pedido = new Pedido();
		Producto prod = new Producto();
		Rol rol = new Rol();
		Usuario usuario = new Usuario();
		System.out.println("Main");
	}
}
