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
public class Usuario {

	private Long id;
	
	private Long idRol;
	
	private String nombres;
	
	private String apellidos;
	
	private String correo;
	
	private String telefono;
	
	private LocalDateTime fechaNacimiento;
	
	private String direccion;
	
	private String contraseña;
	
	public void crearUsuario() {
		
	}
	
	public void editarUsuario() {
		
	}
	
	public void IniciarSesion() {
		
	}
	
	public void cerrarSesion() {
		
	}
	
	public void recuperarClaveOtp() {
		
	}
}
