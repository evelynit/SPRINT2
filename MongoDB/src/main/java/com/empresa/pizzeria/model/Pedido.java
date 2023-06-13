package com.empresa.pizzeria.model;
import java.util.Date;
import java.util.Map;

public class Pedido {
    private String id;
    private Date fechaHora;
    private String modo;
    private Map<String, Integer> productos;
    private Double precioTotal;
    private String clienteId;
    private String tiendaId;
    private String empleadoId;
    private Date horaEntrega;
	public Pedido(String id, Date fechaHora, String modo, Map<String, Integer> productos, Double precioTotal,
			String clienteId, String tiendaId, String empleadoId, Date horaEntrega) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.modo = modo;
		this.productos = productos;
		this.precioTotal = precioTotal;
		this.clienteId = clienteId;
		this.tiendaId = tiendaId;
		this.empleadoId = empleadoId;
		this.horaEntrega = horaEntrega;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public Map<String, Integer> getProductos() {
		return productos;
	}
	public void setProductos(Map<String, Integer> productos) {
		this.productos = productos;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getTiendaId() {
		return tiendaId;
	}
	public void setTiendaId(String tiendaId) {
		this.tiendaId = tiendaId;
	}
	public String getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}
	public Date getHoraEntrega() {
		return horaEntrega;
	}
	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
    
    
}
