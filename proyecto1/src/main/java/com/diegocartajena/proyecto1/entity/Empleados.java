package com.diegocartajena.proyecto1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idEmpleado")
    private Integer idEmpleado;

    @NotBlank(message = "el nombre es obligatorio")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "El nombre no puede contener numeros ")
    @Column(name= "nombreEmpleado")
    private String nombreEmpleado;

    @NotBlank(message = "el apellido es obligatorio")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "El apellido no puede contener numeros")
    @Column(name = "apellidoEmpleado")
    private String apellidoEmpleado;

    @NotBlank(message = "el puesto no puede estar vacio")
    @Pattern(regexp ="^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$", message = "El puesto no puede contener numeros ")
    @Column(name="puestoEmpleado")
    private String puestoEmpleado;


    @NotBlank(message = "el email  es obligatorio")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@gmail\\.com$", message="el formato del correo no es valido")
    @Column(name="emailEmpleado")
    private String emailEmpleado;

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }
}
