package com.co.biu.ecommerce.clases;

import com.co.biu.ecommerce.clases.abstractas.Inventario;
import com.co.biu.ecommerce.observers.InventarioObserver;
import com.co.biu.ecommerce.observers.PagoObserver;

public class NotificadorCorreo implements PagoObserver, InventarioObserver {

	@Override
	public void actualizar(Pago pago) {
		if (pago.getEstado().equals("pagado")) {
			System.out.println("Pago identificado como: " + pago.getId()
					+ " fue aprobado con éxito, enviando al correo: " + pago.getCliente().getCorreo());
		}
	}

	@Override
	public void notificar(Inventario inventario) {
		System.out.println("Inventario actualizado con éxito.");
	}

}
