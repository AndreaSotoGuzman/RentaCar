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
import autos.rentacar.demo.repository.MedioPagoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/medioPago")
public class MedioPagoController {
    
     @Autowired
   private MedioPagoRepository medioPagoRepository;
    

  @GetMapping()
    public Iterable<MedioPagoModel> listarTodos() {
        
        return medioPagoRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> muestraUnMedioPago(@PathVariable String id) {
        
        Optional<MedioPagoModel> aOptional = medioPagoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            MedioPagoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> editaMedioPago(@PathVariable String id, @RequestBody MedioPagoModel medioPagoEditar) {
        
         Optional<MedioPagoModel> aOptional = medioPagoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           MedioPagoModel aEncontrado = aOptional.get();  
            
            medioPagoEditar.setIdMedioPago(aEncontrado.getIdMedioPago());
                                
            medioPagoRepository.save(medioPagoEditar);           
            return new ResponseEntity<>(medioPagoEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarMedioPago(@RequestBody MedioPagoModel nuevoMedioPago) {
        
      nuevoMedioPago = medioPagoRepository.save(nuevoMedioPago);
        
      Optional<MedioPagoModel> aOptional = medioPagoRepository.findById(nuevoMedioPago.getIdMedioPago());      
        if (aOptional.isPresent()) {            
            MedioPagoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MedioPagoModel> aOptional = medioPagoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           MedioPagoModel aEncontrado = aOptional.get();
            
            medioPagoRepository.deleteById(aEncontrado.getIdMedioPago());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
