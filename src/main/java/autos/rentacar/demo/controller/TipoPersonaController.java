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
import autos.rentacar.demo.model.TipoPersonaModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/tipoPersona")
public class TipoPersonaController {
    
    @GetMapping()
    public List<TipoPersonaModel> list() {
        return TipoPersonaModel.tipoPersona;
    }
    
    @GetMapping("/{id}")
    public TipoPersonaModel get(@PathVariable String id) {
        
       TipoPersonaModel tipoPersona = new TipoPersonaModel();
       return tipoPersona.buscaTipoPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TipoPersonaModel editarTipoPersona){
         TipoPersonaModel tipoPersona = new TipoPersonaModel();
        return new ResponseEntity<>(tipoPersona.editarTipoPersona(Integer.parseInt(id), editarTipoPersona), HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        
          TipoPersonaModel tipoPersona = new TipoPersonaModel();
          if(tipoPersona.nuevoTipoPersona(nuevoTipoPersona)){
              return new ResponseEntity<>(HttpStatus.CREATED);
              
          }else{
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         TipoPersonaModel tipoPersona = new TipoPersonaModel();
        if(tipoPersona.eliminarTipoPersona(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
