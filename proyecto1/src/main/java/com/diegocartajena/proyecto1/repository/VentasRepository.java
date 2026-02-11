package com.diegocartajena.proyecto1.repository;

import com.diegocartajena.proyecto1.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
