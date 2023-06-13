package com.empresa.optica.model;

public class Empleado {
	private int empleadoID;
	private String nombre;
	
	public Empleado(int empleadoID, String nombre) {
		super();
		this.empleadoID = empleadoID;
		this.nombre = nombre;
	}
	public int getEmpleadoID() {
		return empleadoID;
	}
	public void setEmpleadoID(int empleadoID) {
		this.empleadoID = empleadoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
