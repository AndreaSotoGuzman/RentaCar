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
import autos.rentacar.demo.model.CiudadModel;
import autos.rentacar.demo.repository.CiudadRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
   @Autowired
   private CiudadRepository ciudadRepository;
    

  @GetMapping()
    public Iterable<CiudadModel> listarTodos() {
        
        return ciudadRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> muestraUnaCiudad(@PathVariable String id) {
        
        Optional<CiudadModel> aOptional = ciudadRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            CiudadModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editaCiudad(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
        
         Optional<CiudadModel> aOptional = ciudadRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CiudadModel aEncontrado = aOptional.get();  
            
            ciudadEditar.setIdCiudad(aEncontrado.getIdCiudad());
                                
            ciudadRepository.save(ciudadEditar);           
            return new ResponseEntity<>(ciudadEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarCiudad(@RequestBody CiudadModel nuevoCiudad) {
        
      nuevoCiudad = ciudadRepository.save(nuevoCiudad);
        
      Optional<CiudadModel> aOptional = ciudadRepository.findById(nuevoCiudad.getIdCiudad());      
        if (aOptional.isPresent()) {            
            CiudadModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CiudadModel> aOptional = ciudadRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CiudadModel aEncontrado = aOptional.get();
            
            ciudadRepository.deleteById(aEncontrado.getIdCiudad());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

    
}
}