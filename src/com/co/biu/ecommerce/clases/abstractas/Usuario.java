package com.co.biu.ecommerce.clases.abstractas;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario {

	private Long id;

	private String nombres;

	private String apellidos;

	private String correo;

	private String telefono;

	private LocalDateTime fechaNacimiento;

	private String direccion;

	private String contraseña;

	public void editarUsuario() {

	}

	public void IniciarSesion() {

	}

	public void cerrarSesion() {

	}

	public void recuperarClaveOtp() {

	}
}
