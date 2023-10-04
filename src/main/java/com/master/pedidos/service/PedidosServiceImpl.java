package com.master.pedidos.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.master.pedidos.Exceptions.ProductoNoEncontrado;
import com.master.pedidos.Exceptions.StockInsuficiente;
import com.master.pedidos.dao.PedidosDao;
import com.master.pedidos.model.Pedido;
import com.master.pedidos.model.Producto;

@Service
public class PedidosServiceImpl implements PedidosService{

    @Autowired
    PedidosDao dao;

    @Autowired
    RestTemplate template;

    private String url = "http://localhost:8080/";
    
    @Override
    public List<Pedido> pedidos() {
        return dao.findAll();
    }

    @Override
    public List<Pedido> nuevoPedido(int codigoProducto, int unidades) {
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCodigoProducto(codigoProducto);
        nuevoPedido.setUnidades(unidades);
        List<Producto> productos = Arrays.asList(template.getForObject(url, Producto[].class));
        for (Producto producto : productos){
            if (producto.getCodigoProducto() == nuevoPedido.getCodigoProducto()){
                if (producto.getStock()>= unidades){
                producto.setStock(producto.getStock()-nuevoPedido.getUnidades());
                nuevoPedido.setTotal(unidades * producto.getPrecioUnitario());
                template.put(url + producto.getCodigoProducto() + "/" + producto.getStock(), producto);
                } else {
                    throw new StockInsuficiente();
                }
            } else{
                throw new ProductoNoEncontrado(codigoProducto);
            }
        }
        nuevoPedido.setFecha(LocalDateTime.now());
        dao.save(nuevoPedido);
        return dao.findAll();
    }
    
}
