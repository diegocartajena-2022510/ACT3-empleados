package com.diegocartajena.proyecto1.service;

import com.diegocartajena.proyecto1.entity.Repuestos;
import com.diegocartajena.proyecto1.repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceImplements implements RepuestosService {
    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceImplements(RepuestosRepository repuestosRepository){
        this.repuestosRepository=repuestosRepository;
    }


    @Override
    public List<Repuestos> gettAllRepuestos() {
        return List.of();
    }

    @Override
    public Repuestos getRepuestosById(Integer id) {
        return null;
    }

    @Override
    public Repuestos saveRepuestos(Repuestos repuesto) throws RuntimeException {
        return null;
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestos) {
        return null;
    }

    @Override
    public void deleteRepuestos(Integer id) {

    }
}
