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
import autos.rentacar.demo.model.MarcaModel;
import autos.rentacar.demo.repository.MarcaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
   @Autowired
   private MarcaRepository marcaRepository;
    

  @GetMapping()
    public Iterable<MarcaModel> listarTodos() {
        
        return marcaRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> muestraUnMarca(@PathVariable String id) {
        
        Optional<MarcaModel> aOptional = marcaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            MarcaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editaMarca(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        
         Optional<MarcaModel> aOptional = marcaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           MarcaModel aEncontrado = aOptional.get();  
            
            marcaEditar.setIdMarca(aEncontrado.getIdMarca());
                                
            marcaRepository.save(marcaEditar);           
            return new ResponseEntity<>(marcaEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarMarca(@RequestBody MarcaModel nuevoMarca) {
        
      nuevoMarca = marcaRepository.save(nuevoMarca);
        
      Optional<MarcaModel> aOptional = marcaRepository.findById(nuevoMarca.getIdMarca());      
        if (aOptional.isPresent()) {            
            MarcaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MarcaModel> aOptional = marcaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           MarcaModel aEncontrado = aOptional.get();
            
            marcaRepository.deleteById(aEncontrado.getIdMarca());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
}
