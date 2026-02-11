package com.diegocartajena.proyecto1.controller;

import com.diegocartajena.proyecto1.entity.Repuestos;
import com.diegocartajena.proyecto1.service.EmpleadoService;
import com.diegocartajena.proyecto1.service.RepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {
    private final RepuestosService repuestosService;

    public  RepuestosController(RepuestosService repuestosService){this.repuestosService=repuestosService;}

    @GetMapping
    public List<Repuestos> gettAllRepuestos(){return repuestosService.gettAllRepuestos();}

    @PostMapping
    public ResponseEntity<Object> createdRepuestos(@Valid @RequestBody Repuestos repuesto){
        try{
            Repuestos createdRepuestos= repuestosService.saveRepuestos(repuesto);
            return new ResponseEntity<>(createdRepuestos, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> UpdateRepuestos(@PathVariable Integer id, @Valid @RequestBody Repuestos repuestos){
        try{
            Repuestos repuestos1= repuestosService.getRepuestosById(id);
            if(repuestos1==null){
                return ResponseEntity.notFound().build();
            }
            repuestos.setIdRepuesto(id);
            Repuestos updateRepuestos= repuestosService.updateRepuestos(id,repuestos);
            return ResponseEntity.ok(updateRepuestos);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuestos(@PathVariable Integer id){
        try{
            Repuestos repuestos= repuestosService.getRepuestosById(id);
            repuestosService.deleteRepuestos(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadoById(@PathVariable Integer id){
        try{
            Repuestos repuestos= repuestosService.getRepuestosById(id);
            return ResponseEntity.ok(repuestos);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
