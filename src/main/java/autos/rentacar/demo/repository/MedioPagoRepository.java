/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.repository;

import org.springframework.data.repository.CrudRepository;
import autos.rentacar.demo.model.MedioPagoModel;

/**
 *
 * @author Andreita
 */
public interface MedioPagoRepository extends CrudRepository<MedioPagoModel, Integer> {
    
}
