package com.co.biu.ecommerce.clases;

import java.util.ArrayList;
import java.util.List;

import com.co.biu.ecommerce.observers.PagoObserver;
import com.co.biu.ecommerce.utils.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pago {

	private Long id;

	private Cliente cliente;

	private OrdenCompra ordenCompra;

	private double subtotal;

	private double impuestos;

	private double total;

	private String metodoPago;

	private String estado;

	private String informacionExtra;

	private List<PagoObserver> observadores;

	public void agregarObservador(PagoObserver observador) {
		if (CollectionUtils.isListNullOrEmpty(observadores)) {
			observadores = new ArrayList<>();
		}
		observadores.add(observador);
	}

	public void eliminarObservador(PagoObserver observador) {
		observadores.remove(observador);
	}

	public void notificarObservadores() {
		for (PagoObserver o : observadores) {
			o.actualizar(this);
		}
	}

	// Se crea un set estado particular que se encargue de notificar los cambios
	public void setEstado(String estado) {
		this.estado = estado;
		notificarObservadores();
	}

}
