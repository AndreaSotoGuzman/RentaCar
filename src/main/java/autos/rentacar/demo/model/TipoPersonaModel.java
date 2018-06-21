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
public class TipoPersonaModel {

    private int idPersona;
    private String nombreTipoPersona;
    private String detalle;

    public static ArrayList<TipoPersonaModel> tipoPersona = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    private TipoPersonaModel(int idPersona, String nombreTipoPersona, String detalle) {
        this.idPersona = idPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    public boolean nuevoTipoPersona(TipoPersonaModel nuevoTipoPersona) { //void no tiene retorno

        int id = 0;

        if (!tipoPersona.isEmpty()) {
            for (TipoPersonaModel a : tipoPersona) {

                if (a.getIdPersona() > id) {
                    id = a.getIdPersona();

                }
            }
        }
        id++;
        tipoPersona.add(new TipoPersonaModel(id, nuevoTipoPersona.getNombreTipoPersona(), nuevoTipoPersona.getDetalle()));
        return true;

    }

    public TipoPersonaModel buscaTipoPersona(int idTipoPersonaBuscar) { // función necesita un retorno

        TipoPersonaModel tipoPersonaEncontrado = null;
        if (!tipoPersona.isEmpty()) {
            for (TipoPersonaModel a : tipoPersona) {

                if (a.getIdPersona() == idTipoPersonaBuscar) {
                    tipoPersonaEncontrado = a;

                }

            }

        }
        return tipoPersonaEncontrado;
    }

    public TipoPersonaModel editarTipoPersona(int idTipoPersona, TipoPersonaModel tipoPersonaEditar) {

        TipoPersonaModel tipoPersonaEditado = null;
        if (!tipoPersona.isEmpty()) {
            for (TipoPersonaModel a : tipoPersona) {

                if (a.getIdPersona() == idTipoPersona) {
                    a.setNombreTipoPersona(tipoPersonaEditar.getNombreTipoPersona());
                    a.setDetalle(tipoPersonaEditar.getDetalle());

                    tipoPersonaEditado = a;
                }

            }

        }
        return tipoPersonaEditado;
    }

    public boolean eliminarTipoPersona(int id) {

        TipoPersonaModel tipoPersonaEliminado = null;

        if (!tipoPersona.isEmpty()) {
            for (TipoPersonaModel a : tipoPersona) {

                if (a.getIdPersona() == id) {
                    tipoPersonaEliminado = a;

                }

            }
        }

        tipoPersona.remove(tipoPersonaEliminado);
        return true;

    }
}
