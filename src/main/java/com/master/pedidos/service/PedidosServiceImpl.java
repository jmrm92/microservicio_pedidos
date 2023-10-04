package com.master.pedidos.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.master.pedidos.dao.PedidosDao;
import com.master.pedidos.model.Pedido;
import com.master.pedidos.model.Producto;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    PedidosDao dao;

    @Autowired
    RestTemplate template;

    private String url = "http://localhost:8080/";

    /**
     * Recupera la lista de pedidos.
     * 
     * @return Lista de objetos Pedido.
     */
    @Override
    public List<Pedido> pedidos() {
        return dao.findAll();
    }

    /**
     * Crea un nuevo pedido para el producto especificado.
     * 
     * @param codigoProducto El código del producto.
     * @param unidades       La cantidad de unidades a pedir.
     * @return Lista de objetos Pedido.
     */
    @Override
    public List<Pedido> nuevoPedido(int codigoProducto, int unidades) {
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCodigoProducto(codigoProducto);
        nuevoPedido.setUnidades(unidades);
        List<Producto> productos = Arrays.asList(template.getForObject(url, Producto[].class));
        for (Producto producto : productos) {
            if (producto.getCodigoProducto() == nuevoPedido.getCodigoProducto()) {
                if (producto.getStock() >= unidades) {
                    producto.setStock(producto.getStock() - nuevoPedido.getUnidades());
                    nuevoPedido.setTotal(unidades * producto.getPrecioUnitario());
                    template.put(url + producto.getCodigoProducto() + "/" + producto.getStock(), producto);
                } else {
                    return null; // No hay suficiente stock para efectuar el pedido
                }
            } else {
                return null; // No existe el producto
            }
        }
        nuevoPedido.setFecha(LocalDateTime.now());
        dao.save(nuevoPedido);
        return dao.findAll();
    }

}
