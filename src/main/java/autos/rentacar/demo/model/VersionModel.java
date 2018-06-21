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
public class VersionModel {

    private int idVersion;
    private String nombre;
    private String detalle;
    private int puertas;
    private int pasajeros;
    private float cilindrada;
    private float redimiento;
    private int capacidadMaletero;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierreCentralizado;
    private boolean alzaVidriosElectricos;
    private boolean camaraRetroceso;
    private CombustibleModel combustible;
    private CarroceriaModel carroceria;
    private TransmisionModel transmision;
    private TraccionModel traccion;
    private ModeloModel modelo;

    public static ArrayList<VersionModel> version = new ArrayList<>();

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getRedimiento() {
        return redimiento;
    }

    public void setRedimiento(float redimiento) {
        this.redimiento = redimiento;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }

    public boolean isAlzaVidriosElectricos() {
        return alzaVidriosElectricos;
    }

    public void setAlzaVidriosElectricos(boolean alzaVidriosElectricos) {
        this.alzaVidriosElectricos = alzaVidriosElectricos;
    }

    public boolean isCamaraRetroceso() {
        return camaraRetroceso;
    }

    public void setCamaraRetroceso(boolean camaraRetroceso) {
        this.camaraRetroceso = camaraRetroceso;
    }

    public CombustibleModel getCombustible() {
        return combustible;
    }

    public void setCombustible(CombustibleModel combustible) {
        this.combustible = combustible;
    }

    public CarroceriaModel getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(CarroceriaModel carroceria) {
        this.carroceria = carroceria;
    }

    public TransmisionModel getTransmision() {
        return transmision;
    }

    public void setTransmision(TransmisionModel transmision) {
        this.transmision = transmision;
    }

    public TraccionModel getTraccion() {
        return traccion;
    }

    public void setTraccion(TraccionModel traccion) {
        this.traccion = traccion;
    }

    public ModeloModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloModel modelo) {
        this.modelo = modelo;
    }

    public VersionModel() {
    }

    public VersionModel(String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float redimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.redimiento = redimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    private VersionModel(int idVersion, String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float redimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.idVersion = idVersion;
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.redimiento = redimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    public boolean nuevoVersion(VersionModel nuevoVersion) { //void no tiene retorno

        int id = 0;

        if (!version.isEmpty()) {
            for (VersionModel a : version) {

                if (a.getIdVersion() > id) {
                    id = a.getIdVersion();

                }
            }
        }
        id++;
        version.add(new VersionModel(id, nuevoVersion.getNombre(), nuevoVersion.getDetalle(), nuevoVersion.getPuertas(), nuevoVersion.getPasajeros(), nuevoVersion.getCilindrada(), nuevoVersion.getRedimiento(), nuevoVersion.getCapacidadMaletero(), nuevoVersion.getAirbags(), nuevoVersion.isAireAcondicionado(), nuevoVersion.isCierreCentralizado(), nuevoVersion.isAlzaVidriosElectricos(), nuevoVersion.isCamaraRetroceso(), nuevoVersion.getCombustible(), nuevoVersion.getCarroceria(), nuevoVersion.getTransmision(), nuevoVersion.getTraccion(), nuevoVersion.getModelo()));
        return true;

    }

    public VersionModel buscaVersion(int idVersionBuscar) { // función necesita un retorno

        VersionModel versionEncontrado = null;
        if (!version.isEmpty()) {
            for (VersionModel a : version) {

                if (a.getIdVersion() == idVersionBuscar) {
                    versionEncontrado = a;

                }

            }

        }
        return versionEncontrado;
    }

    public VersionModel editarVersion(int idVersion, VersionModel versionEditar) {

        VersionModel versionEditado = null;
        if (!version.isEmpty()) {
            for (VersionModel a : version) {

                if (a.getIdVersion() == idVersion) {
                    a.setNombre(versionEditar.getNombre());
                    a.setDetalle(versionEditar.getDetalle());
                    a.setPuertas(versionEditar.getPuertas());
                    a.setPasajeros(versionEditar.getPasajeros());
                    a.setCilindrada(versionEditar.getCilindrada());
                    a.setRedimiento(versionEditar.getRedimiento());
                    a.setCapacidadMaletero(versionEditar.getCapacidadMaletero());
                    a.setAirbags(versionEditar.getAirbags());
                    a.setAireAcondicionado(versionEditar.isAireAcondicionado());
                    a.setCierreCentralizado(versionEditar.isCierreCentralizado());
                    a.setAlzaVidriosElectricos(versionEditar.isAlzaVidriosElectricos());
                    a.setCamaraRetroceso(versionEditar.isCamaraRetroceso());
                    a.setCombustible(versionEditar.getCombustible());
                    a.setCarroceria(versionEditar.getCarroceria());
                    a.setTransmision(versionEditar.getTransmision());
                    a.setTraccion(versionEditar.getTraccion());
                    a.setModelo(versionEditar.getModelo());

                    versionEditado = a;
                }

            }

        }
        return versionEditado;
    }

    public boolean elimnarVersion(int id) {

        VersionModel versionEliminado = null;

        if (!version.isEmpty()) {
            for (VersionModel a : version) {

                if (a.getIdVersion() == id) {
                    versionEliminado = a;

                }

            }
        }
        version.remove(versionEliminado);
        return true;

    }

}
