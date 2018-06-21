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
public class TipoVehiculoModel {

    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;

    public static ArrayList<TipoVehiculoModel> tipoVehiculo = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    public boolean nuevoTipoVehiculo(TipoVehiculoModel nuevoTipoVehiculo) { //void no tiene retorno

        int id = 0;

        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel a : tipoVehiculo) {

                if (a.getIdTipoVehiculo() > id) {
                    id = a.getIdTipoVehiculo();

                }
            }
        }
        id++;
        tipoVehiculo.add(new TipoVehiculoModel(id, nuevoTipoVehiculo.getNombreTipoVehiculo(), nuevoTipoVehiculo.getDetalle()));
        return true;

    }

    public TipoVehiculoModel buscaTipoVehiculo(int idTipoVehiculoBuscar) { // función necesita un retorno

        TipoVehiculoModel tipoVehiculoEncontrado = null;
        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel a : tipoVehiculo) {

                if (a.getIdTipoVehiculo() == idTipoVehiculoBuscar) {
                    tipoVehiculoEncontrado = a;

                }

            }

        }
        return tipoVehiculoEncontrado;
    }

    public TipoVehiculoModel editarTipoVehiculo(int idTipoVehiculo, TipoVehiculoModel tipoVehiculoEditar) {

        TipoVehiculoModel tipoVehiculoEditado = null;
        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel a : tipoVehiculo) {

                if (a.getIdTipoVehiculo() == idTipoVehiculo) {
                    a.setNombreTipoVehiculo(tipoVehiculoEditar.getNombreTipoVehiculo());
                    a.setDetalle(tipoVehiculoEditar.getDetalle());

                    tipoVehiculoEditado = a;
                }

            }

        }
        return tipoVehiculoEditado;
    }

    public boolean eliminarTipoVehiculo(int id) {

        TipoVehiculoModel tipoVehiculoEliminado = null;

        if (!tipoVehiculo.isEmpty()) {
            for (TipoVehiculoModel a : tipoVehiculo) {

                if (a.getIdTipoVehiculo() == id) {
                    tipoVehiculoEliminado = a;

                }

            }
        }

        tipoVehiculo.remove(tipoVehiculoEliminado);
        return true;

    }
}
