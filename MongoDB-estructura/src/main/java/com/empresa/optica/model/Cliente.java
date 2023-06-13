package com.empresa.optica.model;

import java.util.Date;

public class Cliente {
    private String nombre;
    private String direccionPostal;
    private String telefono;
    private String correoElectronico;
    private Date fechaRegistro;
    private Cliente clienteRecomendador;
	
    public Cliente(String nombre, String direccionPostal, String telefono, String correoElectronico, Date fechaRegistro,
			Cliente clienteRecomendador) {
		super();
		this.nombre = nombre;
		this.direccionPostal = direccionPostal;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.fechaRegistro = fechaRegistro;
		this.clienteRecomendador = clienteRecomendador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente getClienteRecomendador() {
		return clienteRecomendador;
	}

	public void setClienteRecomendador(Cliente clienteRecomendador) {
		this.clienteRecomendador = clienteRecomendador;
	}

    
}
