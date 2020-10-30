package org.mule.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Orden;

public class GenerarCredito {
	public Orden actualizacionDeuda(Orden orden) throws FileNotFoundException, IOException {

		Properties propDeuda = new Properties();

		int precio = orden.getPrecio();
		
		propDeuda.load(new FileReader("src/deuda.properties"));
		String nif = orden.getNif();
		
		// Se comprueba si ya había deuda pendiente y se actualiza
		try {
			int deuda = Integer.parseInt(propDeuda.getProperty(nif));
			int nuevaDeuda = precio + deuda;
			propDeuda.setProperty(nif, Integer.toString(nuevaDeuda));
			propDeuda.store(new FileWriter("src/deuda.properties"), "Actualización de deuda");
			
			System.out.println("--SE CONCEDE UN CRÉDITO DE : "+precio+"€");
			System.out.println("----Su deuda asciende a : "+nuevaDeuda+"€");
		
		} catch (Exception e) {
			propDeuda.setProperty(nif, Integer.toString(precio));
			propDeuda.store(new FileWriter("src/deuda.properties"), "Actualización de deuda");
			
			System.out.println("--SE CONCEDE UN CRÉDITO DE : "+precio+"€");
			System.out.println("----Su deuda asciende a : "+precio+"€");
			
		}
		
		// Generación carta de notificación de concesión de crédito
		File tmpDir = new File("src/"+orden.getNif()+".txt");
		boolean exists = tmpDir.exists();
		
		if(exists == true) {
			String fileName = "src/"+orden.getNif()+".txt";
	        File myfile = new File(fileName);
	        
	        try (FileWriter writer = new FileWriter(myfile, true)) {
	        	writer.write("Se ha concedido un crédito de " + precio +"€\r\n");
	        } 
		}else{
			try (FileWriter writer = new FileWriter("src/"+orden.getNif()+".txt")) {
				writer.write("Se ha concedido un crédito de " + precio +"€\r\n");
	        }
		}
		
		return orden;
		
	}
}
