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
import autos.rentacar.demo.model.RegionModel;
import autos.rentacar.demo.repository.RegionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/region")
public class RegionController {
    
  
   @Autowired
   private RegionRepository regionRepository;
    

  @GetMapping()
    public Iterable<RegionModel> listarTodos() {
        
        return regionRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<RegionModel> muestraUnaRegion(@PathVariable String id) {
        
        Optional<RegionModel> aOptional = regionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            RegionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> editaRegion(@PathVariable String id, @RequestBody RegionModel regionEditar) {
        
         Optional<RegionModel> aOptional = regionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
          RegionModel aEncontrado = aOptional.get();  
            
            regionEditar.setIdRegion(aEncontrado.getIdRegion());
                                
            regionRepository.save(regionEditar);           
            return new ResponseEntity<>(regionEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarRegion(@RequestBody RegionModel nuevoRegion) {
        
      nuevoRegion = regionRepository.save(nuevoRegion);
        
      Optional<RegionModel> aOptional = regionRepository.findById(nuevoRegion.getIdRegion());      
        if (aOptional.isPresent()) {            
            RegionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<RegionModel> aOptional = regionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           RegionModel aEncontrado = aOptional.get();
            
            regionRepository.deleteById(aEncontrado.getIdRegion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
