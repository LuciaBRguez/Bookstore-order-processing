package org.mule.entities;

public class Factura extends Orden {

	private static final long serialVersionUID = 1L;
	protected String nif;
	protected String nombre;
	protected String isbn;
	protected int cantidad;
	protected int precio;
	
	public Factura(Orden orden) {
		super();
		nif = orden.getNif();
		nombre = orden.getNombre();
		isbn = orden.getIsbn();
		cantidad = orden.getCantidad();
		precio = orden.getPrecio();
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
