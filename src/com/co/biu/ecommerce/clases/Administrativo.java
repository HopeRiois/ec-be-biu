package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

import com.co.biu.ecommerce.clases.abstractas.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrativo extends Usuario {

	private String cargo;

	private String codigo;

	public Administrativo(Long id, String nombres, String apellidos, String correo, String telefono,
			LocalDateTime fechaNacimiento, String direccion, String contraseña, boolean logeado, String cargo,
			String codigo) {
		super(id, nombres, apellidos, correo, telefono, fechaNacimiento, direccion, contraseña, logeado);
		this.cargo = cargo;
		this.codigo = codigo;
	}

	public Administrativo() {

	}

	public void gestionarInventario() {

	}

	public void establecerPromociones() {

	}

}
