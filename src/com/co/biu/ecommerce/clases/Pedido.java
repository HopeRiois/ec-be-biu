package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private Long id;
	
	private Long idUsuario;
	
	private Long idOrden;
	
	private LocalDateTime fechaCompra;
	
	private String estado;
	
	public void procesarPedidos() {
		
	}
	
	public void redirigirAPasarelaDePagos() {
		
	}

}
