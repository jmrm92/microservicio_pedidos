package com.master.pedidos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "pedidos")
public class Pedido {
    @Id
    @Column (name = "id_pedido")
    private int idPedido;
    @Column(name = "codigo_producto")
    private int codigoProducto;
    private int unidades;
    private double total;
    private LocalDateTime fecha;

    public Pedido() {
    }

    public Pedido(int idPedido, int codigoProducto, int unidades, double total, LocalDateTime fecha) {
        this.idPedido = idPedido;
        this.codigoProducto = codigoProducto;
        this.unidades = unidades;
        this.total = total;
        this.fecha = fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }  
}
