package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idProveedor")
    private Integer idProveedor;

    @Column(name = "nombreProveedor")
    private String nombreProveedor;

    @Column(name = "telefonoProveedor")
    private Integer telefonoProveedor;

    @Column(name = "direccionProveedor")
    private String direccionProveedor;

    @Column(name = "emailProveedor")
    private String emailProveedor;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(Integer telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
}
