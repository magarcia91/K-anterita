package com.ventasbackend.dto;

import java.io.Serializable;
import java.util.List;

import com.ventasbackend.model.Cliente;

public class VentaClienteDTO implements Serializable {
	
	private static final long serialVersionUID = -8479750766356424606L;
	
	private Cliente cliente;
	private List<ProductoDTO> productos;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ProductoDTO> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}
	
}
