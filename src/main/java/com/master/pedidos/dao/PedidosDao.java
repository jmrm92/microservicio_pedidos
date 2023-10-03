package com.master.pedidos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.pedidos.model.Pedido;

public interface PedidosDao extends JpaRepository <Pedido, Integer> {
    
}
