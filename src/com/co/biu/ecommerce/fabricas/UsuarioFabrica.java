package com.co.biu.ecommerce.fabricas;

import java.time.Instant;
import java.time.LocalDateTime;

import com.co.biu.ecommerce.clases.Administrativo;
import com.co.biu.ecommerce.clases.Cliente;
import com.co.biu.ecommerce.clases.abstractas.Usuario;
import com.co.biu.ecommerce.enums.TipoUsuario;

public class UsuarioFabrica {

	public static Usuario crearUsuario(TipoUsuario tipo) {
		switch (tipo) {
		case CLIENTE:
			return new Cliente();
		case ADMINISTRATIVO:
			return new Administrativo();
		default:
			return null;
		}
	}

	public static Usuario crearUsuarioDatos(TipoUsuario tipo, String nombres, String apellidos, String correo,
			String telefono, LocalDateTime fechaNacimiento, String direccion, String contraseña, boolean logeado) {
		Usuario usuario = crearUsuario(tipo);

		usuario.setId(Instant.now().toEpochMilli());
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setCorreo(correo);
		usuario.setTelefono(telefono);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setDireccion(direccion);
		usuario.setContraseña(contraseña);
		usuario.setLogeado(logeado);
		return usuario;
	}
}
