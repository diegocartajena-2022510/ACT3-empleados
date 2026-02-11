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
        return repuestosRepository.findAll();
    }

    @Override
    public Repuestos getRepuestosById(Integer id) {
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveRepuestos(Repuestos repuesto) throws RuntimeException {
        return repuestosRepository.save(repuesto);
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestos) {
        return repuestosRepository.save(repuestos);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        repuestosRepository.deleteById(id);

    }
}
