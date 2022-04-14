import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../model/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http:HttpClient) {

  }

  urlClient='http://localhost:8080/api/v1/client';
  urlCreateClient='http://localhost:8080/api/v1/createClient';

  getCliente(){
    return this.http.get<Cliente[]>(this.urlClient);
  }


  createCliente(client:Cliente){
    return this.http.post<Cliente>(this.urlCreateClient,client);
  }
}
