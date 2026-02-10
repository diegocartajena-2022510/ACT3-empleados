package com.diegocartajena.proyecto1.service;

import com.diegocartajena.proyecto1.entity.Empleados;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadoService {

    List<Empleados> getAllEmpleados();
    Empleados getEmpleadoById(Integer id);
    Empleados saveEmpleado(Empleados empleado)throws RuntimeException;
    Empleados updateEmpleado(Integer id, Empleados empleado ) ;
    void deleteEmpleado(Integer id);
}