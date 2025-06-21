package com.co.biu.ecommerce.clases;

import java.time.LocalDateTime;

import com.co.biu.ecommerce.clases.abstractas.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Usuario {

	private String tipoIdentificacion;

	private String identificacion;

	private boolean personaNatural;

	public Cliente(Long id, String nombres, String apellidos, String correo, String telefono,
			LocalDateTime fechaNacimiento, String direccion, String contraseña, boolean logeado,
			String tipoIdentificacion, String identificacion, boolean personaNatural) {
		super(id, nombres, apellidos, correo, telefono, fechaNacimiento, direccion, contraseña, logeado);
		this.tipoIdentificacion = tipoIdentificacion;
		this.identificacion = identificacion;
		this.personaNatural = personaNatural;
	}

	public Cliente() {

	}

	public void obtenerHistorialCompras() {

	}

	public void obtenerPreferencias() {

	}

}
