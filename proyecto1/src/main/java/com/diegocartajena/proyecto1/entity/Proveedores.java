package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idProveedor")
    private Integer idProveedor;

    @NotBlank(message = "el nombre es obligatorio")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "El nombre no puede contener numeros ni caracteres especiales")
    @Column(name = "nombreProveedor")
    private String nombreProveedor;

    @NotNull(message = "este campo es obligatorio")
    @Min(value=1,message = "el numero telefonico no es valido")
    @Column(name = "telefonoProveedor")
    private Integer telefonoProveedor;

    @NotBlank(message = "la direccion es obligatoria")
    @Column(name = "direccionProveedor")
    private String direccionProveedor;

    @NotBlank(message = "el email es obligatorio")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@gmail\\.com$", message="el formato del correo no es valido")
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
