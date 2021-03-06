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
import autos.rentacar.demo.model.VehiculoModel;
import autos.rentacar.demo.repository.VehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @Autowired
   private  VehiculoRepository  vehiculoRepository;
    

  @GetMapping()
    public Iterable< VehiculoModel> listarTodos() {
        
        return  vehiculoRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity< VehiculoModel> muestraUnVehiculo(@PathVariable String id) {
        
        Optional< VehiculoModel> aOptional =  vehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
             VehiculoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity< VehiculoModel> editaVehiculo(@PathVariable String id, @RequestBody  VehiculoModel  vehiculoEditar) {
        
         Optional< VehiculoModel> aOptional =  vehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            VehiculoModel aEncontrado = aOptional.get();  
            
             vehiculoEditar.setIdVehiculo(aEncontrado.getIdVehiculo());
                                
             vehiculoRepository.save( vehiculoEditar);           
            return new ResponseEntity<>( vehiculoEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarVehiculo(@RequestBody  VehiculoModel nuevoVehiculo) {
        
      nuevoVehiculo =  vehiculoRepository.save(nuevoVehiculo);
        
      Optional< VehiculoModel> aOptional =  vehiculoRepository.findById(nuevoVehiculo.getIdVehiculo());      
        if (aOptional.isPresent()) {            
             VehiculoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional< VehiculoModel> aOptional =  vehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            VehiculoModel aEncontrado = aOptional.get();
            
             vehiculoRepository.deleteById(aEncontrado.getIdVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
