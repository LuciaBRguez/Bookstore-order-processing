package org.mule.components;

import org.mule.entities.Orden;

public class EnvioUrgente {
	public Orden envioUrgente(Orden orden) {
		System.out.println("--Envío URGENTE");
		return orden;
	}
}
