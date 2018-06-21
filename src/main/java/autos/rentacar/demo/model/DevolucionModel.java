/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.model;

import java.util.ArrayList;
import java.util.Date;
import org.apache.tomcat.jni.Time;




/**
 *
 * @author Andreita
 */
public class DevolucionModel {

    private int idDevolucion;
    private Date fechaDevolucion;
    private Time horaDevolucion;
    private ArriendoModel arriendo;

    public static ArrayList<DevolucionModel> devolucion = new ArrayList<>();

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Time getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public ArriendoModel getArriendo() {
        return arriendo;
    }

    public void setArriendo(ArriendoModel arriendo) {
        this.arriendo = arriendo;
    }

    public DevolucionModel() {
    }

    public DevolucionModel(Date fechaDevolucion, Time horaDevolucion, ArriendoModel arriendo) {
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

    private DevolucionModel(int idDevolucion, Date fechaDevolucion, Time horaDevolucion, ArriendoModel arriendo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

    public boolean nuevoDevolucion(DevolucionModel nuevoDevolucion) { //void no tiene retorno

        int id = 0;

        if (!devolucion.isEmpty()) {
            for (DevolucionModel a : devolucion) {

                if (a.getIdDevolucion() > id) {
                    id = a.getIdDevolucion();

                }
            }
        }
        id++;
        devolucion.add(new DevolucionModel(id, nuevoDevolucion.getFechaDevolucion(), nuevoDevolucion.getHoraDevolucion(), nuevoDevolucion.getArriendo()));
        return true;

    }

    public DevolucionModel buscaDevolucion(int idDevolucionBuscar) { // función necesita un retorno

        DevolucionModel devolucionEncontrado = null;
        if (!devolucion.isEmpty()) {
            for (DevolucionModel a : devolucion) {

                if (a.getIdDevolucion() == idDevolucionBuscar) {
                    devolucionEncontrado = a;

                }

            }

        }
        return devolucionEncontrado;
    }

    public DevolucionModel editarDevolucion(int idDevolucion, DevolucionModel devolucionEditar) {

        DevolucionModel devolucionEditado = null;
        if (!devolucion.isEmpty()) {
            for (DevolucionModel a : devolucion) {

                if (a.getIdDevolucion() == idDevolucion) {

                    a.setFechaDevolucion(devolucionEditar.getFechaDevolucion());
                    a.setHoraDevolucion(devolucionEditar.getHoraDevolucion());
                    a.setArriendo(devolucionEditar.getArriendo());

                    devolucionEditado = a;
                }

            }

        }
        return devolucionEditado;
    }

    public boolean elimnarDevolucion(int id) {

        DevolucionModel devolucionEliminado = null;

        if (!devolucion.isEmpty()) {
            for (DevolucionModel a : devolucion) {

                if (a.getIdDevolucion() == id) {
                    devolucionEliminado = a;

                }

            }
        }
        devolucion.remove(devolucionEliminado);
        return true;

    }
}
