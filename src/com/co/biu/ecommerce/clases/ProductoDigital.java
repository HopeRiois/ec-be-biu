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
public class ProductoDigital extends Producto {

	private String urlProducto;

	private String formatoArchivo;

	private String pesoAchivo;
}
