/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaLogica;

/**
 *
 * @author david.barrantes
 */


public class Usuario {
    String ID;
    String Nombre;
    String Clave;
    String Correo;
    String Proyecto;
    
    public Usuario(String pID, String pNombre, String pClave,String pCorreo,String pProyecto){
    ID=pID;
    Nombre=pNombre;
    Clave=pClave;
    Correo=pCorreo;
    Proyecto=pProyecto;
    }
    
    public void set_Nombre(String pNombre){
        Nombre=pNombre;
    }
    public void set_Clave(String pClave){
        Clave=pClave;
    }
    public void set_Correo(String pCorreo){
        Correo=pCorreo;
    }
    public void set_Proyecto(String pProyecto){
        Proyecto=pProyecto;
    }    
    public String get_ID(){
        return ID;
    }
    public String get_Nombre(){
        return Nombre;
    }
    public String get_Clave(){
        return Clave;
    }
    public String get_Correo(){
        return Correo;
    }
    public String get_Proyecto(){
        return Proyecto;
    }    
}
