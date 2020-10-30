package org.mule.components;

import org.mule.entities.Orden;

public class EnvioOrdinario {
	public Orden envioOrdinario(Orden orden) {
		System.out.println("--Envío por mensajería ordinaria");
		return orden;
	}
}
