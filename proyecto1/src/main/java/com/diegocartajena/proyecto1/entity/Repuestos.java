package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Repuestos")
public class Repuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idRepuesto")
    private Integer idRepuesto;

    @Column(name = "nombreRepuesto")
    private String nombreRepuesto;

    @Column(name = "categoriaRepuesto")
    private String categoriaRepuesto;

    @Column(name = "precioCompra")
    private double precioCompra;

    @Column(name = "precioVenta")
    private double precioVenta;

    @Column(name = "idProveedor")
    private Integer idProveedor;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getCategoriaRepuesto() {
        return categoriaRepuesto;
    }

    public void setCategoriaRepuesto(String categoriaRepuesto) {
        this.categoriaRepuesto = categoriaRepuesto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
