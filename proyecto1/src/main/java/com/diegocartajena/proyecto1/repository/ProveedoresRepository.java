package com.diegocartajena.proyecto1.repository;

import com.diegocartajena.proyecto1.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
}
