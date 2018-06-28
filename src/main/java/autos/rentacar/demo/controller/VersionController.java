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
import autos.rentacar.demo.model.VersionModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
    @Autowired
   private VersionRepository versionRepository;
    

  @GetMapping()
    public Iterable<VersionModel> listarTodos() {
        
        return versionRepository.findAll();
    }

   @GetMapping()
    public ResponseEntity<VersionModel> muestraUnaVersion(@PathVariable String id) {
        
        Optional<VersionModel> aOptional = versionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
            VersionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionModel> editaVersion(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        
         Optional<VersionModel> aOptional = versionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           VersionModel aEncontrado = aOptional.get();  
            
            versionEditar.setIdVersion(aEncontrado.getIdVersion());
                                
            versionRepository.save(versionEditar);           
            return new ResponseEntity<>(versionEditar, HttpStatus.OK);
            
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
     @PostMapping
    public ResponseEntity<?> agregarVersion(@RequestBody VersionModel nuevoVersion) {
        
      nuevoVersion = versionRepository.save(nuevoVersion);
        
      Optional<VersionModel> aOptional = versionRepository.findById(nuevoVersion.getIdVersion());      
        if (aOptional.isPresent()) {            
            VersionModel aEncontrado = aOptional.get();            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{       
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
      
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<VersionModel> aOptional = versionRepository.findById(Integer.parseInt(id));      
        if (aOptional.isPresent()) {            
           VersionModel aEncontrado = aOptional.get();
            
            versionRepository.deleteById(aEncontrado.getIdVersion());
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else{ 
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }

}
    
}
