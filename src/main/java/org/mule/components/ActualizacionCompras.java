package org.mule.components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Orden;

public class ActualizacionCompras {
	public Orden actualizacionCompras(Orden orden) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		prop.load(new FileReader("src/compras.properties"));

		int compraNueva = orden.getPrecio();
		
		try {
			int comprasHechas = Integer.parseInt(prop.getProperty(orden.getNif()));
			int dinero = comprasHechas + compraNueva;
			prop.setProperty(orden.getNif(), Integer.toString(dinero));
			prop.store(new FileWriter("src/compras.properties"), "Actualización de compras");
			orden.setCompras(dinero);
			System.out.println("--ACTUALIZACION DE COMPRAS: "+dinero+"€");
			
		} catch (Exception e) {
			prop.setProperty(orden.getNif(), Integer.toString(compraNueva));
			prop.store(new FileWriter("src/compras.properties"), "Actualización de compras");
			orden.setCompras(compraNueva);
			System.out.println("--ACTUALIZACION DE COMPRAS: "+Integer.toString(compraNueva)+"€");
		}
		
		return orden;

	}
}
