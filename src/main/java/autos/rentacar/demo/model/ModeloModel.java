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
public class ModeloModel {

    private int idModelo;
    private String nombreModelo;
    private String detalle;
    private MarcaModel marca;

    public static ArrayList<ModeloModel> modelo = new ArrayList<>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }

    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalle, MarcaModel marca) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    private ModeloModel(int idModelo, String nombreModelo, String detalle, MarcaModel marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    public boolean nuevoModelo(ModeloModel nuevoModelo) { //void no tiene retorno

        int id = 0;

        if (!modelo.isEmpty()) {
            for (ModeloModel a : modelo) {

                if (a.getIdModelo() > id) {
                    id = a.getIdModelo();

                }
            }
        }
        id++;
        modelo.add(new ModeloModel(id, nuevoModelo.getNombreModelo(), nuevoModelo.getDetalle(), nuevoModelo.getMarca()));
        return true;

    }

    public ModeloModel buscaModelo(int idModeloBuscar) { // función necesita un retorno

        ModeloModel modeloEncontrado = null;
        if (!modelo.isEmpty()) {
            for (ModeloModel a : modelo) {

                if (a.getIdModelo() == idModeloBuscar) {
                    modeloEncontrado = a;

                }

            }

        }
        return modeloEncontrado;
    }

    public ModeloModel editarModelo(int idModelo, ModeloModel modeloEditar) {

        ModeloModel modeloEditado = null;
        if (!modelo.isEmpty()) {
            for (ModeloModel a : modelo) {

                if (a.getIdModelo() == idModelo) {
                    a.setNombreModelo(modeloEditar.getNombreModelo());
                    a.setDetalle(modeloEditar.getDetalle());
                    a.setMarca(modeloEditar.getMarca());

                    modeloEditado = a;
                }

            }

        }
        return modeloEditado;
    }

    public boolean elimnarModelo(int id) {

        ModeloModel modeloEliminado = null;

        if (!modelo.isEmpty()) {
            for (ModeloModel a : modelo) {

                if (a.getIdModelo() == id) {
                    modeloEliminado = a;

                }

            }
        }
        modelo.remove(modeloEliminado);
        return true;

    }

}
