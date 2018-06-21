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
public class VehiculoModel {

    private int idVehiculo;
    private String patente;
    private int valor;
    private int año;
    private String color;
    private TipoVehiculoModel tipoVehiculo;
    private VersionModel version;

    public static ArrayList<VehiculoModel> vehiculo = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    public VehiculoModel(int idVehiculo, String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    public boolean nuevoVehiculo(VehiculoModel nuevoVehiculo) { //void no tiene retorno

        int id = 0;

        if (!vehiculo.isEmpty()) {
            for (VehiculoModel a : vehiculo) {

                if (a.getIdVehiculo() > id) {
                    id = a.getIdVehiculo();

                }
            }
        }
        id++;
        vehiculo.add(new VehiculoModel(id, nuevoVehiculo.getPatente(), nuevoVehiculo.getValor(), nuevoVehiculo.getAño(), nuevoVehiculo.getColor(), nuevoVehiculo.getTipoVehiculo(), nuevoVehiculo.getVersion()));
        return true;

    }

    public VehiculoModel buscaVehiculo(int idVehiculoBuscar) { // función necesita un retorno

        VehiculoModel vehiculoEncontrado = null;
        if (!vehiculo.isEmpty()) {
            for (VehiculoModel a : vehiculo) {

                if (a.getIdVehiculo() == idVehiculoBuscar) {
                    vehiculoEncontrado = a;

                }

            }

        }
        return vehiculoEncontrado;
    }

    public VehiculoModel editarVehiculo(int idVehiculo, VehiculoModel vehiculoEditar) {

        VehiculoModel vehiculoEditado = null;
        if (!vehiculo.isEmpty()) {
            for (VehiculoModel a : vehiculo) {

                if (a.getIdVehiculo() == idVehiculo) {
                    a.setPatente(vehiculoEditar.getPatente());
                    a.setValor(vehiculoEditar.getValor());
                    a.setAño(vehiculoEditar.getAño());
                    a.setColor(vehiculoEditar.getColor());
                    a.setTipoVehiculo(vehiculoEditar.getTipoVehiculo());
                    a.setVersion(vehiculoEditar.getVersion());

                    vehiculoEditado = a;
                }

            }

        }
        return vehiculoEditado;
    }

    public boolean elimnarVehiculo(int id) {

        VehiculoModel vehiculoEliminado = null;

        if (!vehiculo.isEmpty()) {
            for (VehiculoModel a : vehiculo) {

                if (a.getIdVehiculo() == id) {
                    vehiculoEliminado = a;

                }

            }
        }
        vehiculo.remove(vehiculoEliminado);
        return true;

    }

}
