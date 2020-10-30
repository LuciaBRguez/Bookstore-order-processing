package org.mule.transforms;

import java.util.Collection;
import java.util.Vector;
import org.mule.api.transformer.TransformerException;
import org.mule.entities.Orden;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class HttpToOrdenTransformer extends AbstractTransformer {

	public HttpToOrdenTransformer() {
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(Collection.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		
		Vector<Orden> resultado = new Vector<Orden>();
		String nif = null, nombre = null, financiacion = null;
		String cadena= (String) src;
		
		System.out.println("Entrando en el transformador HttpToOrdenTransformer...");
		System.out.println("Datos de entrada: "+cadena);
		
		String[] parametros = cadena.split("&");
		
		for (int i=0; i<parametros.length; i++) {

			Orden orden = new Orden();
			
			String[] item = parametros[i].split("=");
			
			if (item[0].equals("nif")) {
				nif = item[1];
			}
			if (item[0].equals("nombre")) {
				nombre = item[1];
			}
			if (item[0].equals("financiacion")) {
				financiacion = item[1];
			}
			if (item[0].equals("0321127420")) {
				orden.setIsbn(item[0]);
				orden.setNif(nif);
				orden.setNombre(nombre);
				orden.setFinanciacion(financiacion);
				orden.setCantidad(Integer.parseInt(item[1]));
				// Se comprueba que se pide al menos un libro
				if (Integer.parseInt(item[1]) > 0) {
					resultado.add(orden);
				}
			}
			if (item[0].equals("0201485672")) {
				orden.setIsbn(item[0]);
				orden.setNif(nif);
				orden.setNombre(nombre);
				orden.setFinanciacion(financiacion);
				orden.setCantidad(Integer.parseInt(item[1]));
				// Se comprueba que se pide al menos un libro
				if (Integer.parseInt(item[1]) > 0) {
					resultado.add(orden);
				}
			}
			if (item[0].equals("1933988967")) {
				orden.setIsbn(item[0]);
				orden.setNif(nif);
				orden.setNombre(nombre);
				orden.setFinanciacion(financiacion);
				orden.setCantidad(Integer.parseInt(item[1]));
				// Se comprueba que se pide al menos un libro
				if (Integer.parseInt(item[1]) > 0) {
					resultado.add(orden);
				}
			}
			if (item[0].equals("0201615835")) {
				orden.setIsbn(item[0]);
				orden.setNif(nif);
				orden.setNombre(nombre);
				orden.setFinanciacion(financiacion);
				orden.setCantidad(Integer.parseInt(item[1]));
				// Se comprueba que se pide al menos un libro
				if (Integer.parseInt(item[1]) > 0) {
					resultado.add(orden);
				}
			}
		}
		
		System.out.println("Datos transformados: " +resultado);

		return resultado;
	}

}
