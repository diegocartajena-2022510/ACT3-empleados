package com.diegocartajena.proyecto1.controller;

import com.diegocartajena.proyecto1.entity.Ventas;
import com.diegocartajena.proyecto1.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {this.ventasService = ventasService;}

    @GetMapping
    public List<Ventas> getAllVentas(){return ventasService.getAllVentas();}

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Ventas ventas){

        Ventas createdVentas= ventasService.saveVentas(ventas);
        return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVentas(@PathVariable Integer id, @Valid @RequestBody Ventas ventas){
        try{
            Ventas venta= ventasService.getVentasById(id);
            if(venta==null){
                return ResponseEntity.notFound().build();
            }
            ventas.setIdVenta(id);

            Ventas updateVentas= ventasService.updateVentas(id,ventas);
            return ResponseEntity.ok(updateVentas);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> deleteVentas(@PathVariable Integer id){
        try {
            Ventas ventas = ventasService.getVentasById(id);

            ventasService.deleteVentas(id);
            return ResponseEntity.ok(ventas);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String,String> errores= new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName= ((FieldError) error).getField();
            String errorMessage=error.getDefaultMessage();
            errores.put(fieldName,errorMessage);
        });
        return errores;
    }
}


