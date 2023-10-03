package com.master.pedidos.model;

import java.sql.Date;

public class Pedido {
    
    private int idPedido;
    private String codigoProducto;
    private int unidades;
    private double total;
    private Date fecha;

    public Pedido() {
    }

    public Pedido(int idPedido, String codigoProducto, int unidades, double total, Date fecha) {
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

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }  
}
