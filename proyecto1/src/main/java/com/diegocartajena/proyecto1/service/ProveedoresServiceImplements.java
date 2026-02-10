package com.diegocartajena.proyecto1.service;

import com.diegocartajena.proyecto1.entity.Proveedores;
import com.diegocartajena.proyecto1.repository.EmpleadoRepository;
import com.diegocartajena.proyecto1.repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements implements ProveedoresService {
    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresServiceImplements(ProveedoresRepository proveedoresRepository){
        this.proveedoresRepository=proveedoresRepository;

    }


    @Override
    public List<Proveedores> getAllProveedores() {return proveedoresRepository.findAll();}

    @Override
    public Proveedores getProveedoresById(Integer id) { return proveedoresRepository.findById(id).orElse(null);}

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) throws RuntimeException {
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public void deleteProveedores(Integer id) {
        proveedoresRepository.deleteById(id);
    }
}
