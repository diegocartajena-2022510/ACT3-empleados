package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IdVenta")
    private Integer idVenta;

    @NotBlank(message = "la fecha es obligatoria")
    @Column(name = "fechaVenta")
    private Date fechaVenta;

    @NotNull(message = "este campo es obligatorio")
    @Min(value=1,message = "el precio debe ser mayor a 1")
    @Column(name = "cantidad")
    private int cantidad;

    @NotNull(message = "este campo es obligatorio")
    @Min(value=1,message = "el precio debe ser mayor a 1")
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
