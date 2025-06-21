package com.co.biu.ecommerce.observers;

import com.co.biu.ecommerce.clases.abstractas.Inventario;

public interface InventarioObserver {

	void notificar(Inventario inventario);

}
