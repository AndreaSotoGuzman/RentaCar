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
import autos.rentacar.demo.model.DevolucionModel;
import autos.rentacar.demo.repository.DevolucionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @Autowired
   private DevolucionRepository devolucionRepository;
    

  @GetMapping()
    public Iterable<DevolucionModel> listarTodos() {
        
        return devolucionRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<DevolucionModel> muestraUnaDevolucion(@PathVariable String id) {
        
        Optional<DevolucionModel> aOptional = devolucionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            DevolucionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> editaDevolucion(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
        
         Optional<DevolucionModel> aOptional = devolucionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           DevolucionModel aEncontrado = aOptional.get();  
            
            devolucionEditar.setIdDevolucion(aEncontrado.getIdDevolucion());
                                
            devolucionRepository.save(devolucionEditar);           
            return new ResponseEntity<>(devolucionEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarDevolucion(@RequestBody DevolucionModel nuevoDevolucion) {
        
      nuevoDevolucion = devolucionRepository.save(nuevoDevolucion);
        
      Optional<DevolucionModel> aOptional = devolucionRepository.findById(nuevoDevolucion.getIdDevolucion());      
        if (aOptional.isPresent()) {            
            DevolucionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<DevolucionModel> aOptional = devolucionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           DevolucionModel aEncontrado = aOptional.get();
            
            devolucionRepository.deleteById(aEncontrado.getIdDevolucion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
