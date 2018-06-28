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
import autos.rentacar.demo.model.CarroceriaModel;
import autos.rentacar.demo.repository.CarroceriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {

   @Autowired
   private CarroceriaRepository carroceriaRepository;
    

  @GetMapping()
    public Iterable<CarroceriaModel> listarTodos() {
        
        return carroceriaRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<CarroceriaModel> muestraUnaCarroceria(@PathVariable String id) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            CarroceriaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editaCarroceria(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        
         Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CarroceriaModel aEncontrado = aOptional.get();  
            
            carroceriaEditar.setIdCarroceria(aEncontrado.getIdCarroceria());
                                
            carroceriaRepository.save(carroceriaEditar);           
            return new ResponseEntity<>(carroceriaEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody CarroceriaModel nuevoArriendo) {
        
      nuevoArriendo = carroceriaRepository.save(nuevoArriendo);
        
      Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(nuevoArriendo.getIdCarroceria());      
        if (aOptional.isPresent()) {            
            CarroceriaModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           CarroceriaModel aEncontrado = aOptional.get();
            
            carroceriaRepository.deleteById(aEncontrado.getIdCarroceria());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
}
