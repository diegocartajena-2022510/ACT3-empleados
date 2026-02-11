package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IdVenta")
    private Integer idVenta;

    @Column(name = "fechaVenta")
    private Date fechaVenta;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private double total;

    @Column(name = "IdEmpleado")
    private Integer IdEmpleado;

    @Column(name = "IdRepuesto")
    private Integer IdRepuesto;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public Integer getIdRepuesto() {
        return IdRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        IdRepuesto = idRepuesto;
    }
}
