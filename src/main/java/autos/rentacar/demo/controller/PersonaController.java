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
import autos.rentacar.demo.model.PersonaModel;
import autos.rentacar.demo.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
  
   @Autowired
   private PersonaRepository personaRepository;
    

  @GetMapping()
    public Iterable<PersonaModel> listarTodos() {
        
        return personaRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<PersonaModel> muestraUnaPersona(@PathVariable String id) {
        
        Optional<PersonaModel> aOptional = personaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            PersonaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> editaPersona(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        
         Optional<PersonaModel> aOptional = personaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           PersonaModel aEncontrado = aOptional.get();  
            
            personaEditar.setIdPersona(aEncontrado.getIdPersona());
                                
            personaRepository.save(personaEditar);           
            return new ResponseEntity<>(personaEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaModel nuevoPersona) {
        
      nuevoPersona = personaRepository.save(nuevoPersona);
        
      Optional<PersonaModel> aOptional = personaRepository.findById(nuevoPersona.getIdPersona());      
        if (aOptional.isPresent()) {            
            PersonaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<PersonaModel> aOptional = personaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           PersonaModel aEncontrado = aOptional.get();
            
            personaRepository.deleteById(aEncontrado.getIdPersona());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
}
