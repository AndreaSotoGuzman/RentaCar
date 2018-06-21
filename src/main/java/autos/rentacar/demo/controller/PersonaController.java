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
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @GetMapping()
    public List<PersonaModel> list() {
        
        
        return PersonaModel.persona;
    }
    
    @GetMapping("/{id}")
    public PersonaModel get(@PathVariable String id) {
        
        PersonaModel persona = new PersonaModel();
        
        return persona.buscaPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody PersonaModel editarPersona) {
        PersonaModel persona = new PersonaModel();
        
        return new ResponseEntity<>(persona.editarPersona(Integer.parseInt(id), editarPersona), HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevoPersona) {
        
        PersonaModel persona = new PersonaModel();
        if(persona.nuevoPersona(nuevoPersona)){
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
       
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         PersonaModel persona = new PersonaModel();
         if(persona.elimnarPersona(Integer.parseInt(id))){
              return new ResponseEntity<>(HttpStatus.OK);
         }else{
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
        
        
    }
    
}
