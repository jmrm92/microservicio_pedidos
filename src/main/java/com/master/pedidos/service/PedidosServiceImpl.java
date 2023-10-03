package com.master.pedidos.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.master.pedidos.dao.PedidosDao;
import com.master.pedidos.model.Pedido;

public class PedidosServiceImpl implements PedidosService{

    @Autowired
    PedidosDao dao;
    @Override
    public List<Pedido> pedidos() {
        return dao.findAll();
    }

    @Override
    public List<Pedido> nuevoPedido(String codigoProducto, int unidades, double total, Date fecha) {
        Pedido p = new Pedido(unidades, codigoProducto, unidades, total, fecha);
        dao.save(p);
        return dao.findAll();
    }
    
}
