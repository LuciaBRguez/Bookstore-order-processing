package org.mule.components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Orden;

public class ActualizacionStock {
	public Orden comprobacionStock(Orden orden) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		prop.load(new FileReader("src/stock.properties"));

		String isbn = orden.getIsbn();
		int stock = Integer.parseInt(prop.getProperty(isbn));
		int solicitado = orden.getCantidad();
		int nuevo = stock - solicitado;
		
		prop.setProperty(isbn, Integer.toString(nuevo));
		prop.store(new FileWriter("src/stock.properties"), "Actualización de stock");
		
		System.out.println("--ACTUALIZACIÓN DE STOCK: "+nuevo);
		
		return orden;
	}
}
