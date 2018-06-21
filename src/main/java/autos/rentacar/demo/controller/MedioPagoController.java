/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import autos.rentacar.demo.model.MedioPagoModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/medioPago")
public class MedioPagoController {
    
    @GetMapping()
    public List<MedioPagoModel> list() {
        
        return MedioPagoModel.medioPago;
    }
    
    @GetMapping("/{id}")
    public MedioPagoModel get(@PathVariable String id) {
        
        MedioPagoModel medioPago = new MedioPagoModel();
       
        return medioPago.buscaMedioPago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> put(@PathVariable String id, @RequestBody MedioPagoModel editarMedioPago) {
          MedioPagoModel medioPago = new MedioPagoModel();
        
        return new ResponseEntity<>(medioPago.editarMedioPago(Integer.parseInt(id), editarMedioPago), HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPagoModel nuevoMedioPago) {
        MedioPagoModel medioPago = new MedioPagoModel();
        
       if(medioPago.nuevoMedioPago(nuevoMedioPago)){
           return new ResponseEntity<>(HttpStatus.CREATED);
           
       }else{
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        MedioPagoModel medioPago = new MedioPagoModel();
        
        if(medioPago.eliminarMedioPago(Integer.parseInt(id))){
            
             return new ResponseEntity<>(HttpStatus.OK);
        }else{
             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
       
    }
    
}
