package com.co.biu.ecommerce.interfaces.impl;

import java.time.Instant;

import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.OrdenCompra;
import com.co.biu.ecommerce.clases.Pago;
import com.co.biu.ecommerce.enums.TipoExcepcionPago;
import com.co.biu.ecommerce.excepciones.PagoExcepcion;
import com.co.biu.ecommerce.interfaces.ProcesoPago;

public class PagoPaypal implements ProcesoPago {

	@Override
	public Pago iniciarPago(OrdenCompra ordenCompra, Cliente cliente) throws PagoExcepcion {
		try {
			// Valida si el cliente está logeado para hacer la compra
			if (!cliente.isLogeado()) {
				throw new PagoExcepcion("Solamente los clientes que hayan iniciado sesión podrán realizar compras.",
						TipoExcepcionPago.USUARIO_SIN_LOGEAR);
			}

			// Verifica que el valor de la compra sea mayor que 0
			double total = ordenCompra.calcularTotalOrden();
			if (total <= 0) {
				throw new PagoExcepcion("Debe añadir productos al carrito de compras para realizar el pago.",
						TipoExcepcionPago.VALOR_COMPRA_INVALIDO);
			}

			// Impuesto de IVA de 20%
			double impuestos = total * 0.2;
			double subtotal = total - impuestos;

			Pago pago = Pago.builder().id(Instant.now().toEpochMilli()).cliente(cliente).ordenCompra(ordenCompra)
					.subtotal(subtotal).impuestos(impuestos).total(total).metodoPago("paypal").estado("pendiente")
					.build();

			// Redirigir a pasarela de paypal
			System.out.println("Será redirigido a la pasarela de pagos de Paypal.");

			return pago;
		} catch (PagoExcepcion e) {
			System.out.println(e.getMessage() + " Tipo excepcion: " + e.getError());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
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
