package org.mule.transforms;

import java.util.Collection;
import java.util.Vector;
import org.mule.api.transformer.TransformerException;
import org.mule.entities.Orden;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class FileToOrdenTransformer extends AbstractTransformer {

	public FileToOrdenTransformer() {
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(Collection.class));
	}
	
	@Override
	protected Object doTransform(Object src, String encoding) throws TransformerException {
		
		System.out.println("Entrando en el transformador FileToOrderTransformer...");
		System.out.println("Datos de entrada: "+src);
		
		Vector<Orden> resultado = new Vector<Orden>();
		
		String datosSucio = ((String)src).trim().replaceAll("(\n|\r)", "-");
		String [] datos = datosSucio.split("--");

		System.out.println("Linea 0: "+datos[0]);
		System.out.println("Linea 1: "+datos[1]);
		System.out.println("Linea 2: "+datos[2]);
		
		for ( int i = 3 ; i < datos.length ; i ++) {
			System.out.println("Linea "+i+": "+datos[i]);
			// Datos personales
			Orden orden = new Orden();
			String[] personal = datos[1].split(";");
			orden.setNif(personal[0]);
			orden.setNombre(personal[1]);
			orden.setFinanciacion(personal[2]);
			// 1 pedido
			String[] unLibro = datos[i].split(";");
			orden.setIsbn(unLibro[0]);
			orden.setCantidad(Integer.parseInt(unLibro[1]));
			resultado.add(orden);
		}
		
		System.out.println("Datos transformados: " +resultado);
		
		return resultado;
	}

}
