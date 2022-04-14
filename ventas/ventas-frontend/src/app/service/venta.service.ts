import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../model/Cliente';
import { ProductoDTO } from '../model/ProductoDTO';
import { VentaClienteDTO } from '../model/VentaClienteDTO';

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  constructor(private http:HttpClient) { }

  urlProductInStock='http://localhost:8080/api/v1/productinstock';
  urlSalesClient='http://localhost:8080/api/v1/saleclient';



  getProductoStock(){
    return this.http.get<ProductoDTO[]>(this.urlProductInStock);
  }

  setVentaCliente(saleClient:VentaClienteDTO){
    return this.http.post<VentaClienteDTO>(this.urlSalesClient,saleClient);

  }

}
