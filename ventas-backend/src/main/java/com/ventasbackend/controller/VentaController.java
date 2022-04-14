package com.ventasbackend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventasbackend.dto.ProductoDTO;
import com.ventasbackend.dto.ProductoStockDTO;
import com.ventasbackend.dto.VentaClienteDTO;
import com.ventasbackend.model.DetalleVenta;
import com.ventasbackend.model.Kardex;
import com.ventasbackend.model.Venta;
import com.ventasbackend.repository.ClienteRepository;
import com.ventasbackend.repository.KardexRepository;
import com.ventasbackend.repository.ProductoRepository;
import com.ventasbackend.repository.DetalleVentaRepository;
import com.ventasbackend.repository.VentaRepository;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
public class VentaController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private KardexRepository kardexRepository;

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@GetMapping("/api/v1/productinstock")
	public List<ProductoStockDTO> getProductoStock() {
		return productoRepository.productoStock();
	}

	@PostMapping("/api/v1/saleclient")
	public VentaClienteDTO setSaleClient(@RequestBody VentaClienteDTO ventaCliente) {
		return this.saveSaleClient(ventaCliente);
	}
	
	private VentaClienteDTO saveSaleClient(VentaClienteDTO ventaCliente) {
		/*cliente*/
		clienteRepository.save(ventaCliente.getCliente());
		
		/*venta*/
		Venta venta = new Venta();
		venta.setIdCliente(ventaCliente.getCliente().getIdCliente());
		java.util.Date date = new Date();
		venta.setFecha(date);
		ventaRepository.save(venta);

		for(ProductoDTO producto : ventaCliente.getProductos()) {
			/*detalle venta*/
			DetalleVenta detalleVenta = new DetalleVenta();
			detalleVenta.setIdVenta(venta.getIdVenta());
			detalleVenta.setIdProducto(producto.getIdProducto());			
			detalleVenta.setCantidad(producto.getCantidad());
			detalleVenta.setStock(stockProductos(producto.getCantidad(), producto.getStock()));
			detalleVenta.setPrecio(producto.getPrecio());
			detalleVentaRepository.save(detalleVenta);

			/*kardex*/
			Kardex kardex = new Kardex();
			kardex.setIdProducto(producto.getIdProducto());
			kardex.setTipoTransaccion("SAL");
			kardex.setIdTransaccion(venta.getIdVenta());
			kardex.setCantidad(producto.getCantidad()*-1);
			kardex.setStock(producto.getStock()*-1);
			kardex.setPrecio(producto.getPrecio() * -1);
			kardexRepository.save(kardex);
		}
		return ventaCliente;
	} 
	
	public Long stockProductos(Long cantidad,Long stock) {
		//la logica es la siguiente//-
		/*ejemplo cantidad tengo 100 =100-20
		 * queda stock 80 retorna 80*/
		Long stockFinal;
		stockFinal = stock - cantidad;
		return stockFinal;
	}
}
