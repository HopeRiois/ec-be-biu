package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private Long id;
	
	private Long idCliente;
	
	private Long idOrden;
	
	private LocalDateTime fechaCompra;
	
	private String estado;
	
	public void procesarPedidos() {
		
	}
	
	public void redirigirAPasarelaDePagos() {
		
	}

}
