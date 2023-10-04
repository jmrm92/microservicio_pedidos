package com.master.pedidos.Exceptions;

public class StockInsuficiente extends RuntimeException {

    public StockInsuficiente() {
        super("Stock no suficiente para completar el pedido");
    }
}
