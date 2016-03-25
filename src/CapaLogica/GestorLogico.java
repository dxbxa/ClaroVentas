/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaLogica;

import CapaVisual.*;
import CapaBD.ConexionBD;
import java.util.Date;

/**
 *
 * @author david.barrantes
 */
public class GestorLogico {

    VLogin Ventana_Login;
    VInBound Ventana_Inbound;
    VOutBound Ventana_Outbound;
    VAdministrar Ventana_VAdministrar;
    VVenta Ventana_Venta;
    VVentaProducto Ventana_Venta_Producto;
    VVentaDTH Ventana_DTH;
    VVentaMovil Ventana_Movil;
    VentaGeneral ventaGeneral;
    VentaDTH ventaDTH;
    VentaMovil ventaMovil;
    ConexionBD objCnx=new ConexionBD();
    public String [] Usuario;

    public String[] getUsuario() {
        return Usuario;
    }

    public void setUsuario(String[] Usuario) {
        this.Usuario = Usuario;
    }
    
    
    public static void main(String[] args) {
        
        GestorLogico GL_Principal=new GestorLogico();
        GL_Principal.Inicio(GL_Principal);
        
    }
    
    public VentaGeneral VentaGene(String procencia, String NombreCliente, int Cedula, Date fechaVencCedula, String Asesor, Date fechaNacimiento, String estadoCivil, int telMovil, int telFijo, int telTrabajo, String provincia, String canton, String distrito, String direccionCLiente, String cantonEntrega, String direccionEntrega, double montoOrden, String referenciaLaboral, int telReferenciaLaboral, String parentescoLaboral, String nomRefFamiliar, int telRefFamiliar, String parentescoFamiliar, String cantonRefFamiliar, String nomRefPersonal, int telRefPersonal, String parentescoRefPersonal, String cantonRefPersonal, String procedenciaVenta, String requisitosPoliticas, String producto, Date fechaEntrega, String horarioEntrega, String comentariosVenta, Boolean regalia){
        return ventaGeneral = new VentaGeneral(procencia, NombreCliente, Cedula, fechaVencCedula, Asesor, fechaNacimiento, estadoCivil, telMovil, telFijo, telTrabajo, provincia, canton, distrito, direccionCLiente, cantonEntrega, direccionEntrega, montoOrden, referenciaLaboral, telReferenciaLaboral, parentescoLaboral, nomRefFamiliar, telRefFamiliar, parentescoFamiliar, cantonRefFamiliar, nomRefPersonal, telRefPersonal, parentescoRefPersonal, cantonRefPersonal, procedenciaVenta, requisitosPoliticas, producto, fechaEntrega, horarioEntrega, comentariosVenta, regalia);
    }
    
    public VentaDTH VentaDTH(String numeroBurro, String anticipo, String dondeFirmaInstala, String tipoProducto, double rentaPagar, String adicionales, String esquemaContratacionA, String esquemaContratacionB, String esquemaContratacionC){
        return ventaDTH = new VentaDTH(numeroBurro, anticipo, dondeFirmaInstala, tipoProducto, rentaPagar, adicionales, esquemaContratacionA, esquemaContratacionB, esquemaContratacionC);
    }
    
    public VentaMovil VentaMovil(String NomEmpresaTrab, String distritoTrabaja, String direccionTrabaja, double montoOrdenPatrol, String modeloTelefono, String tipoSim, String planPropuesto, String paqueteMinutos, String paqueteSms, String paqueteDatos, boolean clienteExiste, String segmentacion, double montoSubsidio, double rentaAnterior, double rentaActual, String formaPago, String sinFronteras, String informacionTarjeta, String tipoVenta){
        return ventaMovil = new VentaMovil(NomEmpresaTrab, distritoTrabaja, direccionTrabaja, montoOrdenPatrol, modeloTelefono, tipoSim, planPropuesto, paqueteMinutos, paqueteSms, paqueteDatos, clienteExiste, segmentacion, montoSubsidio, rentaAnterior, rentaActual, formaPago, sinFronteras, informacionTarjeta, tipoVenta);
    }
    
