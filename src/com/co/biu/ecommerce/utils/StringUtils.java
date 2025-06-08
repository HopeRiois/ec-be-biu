package com.co.biu.ecommerce.utils;

public class StringUtils {

	/**
	 * Este m�todo permite verificar si la cadena de texto es nula o vacia
	 * @param text String
	 * @return booleano indicando si la cadena es nula o vacia.
	 */
	public static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

}
