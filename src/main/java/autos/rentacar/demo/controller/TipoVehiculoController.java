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
import autos.rentacar.demo.model.TipoVehiculoModel;
import autos.rentacar.demo.repository.TipoVehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController {
    
    @Autowired
   private TipoVehiculoRepository tipoVehiculoRepository;
    

  @GetMapping()
    public Iterable<TipoVehiculoModel> listarTodos() {
        
        return tipoVehiculoRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> muestraUnTipoVehiculo(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            TipoVehiculoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> editaTipoVehiculo(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVehiculoEditar) {
        
         Optional<TipoVehiculoModel> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TipoVehiculoModel aEncontrado = aOptional.get();  
            
            tipoVehiculoEditar.setIdTipoVehiculo(aEncontrado.getIdTipoVehiculo());
                                
            tipoVehiculoRepository.save(tipoVehiculoEditar);           
            return new ResponseEntity<>(tipoVehiculoEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarTipoVehiculo(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
        
      nuevoTipoVehiculo = tipoVehiculoRepository.save(nuevoTipoVehiculo);
        
      Optional<TipoVehiculoModel> aOptional = tipoVehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());      
        if (aOptional.isPresent()) {            
            TipoVehiculoModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoVehiculoModel> aOptional = tipoVehiculoRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           TipoVehiculoModel aEncontrado = aOptional.get();
            
            tipoVehiculoRepository.deleteById(aEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
