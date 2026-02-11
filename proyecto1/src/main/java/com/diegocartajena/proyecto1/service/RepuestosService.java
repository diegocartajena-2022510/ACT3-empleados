package com.diegocartajena.proyecto1.service;

import com.diegocartajena.proyecto1.entity.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestosService {
    List<Repuestos> gettAllRepuestos();
    Repuestos getRepuestosById(Integer id);
    Repuestos saveRepuestos(Repuestos repuesto) throws RuntimeException;
    Repuestos updateRepuestos(Integer id,Repuestos repuestos);
    void deleteRepuestos(Integer id);
}
