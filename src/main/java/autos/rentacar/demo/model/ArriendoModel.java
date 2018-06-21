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
public class ArriendoModel {

    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    private PersonaModel vendedor;
    private PersonaModel cliente;
    private VehiculoModel vehiculo;
    private MedioPagoModel medioPago;

    public static ArrayList<ArriendoModel> arriendo = new ArrayList<>();

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time gethoraArriendo() {
        return horaArriendo;
    }

    public void sethoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public PersonaModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonaModel vendedor) {
        this.vendedor = vendedor;
    }

    public PersonaModel getCliente() {
        return cliente;
    }

    public void setCliente(PersonaModel cliente) {
        this.cliente = cliente;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MedioPagoModel getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPagoModel medioPago) {
        this.medioPago = medioPago;
    }

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    private ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    public boolean nuevoArriendo(ArriendoModel nuevoArriendo) { //void no tiene retorno

        int id = 0;

        if (!arriendo.isEmpty()) {
            for (ArriendoModel a : arriendo) {

                if (a.getIdArriendo() > id) {
                    id = a.getIdArriendo();

                }
            }
        }
        id++;
        arriendo.add(new ArriendoModel(id, nuevoArriendo.getFechaArriendo(), nuevoArriendo.gethoraArriendo(), nuevoArriendo.getVendedor(), nuevoArriendo.getCliente(), nuevoArriendo.getVehiculo(), nuevoArriendo.getMedioPago()));
        return true;

    }

    public ArriendoModel buscaArriendo(int idArriendoBuscar) { // función necesita un retorno

        ArriendoModel arriendoEncontrado = null;
        if (!arriendo.isEmpty()) {
            for (ArriendoModel a : arriendo) {

                if (a.getIdArriendo() == idArriendoBuscar) {
                    arriendoEncontrado = a;

                }

            }

        }
        return arriendoEncontrado;
    }

    public ArriendoModel editarArriendo(int idArriendo, ArriendoModel arriendoEditar) {

        ArriendoModel arriendoEditado = null;
        if (!arriendo.isEmpty()) {
            for (ArriendoModel a : arriendo) {

                if (a.getIdArriendo() == idArriendo) {

                    a.setFechaArriendo(arriendoEditar.getFechaArriendo());
                    a.sethoraArriendo(arriendoEditar.gethoraArriendo());
                    a.setVendedor(arriendoEditar.getVendedor());
                    a.setCliente(arriendoEditar.getCliente());
                    a.setVehiculo(arriendoEditar.getVehiculo());
                    a.setMedioPago(arriendoEditar.getMedioPago());

                    arriendoEditado = a;
                }

            }

        }
        return arriendoEditado;
    }

    public boolean elimnarArriendo(int id) {

        ArriendoModel arriendoEliminado = null;

        if (!arriendo.isEmpty()) {
            for (ArriendoModel a : arriendo) {

                if (a.getIdArriendo() == id) {
                    arriendoEliminado = a;

                }

            }
        }
        arriendo.remove(arriendoEliminado);
        return true;

    }

}
