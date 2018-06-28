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
import autos.rentacar.demo.model.CombustibleModel;
import autos.rentacar.demo.repository.CombustibleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/combustible")
public class CombustibleController {
    @Autowired
   private CombustibleRepository combustibleRepository;
    

  @GetMapping()
    public Iterable<CombustibleModel> listarTodos() {
        
        return combustibleRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<CombustibleModel> muestraUnCombustible(@PathVariable String id) {
        
        Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            CombustibleModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> editaArriendo(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {
        
         Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CombustibleModel aEncontrado = aOptional.get();  
            
            combustibleEditar.setIdCombustible(aEncontrado.getIdCombustible());
                                
            combustibleRepository.save(combustibleEditar);           
            return new ResponseEntity<>(combustibleEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarCombustible(@RequestBody CombustibleModel nuevoCombustible) {
        
      nuevoCombustible = combustibleRepository.save(nuevoCombustible);
        
      Optional<CombustibleModel> aOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());      
        if (aOptional.isPresent()) {            
            CombustibleModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CombustibleModel aEncontrado = aOptional.get();
            
            combustibleRepository.deleteById(aEncontrado.getIdCombustible());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
