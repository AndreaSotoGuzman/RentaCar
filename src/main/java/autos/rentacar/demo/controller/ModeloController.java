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
import autos.rentacar.demo.model.ModeloModel;
import autos.rentacar.demo.repository.ModeloRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
   @Autowired
   private ModeloRepository modeloRepository;
    

  @GetMapping()
    public Iterable<ModeloModel> listarTodos() {
        
        return modeloRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<ModeloModel> muestraUnModelo(@PathVariable String id) {
        
        Optional<ModeloModel> aOptional = modeloRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            ModeloModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> editaModelo(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
        
         Optional<ModeloModel> aOptional = modeloRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           ModeloModel aEncontrado = aOptional.get();  
            
            modeloEditar.setIdModelo(aEncontrado.getIdModelo());
                                
            modeloRepository.save(modeloEditar);           
            return new ResponseEntity<>(modeloEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarModelo(@RequestBody ModeloModel nuevoModelo) {
        
      nuevoModelo = modeloRepository.save(nuevoModelo);
        
      Optional<ModeloModel> aOptional = modeloRepository.findById(nuevoModelo.getIdModelo());      
        if (aOptional.isPresent()) {            
            ModeloModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<ModeloModel> aOptional = modeloRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
          ModeloModel aEncontrado = aOptional.get();
            
            modeloRepository.deleteById(aEncontrado.getIdModelo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

    
}
}