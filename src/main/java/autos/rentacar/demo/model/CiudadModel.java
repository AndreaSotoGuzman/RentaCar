/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.model;

import java.util.ArrayList;

/**
 *
 * @author Andreita
 */
public class CiudadModel {

    private int idCiudad;
    private String nombreCiudad;
    private String detalle;
    private RegionModel region;

    public static ArrayList<CiudadModel> ciudad = new ArrayList<>();

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

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String detalle, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    public boolean nuevoCiudad(CiudadModel nuevoCiudad) { //void no tiene retorno

        int id = 0;

        if (!ciudad.isEmpty()) {
            for (CiudadModel a : ciudad) {

                if (a.getIdCiudad() > id) {
                    id = a.getIdCiudad();

                }
            }
        }
        id++;
        ciudad.add(new CiudadModel(id, nuevoCiudad.getNombreCiudad(), nuevoCiudad.getDetalle(), nuevoCiudad.getRegion()));
        return true;

    }

    public CiudadModel buscaCiudad(int idCiudad) { // función necesita un retorno

        CiudadModel ciudadEncontrado = null;
        if (!ciudad.isEmpty()) {
            for (CiudadModel a : ciudad) {

                if (a.getIdCiudad() == idCiudad) {
                    ciudadEncontrado = a;

                }

            }

        }
        return ciudadEncontrado;
    }

    public CiudadModel editarCiudad(int idCiudad, CiudadModel ciudadEditar) {

        CiudadModel ciudadEditado = null;
        if (!ciudad.isEmpty()) {
            for (CiudadModel a : ciudad) {

                if (a.getIdCiudad() == idCiudad) {
                    a.setNombreCiudad(ciudadEditar.getNombreCiudad());
                    a.setDetalle(ciudadEditar.getDetalle());
                    a.setRegion(ciudadEditar.getRegion());
                    ciudadEditado = a;
                }

            }

        }
        return ciudadEditado;
    }

    public boolean eliminarCiudad(int id) {

        CiudadModel ciudadEliminado = null;

        if (!ciudad.isEmpty()) {
            for (CiudadModel a : ciudad) {

                if (a.getIdCiudad() == id) {
                    ciudadEliminado = a;

                }

            }
        }

        ciudad.remove(ciudadEliminado);
        return true;

    }

}
