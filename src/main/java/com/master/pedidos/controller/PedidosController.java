package com.master.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.pedidos.model.Pedido;
import com.master.pedidos.service.PedidosServiceImpl;

@RestController
public class PedidosController {

    @Autowired
    PedidosServiceImpl service;

    /**
    * Recupera la lista de pedidos.
    * 
    * @return Lista de objetos Pedido.
    */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> obtenerPedidos() {
        return service.pedidos();
    }

    /**
    * Crea un nuevo pedido para el producto especificado.
    * 
    * @param codigoProducto El código del producto.
    * @param unidades       La cantidad de unidades a pedir.
    * @return Lista de objetos Pedido.
    */
    @PostMapping(value = "/{codigoProducto}/{unidades}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> nuevoPedido(@PathVariable int codigoProducto, @PathVariable int unidades) {
        return service.nuevoPedido(codigoProducto, unidades);
    }
}
