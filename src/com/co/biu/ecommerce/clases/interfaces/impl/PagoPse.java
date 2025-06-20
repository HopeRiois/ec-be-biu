package com.co.biu.ecommerce.clases.interfaces.impl;

import java.time.Instant;
import java.util.Scanner;

import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.OrdenCompra;
import com.co.biu.ecommerce.clases.Pago;
import com.co.biu.ecommerce.interfaces.ProcesoPago;
import com.co.biu.ecommerce.utils.StringUtils;

public class PagoPse implements ProcesoPago {

	@Override
	public Pago iniciarPago(OrdenCompra ordenCompra, Cliente cliente) {
		// Valida si el cliente está logeado para hacer la compra
		if (!cliente.isLogeado()) {
			System.out.println("Solamente los clientes que hayan iniciado sesión podrán realizar compras.");
			return null;
		}

		// Verifica que el valor de la compra sea mayor que 0
		double total = ordenCompra.calcularTotalOrden();
		if (total <= 0) {
			System.out.println("Debe añadir productos al carrito de compras para realizar el pago.");
			return null;
		}

		// Impuesto de IVA de 20%
		double impuestos = total * 0.2;
		double subtotal = total - impuestos;

		Pago pago = Pago.builder().id(Instant.now().toEpochMilli()).cliente(cliente).ordenCompra(ordenCompra)
				.subtotal(subtotal).impuestos(impuestos).total(total).metodoPago("pse").estado("pendiente").build();

		// Seleccionar el banco
		System.out.println("Seleccione el banco para realizar el pago.");
		Scanner scanner = new Scanner(System.in);
		String banco = scanner.nextLine();
		if (StringUtils.isNullOrEmpty(banco)) {
			System.out.println("Banco no valido.");
			scanner.close();
			return null;
		}

		System.out.println("Será redirigido a la pasarela de pagos de pse con el banco: " + banco);
		scanner.close();
		pago.setInformacionExtra("Banco: " + banco);
		return pago;
	}

	@Override
	public boolean verificarPago(Pago pago) {
		return pago.getEstado().equals("pagado");
	}

	@Override
	public Pago confirmarPago(Pago pago) {
		if (pago.getEstado().equals("pendiente")) {
			pago.setEstado("pagado");
		} else {
			System.out.println("No se puede confirmar una venta procesada");
		}
		return pago;
	}

	@Override
	public Pago cancelarPago(Pago pago) {
		if (pago.getEstado().equals("pendiente")) {
			pago.setEstado("pagado");
		} else {
			System.out.println("No se puede cancelar una venta procesada");
		}
		pago.setEstado("cancelado");
		return pago;
	}
}
