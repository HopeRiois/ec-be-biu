package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

import com.co.biu.ecommerce.clases.abstractas.Producto;

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
public class ProductoInventario {

	private Producto producto;

	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaModificacion;

	private int cantidadDisponible;

	private String observaciones;

}
