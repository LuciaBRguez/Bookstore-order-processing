package org.mule.entities;

import java.io.Serializable;

public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nif;
	private String nombre;
	private String financiacion;
	private boolean concederFinanciacion;
	private String isbn;
	private int cantidad;
	private boolean disponible;
	private int precio;
	private int compras;
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
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
	public String getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(String financiacion) {
		this.financiacion = financiacion;
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
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public boolean isConcederFinanciacion() {
		return concederFinanciacion;
	}
	public void setConcederFinanciacion(boolean concederFinanciacion) {
		this.concederFinanciacion = concederFinanciacion;
	}
	public int getCompras() {
		return compras;
	}
	public void setCompras(int compras) {
		this.compras = compras;
	}
	@Override
	public String toString() {
		return "Orden [nombre=" + nombre + ", NIF=" + nif + ", financiacion=" + financiacion + ", isbn=" + isbn + ", cantidad=" + cantidad + "]";
	}
}
