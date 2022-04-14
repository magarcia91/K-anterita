package com.ventasbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KARDEX")
public class Kardex {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idKardex;
	
	@Column
	private Long idProducto;
	
	@Column
	private String tipoTransaccion;

	@Column
	private Long idTransaccion;

	@Column
	private Long cantidad;
	
	@Column
	private Long stock;
	
	@Column
	private Double precio;
	
	
	public Long getIdKardex() {
		return idKardex;
	}

	public void setIdKardex(Long idKardex) {
		this.idKardex = idKardex;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Long getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
		
}
