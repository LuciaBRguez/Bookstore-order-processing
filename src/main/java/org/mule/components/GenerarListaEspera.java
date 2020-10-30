package org.mule.components;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.mule.entities.Orden;

public class GenerarListaEspera {
	public Orden generarListaEspera(Orden orden) throws IOException {
		
		File tmpDir = new File("src/"+orden.getIsbn()+".txt");
		boolean exists = tmpDir.exists();
		
		if(exists == true) {
			String fileName = "src/"+orden.getIsbn()+".txt";
	        File myfile = new File(fileName);
	        
	        try (FileWriter writer = new FileWriter(myfile, true)) {
	        	writer.write("Se han pedido " + orden.getCantidad() +" libros. A la espera de STOCK.\n");
	        } 
		}else{
			try (FileWriter writer = new FileWriter("src/"+orden.getIsbn()+".txt")) {
	            writer.write("Se han pedido " + orden.getCantidad() +" libros. A la espera de STOCK.\n");
	        }
		}
		
       return orden;
	}
}
