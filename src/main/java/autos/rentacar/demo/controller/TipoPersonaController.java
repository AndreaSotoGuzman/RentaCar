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
import autos.rentacar.demo.model.TipoPersonaModel;
import autos.rentacar.demo.repository.TipoPersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/tipoPersona")
public class TipoPersonaController {
    
  @Autowired
   private TipoPersonaRepository tipoPersonaRepository;
    

  @GetMapping()
    public Iterable<TipoPersonaModel> listarTodos() {
        
        return tipoPersonaRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<TipoPersonaModel> muestraUnTipoPersona(@PathVariable String id) {
        
        Optional<TipoPersonaModel> aOptional = tipoPersonaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            TipoPersonaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editaTipoPersona(@PathVariable String id, @RequestBody TipoPersonaModel tipoPersonaEditar) {
        
         Optional<TipoPersonaModel> aOptional = tipoPersonaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TipoPersonaModel aEncontrado = aOptional.get();  
            
           tipoPersonaEditar.setIdTipoPersona(aEncontrado.getIdTipoPersona());
                                
            tipoPersonaRepository.save( tipoPersonaEditar);           
            return new ResponseEntity<>( tipoPersonaEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarTipoPersona(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        
      nuevoTipoPersona = tipoPersonaRepository.save(nuevoTipoPersona);
        
      Optional<TipoPersonaModel> aOptional = tipoPersonaRepository.findById(nuevoTipoPersona.getIdTipoPersona());      
        if (aOptional.isPresent()) {            
            TipoPersonaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoPersonaModel> aOptional = tipoPersonaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TipoPersonaModel aEncontrado = aOptional.get();
            
            tipoPersonaRepository.deleteById(aEncontrado.getIdTipoPersona());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
