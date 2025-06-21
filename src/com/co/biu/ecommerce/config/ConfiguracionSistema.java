package com.co.biu.ecommerce.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfiguracionSistema {

	private static volatile ConfiguracionSistema instancia;

	private String nombreAplicacion;

	private String version;

	private String ambiente;

	private String cadenaConexion;

	/**
	 * Constructor privado que evite crear instancias externas
	 */
	private ConfiguracionSistema() {
		this.nombreAplicacion = "Plataforma e-Commerce";
		this.version = "1.0.6";
		this.ambiente = "localhost";
		this.cadenaConexion = "jdbc:mysql://localhost:3306/ecommerce";
	}

	/**
	 * Metodo de acceso público y sincronizado para obtener la instancia única
	 * 
	 * @return instancia única de configuracion sistema
	 */
	public static ConfiguracionSistema obtenerInstancia() {
		if (instancia == null) {
			synchronized (ConfiguracionSistema.class) {
				if (instancia == null) {
					instancia = new ConfiguracionSistema();
				}
			}
		}
		return instancia;
	}
}
