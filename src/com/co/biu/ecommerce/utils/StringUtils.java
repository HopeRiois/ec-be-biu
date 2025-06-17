package com.co.biu.ecommerce.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * Este método permite verificar si la cadena de texto es nula o vacia
	 * 
	 * @param text String
	 * @return booleano indicando si la cadena es nula o vacia.
	 */
	public static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	/**
	 * Este método valida si un correo es valido mediante el uso de expresiones
	 * regulares
	 * 
	 * @param correo String
	 * @return booleano indicando si el correo es valido.
	 */
	public static boolean isMailValid(String correo) {
		// Se define una expresion regular que compruebe si el correo es valido
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);

		return matcher.matches();
	}
}
