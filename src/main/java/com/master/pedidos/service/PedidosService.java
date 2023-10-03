package com.master.pedidos.service;

import java.sql.Date;
import java.util.List;

import com.master.pedidos.model.Pedido;

public interface PedidosService {
    List<Pedido> pedidos();
    List<Pedido> nuevoPedido(String codigoProducto, int unidades, double total, Date fecha);
}
