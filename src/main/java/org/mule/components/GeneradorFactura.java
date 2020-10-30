package org.mule.components;

import org.mule.entities.Factura;
import org.mule.entities.Orden;

public class GeneradorFactura {
	
	public String generar(Orden orden)
	{
		Factura factura = new Factura(orden);
		StringBuffer  bf = new StringBuffer();
		bf.append("FACTURA\r\n");
		bf.append("\tDATOS PERSONALES\r\n");
		bf.append("\t\tNIF "+factura.getNif()+"\r\n");
		bf.append("\t\tNombre: "+factura.getNombre()+"\r\n");
		bf.append("\tLIBRO\r\n");
		bf.append("\t\tISBN: "+factura.getIsbn()+"\r\n");
		bf.append("\t\tCantidad: "+factura.getCantidad()+"\r\n");
		bf.append("\t\t------------------\r\n");
		bf.append("\t\tPrecio: "+factura.getPrecio()+"€\r\n");
		
		System.out.println("--FACTURA GENERADA");
		
		return bf.toString();
	}
}
