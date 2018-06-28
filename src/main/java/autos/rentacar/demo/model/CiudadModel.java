/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.model;

import java.util.ArrayList;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andreita
 */
public class CiudadModel {

    private int idCiudad;
    private String nombreCiudad;
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private RegionModel region;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel(String nombreCiudad, String detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    public CiudadModel() {
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String detalle, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

  
}
