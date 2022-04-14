import { Cliente } from './Cliente';
import { ProductoDTO } from './ProductoDTO';

export class VentaClienteDTO{
    cliente:Cliente;
    productos:ProductoDTO[];
}
