package com.co.biu.ecommerce.utils;

import java.util.Collection;

public class CollectionUtils {

	/**
	 * Este m�todo valida si la coleccion es null o est� vacia
	 * @param collection Collection
	 * @return boleano que indica si la lista es null o vacia.
	 */
	public static boolean isListNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
	}
	
}
