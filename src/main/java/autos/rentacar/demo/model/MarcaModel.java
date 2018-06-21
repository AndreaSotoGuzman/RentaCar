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
public class MarcaModel {
    
    
   private int idMarca;
   private String nombreMarca;
   private String detalle;
    
    public static ArrayList<MarcaModel>marca=new ArrayList<>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    private MarcaModel(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }
    
    
       
    public boolean nuevoMarca(MarcaModel nuevoMarca){ //void no tiene retorno
        
        int id = 0;
        
        if(!marca.isEmpty()){
            for (MarcaModel a : marca) {
                
                if(a.getIdMarca()>id){
                    id = a.getIdMarca();
                    
                }
            }
        }
        id++;
        marca.add(new MarcaModel(id, nuevoMarca.getNombreMarca(), nuevoMarca.getDetalle()));
        return true;
        
    }
    
    public MarcaModel buscaMarca(int idMarcaBuscar){ // función necesita un retorno
        
        MarcaModel marcaEncontrado = null;
        if(!marca.isEmpty()){
            for (MarcaModel a : marca) {
                
             if(a.getIdMarca()== idMarcaBuscar) {
                 marcaEncontrado = a;
                 
             }  
                
            }
            
        }
        return marcaEncontrado;
    }
    
    public MarcaModel editarMarca(int idMarca, MarcaModel marcaEditar){
        
        
        MarcaModel marcaEditado = null;
        if(!marca.isEmpty()){
            for (MarcaModel a : marca) {
                
             if(a.getIdMarca()== idMarca) {
                 a.setNombreMarca(marcaEditar.getNombreMarca());
                 a.setDetalle(marcaEditar.getDetalle());
                 
                 marcaEditado = a;
             }  
                
            }
            
        }
        return  marcaEditado;
    }
    
    public boolean eliminarMarca (int id){
      
   MarcaModel marcaEliminado = null;
        
          if(!marca.isEmpty()){
            for ( MarcaModel a : marca) {
                
             if(a.getIdMarca()== id) {
                 marcaEliminado = a;
                 
             }  
                
            }
    }
         
          marca.remove(marcaEliminado);
          return true;
    
}
    

    
    
    
}
