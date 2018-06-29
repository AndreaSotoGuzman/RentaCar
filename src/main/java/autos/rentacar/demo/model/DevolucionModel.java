/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





/**
 *
 * @author Andreita
 */
@Entity
@Table(name="devolucion")
public class DevolucionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevolucion;
    private Date fechaDevolucion;
    
    
    @ManyToOne
    @JoinColumn(name="id_arriendo")
    private ArriendoModel arriendo;

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public ArriendoModel getArriendo() {
        return arriendo;
    }

    public void setArriendo(ArriendoModel arriendo) {
        this.arriendo = arriendo;
    }

    public DevolucionModel(Date fechaDevolucion, ArriendoModel arriendo) {
        this.fechaDevolucion = fechaDevolucion;
        this.arriendo = arriendo;
    }

    public DevolucionModel() {
    }

    public DevolucionModel(int idDevolucion, Date fechaDevolucion, ArriendoModel arriendo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.arriendo = arriendo;
    }

   
    

   
}
