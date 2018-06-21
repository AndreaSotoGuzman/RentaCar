/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autos.rentacar.demo.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Andreita
 */
public class PersonaModel {

    private int idPersona;
    private String run;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String telefono;
    private String direccion1;
    private String direccion2;
    private CiudadModel ciudad;
    private TipoPersonaModel tipoPersona;

    public static ArrayList<PersonaModel> persona = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public TipoPersonaModel getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public PersonaModel() {
    }

    public PersonaModel(String run, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }

    public PersonaModel(int idPersona, String run, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.idPersona = idPersona;
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }

    public boolean nuevoPersona(PersonaModel nuevoPersona) { //void no tiene retorno

        int id = 0;

        if (!persona.isEmpty()) {
            for (PersonaModel a : persona) {

                if (a.getIdPersona() > id) {
                    id = a.getIdPersona();

                }
            }
        }
        id++;
        persona.add(new PersonaModel(id, nuevoPersona.getRun(), nuevoPersona.getNombre(), nuevoPersona.getApellido(), nuevoPersona.getFechaNacimiento(), nuevoPersona.getTelefono(), nuevoPersona.getDireccion1(), nuevoPersona.getDireccion2(), nuevoPersona.getCiudad(), nuevoPersona.getTipoPersona()));
        return true;

    }

    public PersonaModel buscaPersona(int idPersonaBuscar) { // función necesita un retorno

        PersonaModel personaEncontrado = null;
        if (!persona.isEmpty()) {
            for (PersonaModel a : persona) {

                if (a.getIdPersona() == idPersonaBuscar) {
                    personaEncontrado = a;

                }

            }

        }
        return personaEncontrado;
    }

    public PersonaModel editarPersona(int idPersona, PersonaModel personaEditar) {

        PersonaModel personaEditado = null;
        if (!persona.isEmpty()) {
            for (PersonaModel a : persona) {

                if (a.getIdPersona() == idPersona) {
                    a.setRun(personaEditar.getRun());
                    a.setNombre(personaEditar.getNombre());
                    a.setApellido(personaEditar.getApellido());
                    a.setFechaNacimiento(personaEditar.getFechaNacimiento());
                    a.setTelefono(personaEditar.getTelefono());
                    a.setDireccion1(personaEditar.getDireccion1());
                    a.setDireccion2(personaEditar.getDireccion2());
                    a.setCiudad(personaEditar.getCiudad());
                    a.setTipoPersona(personaEditar.getTipoPersona());

                    personaEditado = a;
                }

            }

        }
        return personaEditado;
    }

    public boolean elimnarPersona(int id) {

        PersonaModel personaEliminado = null;

        if (!persona.isEmpty()) {
            for (PersonaModel a : persona) {

                if (a.getIdPersona() == id) {
                    personaEliminado = a;

                }

            }
        }
        persona.remove(personaEliminado);
        return true;

    }

}
