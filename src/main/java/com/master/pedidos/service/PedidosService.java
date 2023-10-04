package com.master.pedidos.service;

import java.util.List;

import com.master.pedidos.model.Pedido;

public interface PedidosService {
    List<Pedido> pedidos();
    List<Pedido> nuevoPedido(int codigoProducto, int unidades);
}
