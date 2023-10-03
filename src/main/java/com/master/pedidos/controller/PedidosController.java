package com.master.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.pedidos.model.Pedido;
import com.master.pedidos.service.PedidosServiceImpl;

@RestController
public class PedidosController {

    @Autowired
    PedidosServiceImpl service;

    @GetMapping ( value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> obtenerPedidos() {
        return service.pedidos();
    }

    @PostMapping ( value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> nuevoPedido(@RequestBody Pedido p) {
        return service.nuevoPedido(p.getCodigoProducto(), p.getUnidades(), p.getTotal(), p.getFecha());
    }
}