    public void Inicio(GestorLogico pPrincipal){
        Ventana_Login = new VLogin(pPrincipal);
        Ventana_Login.setVisible(true);
    }
    public void LogIn(String pID,String pClave)throws Exception{
        Usuario = objCnx.Login(pID,pClave);
    }
    public void VInbound(GestorLogico pGLPrincipal){
        Ventana_Inbound = new VInBound(pGLPrincipal);
        Ventana_Inbound.setVisible(true);
        Ventana_Login.setVisible(false);
        
    }
    public void VOutbound(GestorLogico pGLPrincipal){

        Ventana_Outbound = new VOutBound(pGLPrincipal);
        Ventana_Outbound.setVisible(true);
        Ventana_Login.setVisible(false);

        
    }
    public void Regresar_Inbound(){
        Ventana_Login.setVisible(true);
        Ventana_Inbound.setVisible(false);
    }
    public void Regresar_Outbound(){
        Ventana_Login.setVisible(true);
        Ventana_Login.oculta_Loading();
        Ventana_Outbound.setVisible(false);
    }
    public String[][] consulta_Inbound_x_cedula (String pcedula)throws Exception{
        
        return objCnx.Buscar_Inbound_x_ID(pcedula);
        
    }
    
    public String[] consulta_OutBound (String pNombre,String pTelefono,String pBase)throws Exception{
        
        return objCnx.Cliente_OutBound( pNombre, pTelefono, pBase);
        
    }
    
    public String[][] consulta_Inbound_x_usuario (String pUsuario)throws Exception{
        
        return objCnx.Buscar_Inbound_Todos(pUsuario);
        
    }
    
    public String[][] consulta_Outbound_Asignado (String pUsuario)throws Exception{
        
        return objCnx.Buscar_Outbound_Todos(pUsuario);
        
    }
    
    public String[][] Buscar_Outbound_Historial(String pNombre, String pTelefono)throws Exception{
        
        return objCnx.Buscar_Outbound_Historial(pNombre, pTelefono);
    }
    
    public String[][] consulta_Outbound_Criterio (String pCriterio, String pValor, String pUsuario)throws Exception{
        
        return objCnx.Buscar_Outbound_x_Criterio(pCriterio,pValor, pUsuario);
        
    }
    public void Insertar_Inbound(String pCliente,String ptelefono, String pnombre, String pproducto, String pdetalle, Integer prenta, String pcomentario, String presultado)throws Exception{
           
        objCnx.Insertar_Inbound(pCliente, Usuario[0], ptelefono, pnombre, pproducto, pdetalle, prenta, pcomentario, presultado);
    }
    public void Insertar_Outbound(String pID_Contacto,String pNombre_Contacto,String pTelefono,String pNombre_Base,
            String pIdentificador1_Nombre,String pIdentificador1_Contenido,String pIdentificador2_Nombre,
            String pIdentificador2_Contenido,String pIdentificador3_Nombre,String pIdentificador3_Contenido,
            String pIdentificador4_Nombre,String pIdentificador4_Contenido,String pIdentificador5_Nombre,
            String pIdentificador5_Contenido,String pIdentificador6_Nombre,String pIdentificador6_Contenido,
            String pIdentificador7_Nombre,String pIdentificador7_Contenido,String pIdentificador8_Nombre,
            String pIdentificador8_Contenido,String pIdentificador9_Nombre,String pIdentificador9_Contenido,
            String pStatus,String pID_Usuario_Asignado,String pComentario,String pResultado,String pID_Usuario_Gestion)throws Exception{
           
        objCnx.Insertar_Outbound( pID_Contacto, pNombre_Contacto, pTelefono, pNombre_Base,
             pIdentificador1_Nombre, pIdentificador1_Contenido, pIdentificador2_Nombre,
             pIdentificador2_Contenido, pIdentificador3_Nombre, pIdentificador3_Contenido,
             pIdentificador4_Nombre, pIdentificador4_Contenido, pIdentificador5_Nombre,
             pIdentificador5_Contenido, pIdentificador6_Nombre, pIdentificador6_Contenido,
             pIdentificador7_Nombre, pIdentificador7_Contenido, pIdentificador8_Nombre,
             pIdentificador8_Contenido, pIdentificador9_Nombre, pIdentificador9_Contenido,
             pStatus, pID_Usuario_Asignado, pComentario, pResultado, pID_Usuario_Gestion);
    }
    
    
    public boolean Validar_privilegios(){
        if(Usuario[4].equals("ADMINISTRATIVO")){
            return true;
        }else{
            return false;
        }
    }
    
    
    public String[] Bases ()throws Exception{
        return objCnx.Distict_Bases();
    }
    public String[] Fechas ()throws Exception{
        return objCnx.Distict_Fechas();
    }
    public String[] Asesores ()throws Exception{
        return objCnx.Distict_Asesores();
    }
    
