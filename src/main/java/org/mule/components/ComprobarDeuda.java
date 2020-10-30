package org.mule.components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Orden;

public class ComprobarDeuda {

	public Orden comprobacionStock(Orden orden) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		prop.load(new FileReader("src/deuda.properties"));

		String nif = orden.getNif();
		
		// Se comprueba que haya deuda. Si la hay se comprueba si es mayor o menor de 2000
		try {
			int deuda = Integer.parseInt(prop.getProperty(nif));

			if (deuda < 2000) {
				orden.setConcederFinanciacion(true);
			} else {
				System.out.println("--Tiene una deuda actual de "+deuda+"€");
				System.out.println("----FINANCIACIÓN RECHAZADA.");
				orden.setConcederFinanciacion(false);
			}
			return orden;
		} catch (Exception e) {
			orden.setConcederFinanciacion(true);
			return orden;
		}
		
		
	}
}
