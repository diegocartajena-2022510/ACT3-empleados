package com.diegocartajena.proyecto1.controller;

import com.diegocartajena.proyecto1.entity.Proveedores;
import com.diegocartajena.proyecto1.service.ProveedoresService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")

public class ProveedoresController {
    private final ProveedoresService proveedoresService;

    public ProveedoresController(ProveedoresService ProveedoresService){this.proveedoresService=ProveedoresService;}

    @GetMapping
    public List<Proveedores> getAllProveedor() { return proveedoresService.getAllProveedores();}

    @PostMapping
    public ResponseEntity<Object> createProveedor(@Valid @RequestBody Proveedores proveedores){
        try{
            Proveedores createdProveedor= proveedoresService.saveProveedores(proveedores);
            return new ResponseEntity<>(createdProveedor, HttpStatus.CREATED);

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@PathVariable Integer id, @Valid @RequestBody Proveedores proveedores) {
        try{
            Proveedores proveedor = proveedoresService.getProveedoresById(id);
            if (proveedor == null) {
                return ResponseEntity.notFound().build();
            }
            proveedores.setIdProveedor(id);

            Proveedores updatedProveedores = proveedoresService.updateProveedores(id,proveedores);
            return ResponseEntity.ok(updatedProveedores);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id){
        try{
            Proveedores proveedores=proveedoresService.getProveedoresById(id);
            proveedoresService.deleteProveedores(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
