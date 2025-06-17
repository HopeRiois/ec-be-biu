package com.co.biu.ecommerce.clases.abstractas;

import java.time.LocalDateTime;

import com.co.biu.ecommerce.utils.DateUtils;
import com.co.biu.ecommerce.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario {

	protected Long id;

	protected String nombres;

	protected String apellidos;

	protected String correo;

	protected String telefono;

	protected LocalDateTime fechaNacimiento;

	protected String direccion;

	protected String contraseña;

	protected boolean logeado;

	public void editarUsuario() {

	}

	/**
	 * Este método permite iniciar sesión en la plataforma.
	 * 
	 * @param usuario String es el correo de registro
	 * @param clave   String contraseña de registro
	 * @return booleano indicando si es posible iniciar sesión
	 */
	public boolean IniciarSesion(String usuario, String clave) {
		if (this.correo.toLowerCase().equals(usuario.trim().toLowerCase()) && this.contraseña.equals(clave)) {
			System.out.println("Bievenido a la plataforma eCommerce");
			this.logeado = true;
			return true;
		}

		System.out.println("Usuario o clave incorrecto.");
		this.logeado = false;
		return false;

	}

	/**
	 * Permite cerrar la sesión del usuario, para ello el usuario primeramente debe
	 * estar logeado.
	 */
	public void cerrarSesion() {
		if (this.logeado) {
			this.logeado = false;
			System.out.println("Hasta luego, buen día.");
		}

		System.out.println("Debe iniciar sesión para realizar esta acción");

	}

	/**
	 * Valida que el usuario ingresado sea valido con el requsito de que los
	 * usuarios deben tener al menos 15 años
	 * 
	 * @return booleano indicando si el usuario es valido.
	 */
	public boolean esUsuarioValido() {
		return !StringUtils.isNullOrEmpty(this.nombres) && !StringUtils.isNullOrEmpty(this.apellidos)
				&& StringUtils.isMailValid(this.correo) && !StringUtils.isNullOrEmpty(this.telefono)
				&& DateUtils.hasFiftyYears(this.fechaNacimiento.toLocalDate())
				&& !StringUtils.isNullOrEmpty(this.direccion) && !StringUtils.isNullOrEmpty(this.contraseña);
	}

	public void recuperarClaveOtp() {

	}
}
