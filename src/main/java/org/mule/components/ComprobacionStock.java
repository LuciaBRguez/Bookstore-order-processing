package org.mule.components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Orden;

public class ComprobacionStock {
	
	public Orden comprobacionStock(Orden orden) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		Properties propPrecio = new Properties();
		
		prop.load(new FileReader("src/stock.properties"));
		propPrecio.load(new FileReader("src/precio.properties"));

		String isbn = orden.getIsbn();
		int stock;
		int precio;
		int precioTotal;
		int solicitado = orden.getCantidad();
		
		try {
			stock = Integer.parseInt(prop.getProperty(isbn));
			precio = Integer.parseInt(propPrecio.getProperty(isbn));
			precioTotal = precio * solicitado;
		} catch (Exception e) {
			stock = 0;
			precio = 0;
			precioTotal = 0;
		}
		
		orden.setPrecio(precioTotal);

		System.out.println("--NUEVA SOLICITUD:");
		System.out.println("----Cliente:");
		System.out.println("------NIF: "+orden.getNif()+", nombre: "+orden.getNombre()+", desea financiar: "+orden.getFinanciacion());
		System.out.println("----Solicitud:");
		
		if (stock >= solicitado) {
			orden.setDisponible(true);
			System.out.println("------ISBN: "+isbn+", precio: "+precio+"€, cantidad solicitada: "+solicitado+", en stock: "+stock+", disponibilidad: DISPONIBLE");
		} else {
			orden.setDisponible(false);
			System.out.println("------ISBN: "+isbn+", precio: "+precio+"€, cantidad solicitada: "+solicitado+", en stock: "+stock+", disponibilidad: NO DISPONIBLE");
			System.out.println("--PEDIDO RECHAZADO POR FALTA DE STOCK");
		}
		
		return orden;
	}
}
