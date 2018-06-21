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
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @GetMapping()
    public List<TransmisionModel> list() {
        
        return TransmisionModel.transmision;
    }
    
    @GetMapping("/{id}")
    public TransmisionModel get(@PathVariable String id) {
        TransmisionModel transmision = new TransmisionModel();
        
        return transmision.buscaTransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
         TransmisionModel transmision = new TransmisionModel();
         
        return new ResponseEntity<>(transmision.editarTransmision(Integer.parseInt(id), transmisionEditar), HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody  TransmisionModel nuevoTransmision) {
         TransmisionModel transmision = new TransmisionModel();
         if(transmision.nuevoTransmision(nuevoTransmision)){
             return new ResponseEntity<>(HttpStatus.CREATED);
         }else{
             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         TransmisionModel transmision = new TransmisionModel();
         
         if(transmision.eliminarTransmision(Integer.parseInt(id))){
              return new ResponseEntity<>(HttpStatus.OK);
         }else{
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
       
    }
    
}
