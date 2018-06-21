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
public class TraccionModel {

    private int idTraccion;
    private String nombreTraccion;
    private String detalle;

    public static ArrayList<TraccionModel> traccion = new ArrayList<>();

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String detalle) {
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

    private TraccionModel(int idTraccion, String nombreTraccion, String detalle) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

    public boolean nuevoTraccion(TraccionModel nuevoTraccion) { //void no tiene retorno

        int id = 0;

        if (!traccion.isEmpty()) {
            for (TraccionModel a : traccion) {

                if (a.getIdTraccion() > id) {
                    id = a.getIdTraccion();

                }
            }
        }
        id++;
        traccion.add(new TraccionModel(id, nuevoTraccion.getNombreTraccion(), nuevoTraccion.getDetalle()));
        return true;

    }

    public TraccionModel buscaTraccion(int idTraccionBuscar) { // función necesita un retorno

        TraccionModel traccionEncontrado = null;
        if (!traccion.isEmpty()) {
            for (TraccionModel a : traccion) {

                if (a.getIdTraccion() == idTraccionBuscar) {
                    traccionEncontrado = a;

                }

            }

        }
        return traccionEncontrado;
    }

    public TraccionModel editarTraccion(int idTraccion, TraccionModel traccionEditar) {

        TraccionModel traccionEditado = null;
        if (!traccion.isEmpty()) {
            for (TraccionModel a : traccion) {

                if (a.getIdTraccion() == idTraccion) {
                    a.setNombreTraccion(traccionEditar.getNombreTraccion());
                    a.setDetalle(traccionEditar.getDetalle());

                    traccionEditado = a;
                }

            }

        }
        return traccionEditado;
    }

    public boolean eliminarTraccion(int id) {

        TraccionModel traccionEliminado = null;

        if (!traccion.isEmpty()) {
            for (TraccionModel a : traccion) {

                if (a.getIdTraccion() == id) {
                    traccionEliminado = a;

                }

            }
        }
        traccion.remove(traccionEliminado);
        return true;

    }

}
