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
import autos.rentacar.demo.model.TraccionModel;
import autos.rentacar.demo.repository.TraccionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @Autowired
   private TraccionRepository traccionRepository;
    

  @GetMapping()
    public Iterable<TraccionModel> listarTodos() {
        
        return traccionRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> muestraUnaTraccion(@PathVariable String id) {
        
        Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            TraccionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> editaTraccion(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
         Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TraccionModel aEncontrado = aOptional.get();  
            
            traccionEditar.setIdTraccion(aEncontrado.getIdTraccion());
                                
            traccionRepository.save(traccionEditar);           
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarTraccion(@RequestBody TraccionModel nuevoTraccion) {
        
      nuevoTraccion = traccionRepository.save(nuevoTraccion);
        
      Optional<TraccionModel> aOptional = traccionRepository.findById(nuevoTraccion.getIdTraccion());      
        if (aOptional.isPresent()) {            
            TraccionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TraccionModel aEncontrado = aOptional.get();
            
            traccionRepository.deleteById(aEncontrado.getIdTraccion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