    public String Contar_borrar(String pFecha,String pBase,String pAsesor)throws Exception{
        return objCnx.Distict_Contar( pFecha, pBase, pAsesor);
    }
    
    public void borrar_base (String pFecha,String pBase,String pAsesor)throws Exception{
        objCnx.Borrar_Base(pFecha, pBase, pAsesor);
    }
    
    public void VAdministrar(GestorLogico pGLPrincipal){
        Ventana_VAdministrar = new VAdministrar(pGLPrincipal);
        Ventana_VAdministrar.setVisible(true);
        Ventana_Login.setVisible(false);
        
    }
    public void Insertar_Venta (
   String pAsesor, String pProducto, String pCedula_Cliente, String pNombre_Cliente, String pEstado_Civil, 
   String pTelefono_Cliente, String pProvincia, String pCanton, String pDistrito, String pDireccion, String pProcedencia, 
   String pProducto_Contratado, String pTipo_Renta, int pMnto_Renta, String pRenta_Anterior, String pForma_Pago, String pTarjeta, 
   String pAnticipo_opcion, String pAnticipo_Monto, String pR_Orden, String pR_Ced, String pR_EstadosCta, String pR_Recibo, 
   String pR_Pasaporte, String pReferencia1_Nombre, String pReferencia1_Telefono, String pReferencia1_Parentesco, String pReferencia2_Nombre, 
   String pReferencia2_Telefono, String pReferencia2_Parentesco,String pBase
    )throws Exception{
        
        objCnx.Insertar_Venta(pAsesor, pProducto, pCedula_Cliente, pNombre_Cliente, pEstado_Civil, pTelefono_Cliente, pProvincia, pCanton, pDistrito, pDireccion, pProcedencia, pProducto_Contratado, pTipo_Renta, pMnto_Renta, pRenta_Anterior, pForma_Pago, pTarjeta, pAnticipo_opcion, pAnticipo_Monto, pR_Orden, pR_Ced, pR_EstadosCta, pR_Recibo, pR_Pasaporte, pReferencia1_Nombre, pReferencia1_Telefono, pReferencia1_Parentesco, pReferencia2_Nombre, pReferencia2_Telefono, pReferencia2_Parentesco,pBase);
    }
    public void VVenta(GestorLogico pGLPrincipal, int pPadre,String pcedula,String pnombre,String ptelefono,int pproc ,int renta,String pBase){
        Ventana_Venta = new VVenta(pGLPrincipal,pPadre, pcedula, pnombre, ptelefono, pproc , renta, pBase);
        Ventana_Venta.setVisible(true);
        switch (pPadre) {
            case 1:  Ventana_Login.setVisible(false);
                     break;
            case 2:  Ventana_Outbound.setVisible(false);
                     break;
            case 3:  Ventana_Inbound.setVisible(false);
                     break;
        } 
    }
    
    public void VVentaProducto(GestorLogico pGLPrincipal, int pPadre,String pcedula,String pnombre,String ptelefono,int pproc ,int renta,String pBase){
        Ventana_Venta_Producto = new VVentaProducto(pGLPrincipal,pPadre);
        Ventana_Venta_Producto.setVisible(true);
        switch (pPadre) {
            case 1:  Ventana_Login.setVisible(false);
                     break;
            case 2:  Ventana_Outbound.setVisible(false);
                     break;
            case 3:  Ventana_Inbound.setVisible(false);
                     break;
        }
    }
    
    public void VVentaDTH(GestorLogico pGLPrincipal, int pPadre, VentaGeneral vg){
        Ventana_DTH = new VVentaDTH(pGLPrincipal,pPadre,vg);
        Ventana_DTH.setVisible(true);
        switch (pPadre) {
            case 1:  Ventana_Venta_Producto.setVisible(false);
                     break;
        }
    }
    
