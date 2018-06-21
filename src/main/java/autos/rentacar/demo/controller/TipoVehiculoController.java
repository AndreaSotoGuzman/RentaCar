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
import org.springframework.http.HttpStatus;

/**
 *
 * @author Andreita
 */
@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController {
    
    @GetMapping()
    public List<TipoVehiculoModel> list() {
        
        return TipoVehiculoModel.tipoVehiculo;
    }
    
    @GetMapping("/{id}")
    public TipoVehiculoModel get(@PathVariable String id) {
        TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
        
        
        return tipoVehiculo.buscaTipoVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVehiculoEditar) {
         TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
         
        
        return new ResponseEntity<>(tipoVehiculo.editarTipoVehiculo(Integer.parseInt(id), tipoVehiculoEditar), HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
         TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
         if(tipoVehiculo.nuevoTipoVehiculo(nuevoTipoVehiculo)){
             return new ResponseEntity<>(HttpStatus.CREATED);
             
         }else{
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
         
         if(tipoVehiculo.eliminarTipoVehiculo(Integer.parseInt(id))){
              return new ResponseEntity<>(HttpStatus.OK);
         }else{
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
         }
       
    }
    
}
