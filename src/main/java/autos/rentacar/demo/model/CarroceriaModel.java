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
public class CarroceriaModel {

    private int idCarroceria;
    private String nombreCarroceria;
    private String detalle;

    public static ArrayList<CarroceriaModel> carroceria = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    public boolean nuevoCarroceria(CarroceriaModel nuevoCarroceria) { //void no tiene retorno

        int id = 0;

        if (!carroceria.isEmpty()) {
            for (CarroceriaModel a : carroceria) {

                if (a.getIdCarroceria() > id) {
                    id = a.getIdCarroceria();

                }
            }
        }
        id++;
        carroceria.add(new CarroceriaModel(id, nuevoCarroceria.getNombreCarroceria(), nuevoCarroceria.getDetalle()));
        return true;

    }

    public CarroceriaModel buscaCarroceria(int idCarroceriaBuscar) { // función necesita un retorno

        CarroceriaModel carroceriaEncontrado = null;
        if (!carroceria.isEmpty()) {
            for (CarroceriaModel a : carroceria) {

                if (a.getIdCarroceria() == idCarroceriaBuscar) {
                    carroceriaEncontrado = a;

                }

            }

        }
        return carroceriaEncontrado;
    }

    public CarroceriaModel editarCarroceria(int idCarroceria, CarroceriaModel carroceriaEditar) {

        CarroceriaModel carroceriaEditado = null;
        if (!carroceria.isEmpty()) {
            for (CarroceriaModel a : carroceria) {

                if (a.getIdCarroceria() == idCarroceria) {
                    a.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                    a.setDetalle(carroceriaEditar.getDetalle());

                    carroceriaEditado = a;
                }

            }

        }
        return carroceriaEditado;
    }

    public boolean eliminarCarroceria(int id) {

        CarroceriaModel carroceriaEliminado = null;

        if (!carroceria.isEmpty()) {
            for (CarroceriaModel a : carroceria) {

                if (a.getIdCarroceria() == id) {
                    carroceriaEliminado = a;

                }

            }
        }
        carroceria.remove(carroceriaEliminado);
        return true;

    }

}
