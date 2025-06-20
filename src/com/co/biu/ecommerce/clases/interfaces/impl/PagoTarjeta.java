package com.co.biu.ecommerce.clases.interfaces.impl;

import java.time.Instant;
import java.util.Scanner;

import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.OrdenCompra;
import com.co.biu.ecommerce.clases.Pago;
import com.co.biu.ecommerce.interfaces.ProcesoPago;

public class PagoTarjeta implements ProcesoPago {

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
				.subtotal(subtotal).impuestos(impuestos).total(total).metodoPago("tarjeta").estado("pendiente").build();

		Scanner scanner = new Scanner(System.in);
		String metodoPago;

		// Ciclo para repetir hasta que el usuario escoja una opción valida.
		while (true) {
			System.out.print("Ingresa el método de pago (credito o debito): ");
			metodoPago = scanner.nextLine().toLowerCase();

			if (metodoPago.equals("credito") || metodoPago.equals("debito")) {
				break;
			} else {
				System.out.println("Opción no válida. Por favor escribe 'credito' o 'debito'.");
			}
		}

		System.out.println("Método de pago seleccionado: " + metodoPago);
		scanner.close();

		// Solicitar información de la tarjeta
		System.out.println("Se solicitará la información de la tarjeta para finalizar la compra.");
		pago.setInformacionExtra("Tipo de tarjeta: " + metodoPago);
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
