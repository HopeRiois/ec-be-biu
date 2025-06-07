package com.co.biu.ecommerce.clases;

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
public class ProductoFisico extends Producto {

	private float peso;

	private String dimensiones;

	private String ubicacionTienda;
}
