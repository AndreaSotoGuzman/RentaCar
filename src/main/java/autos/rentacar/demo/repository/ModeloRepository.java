/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import autos.rentacar.demo.model.ModeloModel;

/**
 *
 * @author Andreita
 */
public interface ModeloRepository extends CrudRepository<ModeloModel, Integer> {
    
}
