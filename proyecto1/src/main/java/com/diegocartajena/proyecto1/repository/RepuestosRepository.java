package com.diegocartajena.proyecto1.repository;


import com.diegocartajena.proyecto1.entity.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosRepository  extends JpaRepository<Repuestos,Integer> {
}
