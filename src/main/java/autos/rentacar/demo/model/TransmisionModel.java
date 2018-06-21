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
public class TransmisionModel {

    private int idTransmision;
    private String nombreTransmision;
    private String detalle;

    public static ArrayList<TransmisionModel> transmision = new ArrayList<>();

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TransmisionModel() {
    }

    public TransmisionModel(String nombreTransmision, String detalle) {
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

    private TransmisionModel(int idTransmision, String nombreTransmision, String detalle) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

    public boolean nuevoTransmision(TransmisionModel nuevoTransmision) { //void no tiene retorno

        int id = 0;

        if (!transmision.isEmpty()) {
            for (TransmisionModel a : transmision) {

                if (a.getIdTransmision() > id) {
                    id = a.getIdTransmision();

                }
            }
        }
        id++;
        transmision.add(new TransmisionModel(id, nuevoTransmision.getNombreTransmision(), nuevoTransmision.getDetalle()));
        return true;

    }

    public TransmisionModel buscaTransmision(int idTransmisionBuscar) { // función necesita un retorno

        TransmisionModel transmisionEncontrado = null;
        if (!transmision.isEmpty()) {
            for (TransmisionModel a : transmision) {

                if (a.getIdTransmision() == idTransmisionBuscar) {
                    transmisionEncontrado = a;

                }

            }

        }
        return transmisionEncontrado;
    }

    public TransmisionModel editarTransmision(int idTransmision, TransmisionModel transmisionEditar) {

        TransmisionModel transmisionEditado = null;
        if (!transmision.isEmpty()) {
            for (TransmisionModel a : transmision) {

                if (a.getIdTransmision() == idTransmision) {
                    a.setNombreTransmision(transmisionEditar.getNombreTransmision());
                    a.setDetalle(transmisionEditar.getDetalle());

                    transmisionEditado = a;
                }

            }

        }
        return transmisionEditado;
    }

    public boolean eliminarTransmision(int id) {

        TransmisionModel transmisionEliminado = null;

        if (!transmision.isEmpty()) {
            for (TransmisionModel a : transmision) {

                if (a.getIdTransmision() == id) {
                    transmisionEliminado = a;

                }

            }
        }
        transmision.remove(transmisionEliminado);
        return true;

    }

}
