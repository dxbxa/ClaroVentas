/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package CapaLogica;

import java.util.Date;
/**
 *
 * @author david.barrantes
 */
public class Contacto_Inbound {
    String ID;
    Date Fecha;
    String Telefono;
    String Nombre;
    String Producto;
    String Detalle;
    Integer Renta;
    String Comentario;
    String Resultado;
    
    public Contacto_Inbound(String pID,Date pFecha,String pTelefono,String pNombre,String pProducto,String pDetalle,Integer pRenta,String pComentario,String pResultado){
    ID=pID;
    Fecha=pFecha;
    Telefono=pTelefono;
    Nombre=pNombre;
    Producto=pProducto;
    Detalle=pDetalle;
    Renta=pRenta;
    Comentario=pComentario;
    Resultado=pResultado;
    }
    
    public void set_Fecha(Date pFecha){
        Fecha=pFecha;
    }
    public void set_Telefono(String pTelefono){
        Telefono=pTelefono;
    }
    public void set_Nombre(String pNombre){
        Nombre=pNombre;
    }
    public void set_Producto(String pProducto){
        Producto=pProducto;
    }
    public void set_Detalle(String pDetalle){
        Detalle=pDetalle;
    }
    public void set_Renta(Integer pRenta){
        Renta=pRenta;
    }
    public void set_Comentario(String pComentario){
        Comentario=pComentario;
    }
    public void set_Resultado(String pResultado){
        Resultado=pResultado;
    }    
    public String  get_ID(){
        return ID;
    }
    public Date    get_Fecha(){
        return Fecha;
    }
    public String  get_Telefono(){
        return Telefono;
    }
    public String  get_Nombre(){
        return Nombre;
    }
    public String  get_Producto(){
        return Producto;
    }
    public String  get_Detalle(){
        return Detalle;
    }
    public Integer get_Renta(){
        return Renta;
    }
    public String  get_Comentario(){
        return Comentario;
    }
    public String  get_Resultado(){
        return Resultado;
    }

}
