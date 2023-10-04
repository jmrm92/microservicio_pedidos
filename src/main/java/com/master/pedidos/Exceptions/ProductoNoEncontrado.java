package com.master.pedidos.Exceptions;

public class ProductoNoEncontrado extends RuntimeException {

    public ProductoNoEncontrado(int codigoProducto) {
        super("No se encontró un producto con el código: " + codigoProducto);
    }
    
}
