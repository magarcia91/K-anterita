import { Component } from '@angular/core';
import { ProductoDTO } from 'src/app/model/ProductoDTO';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { FormGroup, FormControl } from '@angular/forms';
import { Cliente } from 'src/app/model/Cliente';
import { VentaClienteDTO } from './model/VentaClienteDTO';
import { Router } from '@angular/router';
import { VentaService } from './service/venta.service';
import { ClienteService } from './service/cliente.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ventas-frontend';

  constructor(private service:VentaService, private serviceCliente:ClienteService){}

  productos:ProductoDTO[] = new Array();
  producto:ProductoDTO;
  newProduct:ProductoDTO;

  productList:ProductoDTO[] = new Array();
  productTemp:ProductoDTO;
  productItemTotal:number;
  stockFinal:number=0;
  productoTotal:number=0;

  clientes:Cliente[] = new Array();
  cliente:Cliente;
  newCliente:Cliente;
  clientSelected:Cliente;
  nombre:String;
  idCliente:number;

  ventaCliente:VentaClienteDTO;

  ventaForm = new FormGroup({
    id: new FormControl(''),
    descripcion: new FormControl(''),
    precio: new FormControl(''),
    cantidad: new FormControl(''),
    //stock: new FormControl('')
  });

  clienteForm = new FormGroup({
    idCliente: new FormControl(''),
    nombre: new FormControl('')
  });

  ngOnInit() {
    this.serviceCliente.getCliente()
    .subscribe(data=>{
      this.clientes=data;
    })

    this.service.getProductoStock()
    .subscribe(data=>{
      this.productList=data;
    })
  }

  agregarProducto(){
    this.newProduct = new ProductoDTO();
    this.newProduct.id=this.ventaForm.get('id').value;
    this.newProduct.descripcion=this.ventaForm.get('descripcion').value;
    this.newProduct.cantidad=this.ventaForm.get('cantidad').value;
    this.newProduct.precio=this.ventaForm.get('precio').value;
    //this.newProduct.stock=this.ventaForm.get('stock').value;
    this.productos.push(this.newProduct);
    this.productoTotal = this.productoTotal + this.productItemTotal;
    this.stockFinal = this.stockFinal - this.ventaForm.get('cantidad').value;
  }

  agregarCliente(){
    this.newCliente = new Cliente();
    this.newCliente.idCliente=this.clienteForm.get('idCliente').value;
    this.newCliente.nombre=this.clienteForm.get('nombre').value;
    this.clientes.push(this.newCliente);
  }

  eliminarProducto(producto:ProductoDTO){
    var i = this.productos.indexOf(producto);
    if ( i !== -1 ) {
      this.productos.splice( i, 1 );
    }
    this.productoTotal = this.productoTotal - (producto.precio * producto.cantidad);
  }

  eliminarCliente(cliente:Cliente){
    var i = this.clientes.indexOf(cliente);
    if ( i !== -1 ) {
      this.clientes.splice( i, 1 );
    }
    this.nombre = this.nombre;
  }

  recuperarClienteSelected(){
    var cliente = this.clientes.find(cliente => cliente.idCliente == this.clienteForm.get('idCliente').value);
    this.clientSelected = cliente;
    this.nombre=cliente.nombre;
  }

  recuperarProductoSelected(){
    var producto = this.productList.find(producto => producto.id == this.ventaForm.get('id').value);
    this.ventaForm.setValue({id: producto.id, descripcion: producto.descripcion, precio: producto.precio, cantidad:1});
    this.calcularProductoItemTotal();
  }

  calcularProductoItemTotal(){
    this.productItemTotal = this.ventaForm.get('precio').value * this.ventaForm.get('cantidad').value;
  }

  calcularProductoStock(){
    this.stockFinal = this.ventaForm.get('stock').value - 1;
  }

  guardarVenta(){
    this.ventaCliente = new VentaClienteDTO();
    this.ventaCliente.cliente = this.clientSelected;
    this.ventaCliente.productos = this.productos;
    console.warn(this.ventaCliente);
    console.warn(this.ventaCliente.productos);
    console.warn(this.ventaCliente.cliente);

    this.service.setVentaCliente(this.ventaCliente)
    .subscribe(data=>{
      alert(["Venta registrada exitosamente!!!"]);
    })

  }
}
