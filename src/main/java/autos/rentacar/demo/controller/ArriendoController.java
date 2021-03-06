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
import autos.rentacar.demo.model.ArriendoModel;
import autos.rentacar.demo.repository.ArriendoRepository;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {

   @Autowired
   private ArriendoRepository arriendoRepository;
    

  @GetMapping()
    public Iterable<ArriendoModel> listarTodos() {
        
        return arriendoRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<ArriendoModel> muestraUnArriendo(@PathVariable String id) {
        
        Optional<ArriendoModel> aOptional = arriendoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            ArriendoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArriendoModel> editaArriendo(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
        
         Optional<ArriendoModel> aOptional = arriendoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           ArriendoModel aEncontrado = aOptional.get();  
            
            arriendoEditar.setIdArriendo(aEncontrado.getIdArriendo());
                                
            arriendoRepository.save(arriendoEditar);           
            return new ResponseEntity<>(arriendoEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody ArriendoModel nuevoArriendo) {
        
      nuevoArriendo = arriendoRepository.save(nuevoArriendo);
        
      Optional<ArriendoModel> aOptional = arriendoRepository.findById(nuevoArriendo.getIdArriendo());      
        if (aOptional.isPresent()) {            
            ArriendoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<ArriendoModel> aOptional = arriendoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           ArriendoModel aEncontrado = aOptional.get();
            
            arriendoRepository.deleteById(aEncontrado.getIdArriendo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
}