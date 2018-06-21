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
public class MedioPagoModel {
    
  private  int idMedioPago;
  private  String nombreMedioPago;
  private  String detalle;
    
    public static ArrayList<MedioPagoModel> medioPago = new ArrayList<>();
    
    
    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }
    
    
   public boolean nuevoMedioPago(MedioPagoModel nuevoMedioPago){ //void no tiene retorno
        
        int id = 0;
        
        if(!medioPago.isEmpty()){
            for (MedioPagoModel a : medioPago) {
                
                if(a.getIdMedioPago()>id){
                    id = a.getIdMedioPago();
                    
                }
            }
        }
        id++;
       medioPago.add(new MedioPagoModel(id, nuevoMedioPago.getNombreMedioPago(), nuevoMedioPago.getDetalle()));
        return true;
        
    }
    
    public MedioPagoModel buscaMedioPago(int idMedioPagoBuscar){ // función necesita un retorno
        
        MedioPagoModel medioPagoEncontrado = null;
        if(!medioPago.isEmpty()){
            for (MedioPagoModel a : medioPago) {
                
             if(a.getIdMedioPago()== idMedioPagoBuscar) {
                medioPagoEncontrado = a;
                 
             }  
                
            }
            
        }
        return medioPagoEncontrado;
    }
    
    public MedioPagoModel editarMedioPago(int idMedioPago, MedioPagoModel medioPagoEditar){
        
        
        MedioPagoModel medioPagoEditado = null;
        if(!medioPago.isEmpty()){
            for (MedioPagoModel a : medioPago) {
                
             if(a.getIdMedioPago()== idMedioPago) {
                 a.setNombreMedioPago(medioPagoEditar.getNombreMedioPago());
                 a.setDetalle(medioPagoEditar.getDetalle());
                 
                 medioPagoEditado = a;
             }  
                
            }
            
        }
        return  medioPagoEditado;
    }
    
    public boolean eliminarMedioPago (int id){
      
   MedioPagoModel medioPagoEliminado = null;
        
          if(!medioPago.isEmpty()){
            for ( MedioPagoModel a :medioPago) {
                
             if(a.getIdMedioPago()== id) {
                 medioPagoEliminado = a;
                 
             }  
                
            }
    }
         
          medioPago.remove(medioPagoEliminado);
          return true;
    
}
}
