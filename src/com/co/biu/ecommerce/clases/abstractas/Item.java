package com.co.biu.ecommerce.clases.abstractas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

	protected Long id;

	protected String nombre;

	protected float precio;

	public Item(Long id, String nombre, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Item() {

	}

}
