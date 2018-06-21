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
import org.springframework.http.HttpStatus;
/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @GetMapping()
    public List<ModeloModel> list() {
        
        
        return ModeloModel.modelo;
    }
    
    @GetMapping("/{id}")
    public ModeloModel get(@PathVariable String id) {
          
        ModeloModel modelo = new ModeloModel();
        return modelo.buscaModelo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody ModeloModel editarModelo) {
         ModeloModel modelo = new ModeloModel();
        
        return new ResponseEntity<>(modelo.editarModelo(Integer.parseInt(id), editarModelo), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody  ModeloModel nuevoModelo) {
         ModeloModel modelo = new ModeloModel();
         
         if(modelo.nuevoModelo(modelo)){
              return new ResponseEntity<>(HttpStatus.CREATED);
         }else{
             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         ModeloModel modelo = new ModeloModel();
         
         if(modelo.elimnarModelo(Integer.parseInt(id))){
             return new ResponseEntity<>(HttpStatus.OK);
         }else{
             return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
      
    }
    
}