    public void VVentaMovil(GestorLogico pGLPrincipal, int pPadre, VentaGeneral vg){
        Ventana_Movil = new VVentaMovil(pGLPrincipal,pPadre,vg);
        Ventana_Movil.setVisible(true);
        switch (pPadre) {
            case 1:  Ventana_Venta_Producto.setVisible(false);
                     break;
        }
    }
    
    public void Regresar_DTH(int pPadre){
        Ventana_DTH.setVisible(false);
        switch (pPadre) {
            case 1:  Ventana_Login.setVisible(true);
                     break;
        }
        
        
    }
    
       public void Regresar_Movil(int pPadre){
        Ventana_Movil.setVisible(false);
        switch (pPadre) {
            case 1:  Ventana_Login.setVisible(true);
                     break;
        }
        
        
    }
    
    public void Regresar_Venta(int pPadre){
        Ventana_Venta.setVisible(false);
        switch (pPadre) {
            case 1:  Ventana_Login.setVisible(true);
                     break;
            case 2:  Ventana_Outbound.setVisible(true);
                     break;
            case 3:  Ventana_Inbound.setVisible(true);
                     break;
        }
        
        
    }
    
    public String[][] Traer_Venta (String pAsesor)throws Exception{
        
        return objCnx.Traer_Ventas(pAsesor);
        
    }
    
    public String[][] Traer_Venta_B (String cedula)throws Exception{
        
        return objCnx.Traer_Ventas_deTodos(cedula);
        
    }
    public void Regresar_Administrativo(){
        Ventana_Login.setVisible(true);
        Ventana_Login.oculta_Loading();
        Ventana_VAdministrar.setVisible(false);
    }
public String[][] Todas_Ventas_Admin ()throws Exception{
        
        return objCnx.Todas_Ventas_Admin();
        
    }

public String[][] Todas_Ventas_Criterio (String criterio, String valor)throws Exception{
        
        return objCnx.Todas_Ventas_Criterio(criterio, valor);
        
}
public void Insertar_Actualización_Venta(
String Usuario,
String pcod_Venta,
String plogistica_comentario,
String pStatus, 
String pContrato, 
String pResponsable, 
String pNombre_terminal, 
String pSIM, 
String pComentario_Adicional, 
String pFirma_Instala, 
int Monto_Recibido, 
String IMEI,

String Producto, 
String Cedula_Cliente,
 String Nombre_Cliente,
 String Estado_Civil, 
String Telefono_Cliente, 
String Provincia,
 String Canton, 
String Distrito,
 String Direccion, 
 String Procedencia, 
String Producto_Contratado, 
String Tipo_Renta, 
String Mnto_Renta, 
String Renta_Anterior, 
String Forma_Pago,
 String Tarjeta, 
String Anticipo_opcion,
 String Anticipo_Monto, 
String Referencia1_Nombre,
 String Referencia1_Telefono,
 String Referencia1_Parentesco,
 String Referencia2_Nombre,
 String Referencia2_Telefono,
 String Referencia2_Parentesco)
            throws Exception{
    
    objCnx.Insertar_Actualización_Venta(Usuario, pcod_Venta, plogistica_comentario, pStatus, pContrato, pResponsable, pNombre_terminal, pSIM, pComentario_Adicional, pFirma_Instala, Monto_Recibido, IMEI, Producto, Cedula_Cliente, Nombre_Cliente, Estado_Civil, Telefono_Cliente, Provincia, Canton, Distrito, Direccion, Procedencia, Producto_Contratado, Tipo_Renta, Mnto_Renta, Renta_Anterior, Forma_Pago, Tarjeta, Anticipo_opcion, Anticipo_Monto, Referencia1_Nombre, Referencia1_Telefono, Referencia1_Parentesco, Referencia2_Nombre, Referencia2_Telefono, Referencia2_Parentesco);
}
public String Historico(String pventa)throws Exception{
    
    String [][] datos=objCnx.Historico(pventa);
    String resultado="";
    
    for(int r=0;r<datos.length;r++){
        for(int c=0;c<datos[0].length;c++){
            resultado=resultado+"-"+datos[r][c];
        }
        resultado=resultado+"\n";
    }
    
    return resultado;
    
    
}
public void insertar_usuario(String ID,String nombre,String clave,String correo,String rol)throws Exception{
    objCnx.crear_usuario(ID, nombre, clave, correo, rol);
}
}
