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
public class RegionModel {

    private int idRegion;
    private String nombreRegion;
    private String detalle;

    public static ArrayList<RegionModel> region = new ArrayList<>();

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public RegionModel() {
    }

    public RegionModel(String nombreRegion, String detalle) {
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }

    private RegionModel(int idRegion, String nombreRegion, String detalle) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }

    public boolean nuevoRegion(RegionModel nuevoRegion) { //void no tiene retorno

        int id = 0;

        if (!region.isEmpty()) {
            for (RegionModel a : region) {

                if (a.getIdRegion() > id) {
                    id = a.getIdRegion();

                }
            }
        }
        id++;
        region.add(new RegionModel(id, nuevoRegion.getNombreRegion(), nuevoRegion.getDetalle()));
        return true;

    }

    public RegionModel buscaRegion(int idRegionBuscar) { // función necesita un retorno

        RegionModel regionEncontrado = null;
        if (!region.isEmpty()) {
            for (RegionModel a : region) {

                if (a.getIdRegion() == idRegionBuscar) {
                    regionEncontrado = a;

                }

            }

        }
        return regionEncontrado;
    }

    public RegionModel editarRegion(int idRegion, RegionModel regionEditar) {

        RegionModel regionEditado = null;
        if (!region.isEmpty()) {
            for (RegionModel a : region) {

                if (a.getIdRegion() == idRegion) {
                    a.setNombreRegion(regionEditar.getNombreRegion());
                    a.setDetalle(regionEditar.getDetalle());

                    regionEditado = a;
                }

            }

        }
        return regionEditado;
    }

    public boolean eliminarRegion(int id) {

        RegionModel regionEliminado = null;

        if (!region.isEmpty()) {
            for (RegionModel a : region) {

                if (a.getIdRegion() == id) {
                    regionEliminado = a;

                }

            }
        }

        region.remove(regionEliminado);
        return true;

    }

}
