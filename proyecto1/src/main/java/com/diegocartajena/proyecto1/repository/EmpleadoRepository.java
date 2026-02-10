package com.diegocartajena.proyecto1.repository;

import com.diegocartajena.proyecto1.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {
}
