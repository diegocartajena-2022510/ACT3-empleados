package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.aspectj.bridge.Message;

@Entity
@Table(name = "Repuestos")
public class Repuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRepuesto")
    private Integer idRepuesto;

    @NotBlank(message = "el nombre es obligatorio")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "El nombre no puede contener numeros ni caracteres especiales")
    @Column(name = "nombreRepuesto")
    private String nombreRepuesto;

    @NotBlank(message = "la categoria es obligatoria")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "la categoria no puede contener numeros ni caracteres especiales")
    @Column(name = "categoriaRepuesto")
    private String categoriaRepuesto;

    @NotNull(message = "este campo es obligatorio")
    @Min(value=1,message = "el precio debe ser mayor a 1")
    @Column(name = "precioCompra")
    private double precioCompra;

    @NotNull(message = "este campo es obligatorio")
    @Min(value=1,message = "el precio debe ser mayor a 1")
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
