package com.empresa.optica.model;

public class Proveedor {
	private int proveedorID;
	private String nombre;
	private String direccion;
	private String telefono;
	private String fax;
	private String nif;
	
	
	public Proveedor(int proveedorID, String nombre, String direccion, String telefono, String fax, String nif) {
		super();
		this.setProveedorID(proveedorID);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public int getProveedorID() {
		return proveedorID;
	}
	public void setProveedorID(int proveedorID) {
		this.proveedorID = proveedorID;
	}
	
	
}
