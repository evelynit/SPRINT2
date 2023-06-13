package com.empresa.pizzeria.model;


public class Localidad {
    private String id;
    private String nombre;
    private String provincia;

    public Localidad(String id, String nombre, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


}