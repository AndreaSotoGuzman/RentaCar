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
import autos.rentacar.demo.model.TransmisionModel;
import autos.rentacar.demo.repository.TransmisionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
   private TransmisionRepository transmisionRepository;
    

  @GetMapping()
    public Iterable<TransmisionModel> listarTodos() {
        
        return transmisionRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<TransmisionModel> muestraUnaTransmision(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            TransmisionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editaArriendo(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        
         Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TransmisionModel aEncontrado = aOptional.get();  
            
            transmisionEditar.setIdTransmision(aEncontrado.getIdTransmision());
                                
            transmisionRepository.save(transmisionEditar);           
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarTransmision(@RequestBody TransmisionModel nuevoTransmision) {
        
      nuevoTransmision = transmisionRepository.save(nuevoTransmision);
        
      Optional<TransmisionModel> aOptional = transmisionRepository.findById(nuevoTransmision.getIdTransmision());      
        if (aOptional.isPresent()) {            
            TransmisionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TransmisionModel aEncontrado = aOptional.get();
            
            transmisionRepository.deleteById(aEncontrado.getIdTransmision());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
