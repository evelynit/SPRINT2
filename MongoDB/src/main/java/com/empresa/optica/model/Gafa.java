package com.empresa.optica.model;

public class Gafa {
    private String marca;
    private double graduacion;
    private String tipoMontura;
    private String colorMontura;
    private String colorCristal;
    private double precio;
	
    public Gafa(String marca, double graduacion, String tipoMontura, String colorMontura, String colorCristal,
			double precio) {
		super();
		this.marca = marca;
		this.graduacion = graduacion;
		this.tipoMontura = tipoMontura;
		this.colorMontura = colorMontura;
		this.colorCristal = colorCristal;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(double graduacion) {
		this.graduacion = graduacion;
	}

	public String getTipoMontura() {
		return tipoMontura;
	}

	public void setTipoMontura(String tipoMontura) {
		this.tipoMontura = tipoMontura;
	}

	public String getColorMontura() {
		return colorMontura;
	}

	public void setColorMontura(String colorMontura) {
		this.colorMontura = colorMontura;
	}

	public String getColorCristal() {
		return colorCristal;
	}

	public void setColorCristal(String colorCristal) {
		this.colorCristal = colorCristal;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

    
}