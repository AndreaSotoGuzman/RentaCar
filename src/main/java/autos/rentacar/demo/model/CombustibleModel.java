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
public class CombustibleModel {

    private int idCombustible;
    private String tipoCombustible;
    private String detalle;

    public static ArrayList<CombustibleModel> combustible = new ArrayList<>();

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String tipoCombustible, String detalle) {
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    private CombustibleModel(int idCombustible, String tipoCombustible, String detalle) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalle = detalle;
    }

    public boolean nuevoCombustible(CombustibleModel nuevoCombustible) { //void no tiene retorno

        int id = 0;

        if (!combustible.isEmpty()) {
            for (CombustibleModel a : combustible) {

                if (a.getIdCombustible() > id) {
                    id = a.getIdCombustible();

                }
            }
        }
        id++;
        combustible.add(new CombustibleModel(id, nuevoCombustible.getTipoCombustible(), nuevoCombustible.getDetalle()));
        return true;

    }

    public CombustibleModel buscaCombustible(int idCombustibleBuscar) { // función necesita un retorno

        CombustibleModel combustibleEncontrado = null;
        if (!combustible.isEmpty()) {
            for (CombustibleModel a : combustible) {

                if (a.getIdCombustible() == idCombustibleBuscar) {
                    combustibleEncontrado = a;

                }

            }

        }
        return combustibleEncontrado;
    }

    public CombustibleModel editarCombustible(int idCombustible, CombustibleModel combustibleEditar) {

        CombustibleModel combustibleEditado = null;
        if (!combustible.isEmpty()) {
            for (CombustibleModel a : combustible) {

                if (a.getIdCombustible() == idCombustible) {
                    a.setTipoCombustible(combustibleEditar.getTipoCombustible());
                    a.setDetalle(combustibleEditar.getDetalle());

                    combustibleEditado = a;
                }

            }

        }
        return combustibleEditado;
    }

    public boolean eliminarCombustible(int id) {

        CombustibleModel combustibleEliminado = null;

        if (!combustible.isEmpty()) {
            for (CombustibleModel a : combustible) {

                if (a.getIdCombustible() == id) {
                    combustibleEliminado = a;

                }

            }
        }
        combustible.remove(combustibleEliminado);
        return true;

    }

}
