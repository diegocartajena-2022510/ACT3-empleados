package com.diegocartajena.proyecto1.controller;

import com.diegocartajena.proyecto1.entity.Repuestos;
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
}
