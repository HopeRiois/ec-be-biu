package com.co.biu.ecommerce.interfaces;

import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.OrdenCompra;
import com.co.biu.ecommerce.clases.Pago;
import com.co.biu.ecommerce.excepciones.PagoExcepcion;

public interface ProcesoPago {

	/**
	 * Este método se encarga de generar la orden de compra.
	 * 
	 * @param ordenCompra OrdenCompra
	 * @param cliente     Cliente
	 * @return objeto de tipo Pago
	 */
	public Pago iniciarPago(OrdenCompra ordenCompra, Cliente cliente) throws PagoExcepcion;

	/**
	 * Este método permite verificar el estado de la transacción.
	 * 
	 * @param pago Pago
	 * @return booleano inidicando si el pago fue completado.
	 */
	public boolean verificarPago(Pago pago);

	/**
	 * Este método se encarga de confirmar el pago de la compra.
	 * 
	 * @param pago Pago
	 * @return objeto de tipo Pago que fue aprobado
	 */
	public Pago confirmarPago(Pago pago);

	/**
	 * Este método permite cancelar una compra.
	 * 
	 * @param pago Pago
	 * @return Objeto de tipo Pago que fue cancelado
	 */
	public Pago cancelarPago(Pago pago);
}
