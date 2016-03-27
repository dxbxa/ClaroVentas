


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaBD;

import CapaLogica.VentaDTH;
import CapaLogica.VentaGeneral;
import CapaLogica.VentaMovil;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author david.barrantes
 */
public class ConexionBD {
    
    public String[] Login(String pID, String pClave)throws Exception{
        
        String query="SELECT "
                + "ID_Usuario,"
                + "Nombre_Usuario,"
                + "Clave_Usuario,"
                + "Correo_Usuario,"
                + "Proyecto_Usuario"
                + " FROM T_Usuario "
                + "WHERE ID_Usuario='"+pID+"' "
                + "AND Clave_Usuario='"+pClave+"';";
        

       String resultado[]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           resultado=new String[columnas];
           try{
             while (rs.next()){
                     resultado[0]=rs.getObject("ID_Usuario").toString();
                     resultado[1]=rs.getObject("Nombre_Usuario").toString();
                     resultado[2]=rs.getObject("Clave_Usuario").toString();
                     resultado[3]=rs.getObject("Correo_Usuario").toString();
                     resultado[4]=rs.getObject("Proyecto_Usuario").toString();

                }
               if(resultado[0]==null){
                   resultado=null;
                   throw new Exception("Usuario Inválido");
               }
           }
           finally { 
                  rs.close(); 
           }
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
       return resultado; 


    }
    
    public void Insertar_Inbound(String pCliente,String pUsuario,String ptelefono, 
            String pnombre, String pproducto, String pdetalle, Integer prenta, 
            String pcomentario, String presultado)
            throws Exception{
        
        String query="INSERT INTO T_Contacto_I values "
                + "('"+pCliente+"',"
                + "SUBTIME(now(),'6:00:00'),"
                + "'"+pUsuario+"',"
                + "'"+ptelefono+"',"
                + "'"+pnombre+"',"
                + "'"+pproducto+"',"
                + "'"+pdetalle+"',"
                + prenta+","
                + "'"+pcomentario+"',"
                + "'"+presultado+"');";

                System.out.println("\n insertar inbound\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }    
    
    public void Insertar_Outbound(String pID_Contacto,String pNombre_Contacto,String pTelefono,String pNombre_Base,
            String pIdentificador1_Nombre,String pIdentificador1_Contenido,String pIdentificador2_Nombre,
            String pIdentificador2_Contenido,String pIdentificador3_Nombre,String pIdentificador3_Contenido,
            String pIdentificador4_Nombre,String pIdentificador4_Contenido,String pIdentificador5_Nombre,
            String pIdentificador5_Contenido,String pIdentificador6_Nombre,String pIdentificador6_Contenido,
            String pIdentificador7_Nombre,String pIdentificador7_Contenido,String pIdentificador8_Nombre,
            String pIdentificador8_Contenido,String pIdentificador9_Nombre,String pIdentificador9_Contenido,
            String pStatus,String pID_Usuario_Asignado,String pComentario,String pResultado,String pID_Usuario_Gestion)
            throws Exception{
        
        String query="INSERT INTO T_Contacto_O values ("
                + "'"+pID_Contacto+"',"
                + "'"+pNombre_Contacto+"',"
                + "'"+pTelefono+"',"
                + "'"+pNombre_Base+"',"
                + "'"+pIdentificador1_Nombre+"',"
                + "'"+pIdentificador1_Contenido+"',"
                + "'"+pIdentificador2_Nombre+"',"
                + "'"+pIdentificador2_Contenido+"',"
                + "'"+pIdentificador3_Nombre+"',"
                + "'"+pIdentificador3_Contenido+"',"
                + "'"+pIdentificador4_Nombre+"',"
                + "'"+pIdentificador4_Contenido+"',"
                + "'"+pIdentificador5_Nombre+"',"
                + "'"+pIdentificador5_Contenido+"',"
                + "'"+pIdentificador6_Nombre+"',"
                + "'"+pIdentificador6_Contenido+"',"
                + "'"+pIdentificador7_Nombre+"',"
                + "'"+pIdentificador7_Contenido+"',"
                + "'"+pIdentificador8_Nombre+"',"
                + "'"+pIdentificador8_Contenido+"',"
                + "'"+pIdentificador9_Nombre+"',"
                + "'"+pIdentificador9_Contenido+"',"
                + "'"+pStatus+"',"
                + "'"+pID_Usuario_Asignado+"',"
                + "SUBTIME(now(),'6:00:00'),"
                + "'"+pComentario+"',"
                + "'"+pResultado+"',"
                + "'"+pID_Usuario_Gestion+"');";
        

                System.out.println("\n insertar out bound\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
           
           query = "delete from \n" +
            "T_Contacto_O\n" +
            "where Nombre_Contacto = '"+pNombre_Contacto+"'\n" +
            "and Fecha_Llamada is null\n" +
            ";";
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    
    public void Insertar_DTH(VentaGeneral vg, VentaDTH vdth)
            throws Exception{
        DateFormat formatter ; 
        formatter = new SimpleDateFormat("dd/mm/yyyy");
        String query="INSERT INTO T_VENTA_NUEVA values ("
        + "'"+formatter.format(vg.getFechaLlamada())+"',"
        + "'"+vg.getAsesor()+"',"
        + "'"+vg.getNombreCliente()+"',"
        + "'"+vg.getCedula()+"',"
        + "'"+formatter.format(vg.getFechaVencCedula())+"',"
        + "'"+formatter.format(vg.getFechaNacimiento())+"',"
        + "'"+vg.getEstadoCivil()+"',"
        + "'"+vg.getTelMovil()+"',"
        + "'"+vg.getTelFijo()+"',"
        + "'"+vg.getTelTrabajo()+"',"
        + "'"+vg.getCorreoElectronico()+"',"
        + "'"+vg.getProvincia()+"',"
        + "'"+vg.getCanton()+"',"
        + "'"+vg.getDistrito()+"',"
        + "'"+vg.getDireccionCLiente()+"',"
        + "'"+vg.getCantonEntrega()+"',"
        + "'"+vg.getDireccionEntrega()+"',"
        + "'"+vg.getMontoOrden()+"',"
        + "'"+vg.getReferenciaLaboral()+"',"
        + "'"+vg.getTelReferenciaLaboral()+"',"
        + "'"+vg.getParentescoLaboral()+"',"
        + "'"+vg.getNomRefFamiliar()+"',"
        + "'"+vg.getTelRefFamiliar()+"',"
        + "'"+vg.getCantonRefFamiliar()+"',"
        + "'"+vg.getParentescoFamiliar()+"',"
        + "'"+vg.getNomRefPersonal()+"',"
        + "'"+vg.getTelRefPersonal()+"',"
        + "'"+vg.getCantonRefPersonal()+"',"
        + "'"+vg.getParentescoRefPersonal()+"',"
        + "'"+vg.getProcedenciaVenta()+"',"
        + "'"+vg.getRequisitosPoliticas()+"',"
        + "'"+vg.getProducto()+"',"
        // Se agrega informacion de Movil
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        //Se agrega informacion de DTH
        + "'"+vdth.getNumeroBurro()+"',"
        + "'"+vdth.getAnticipo()+"',"
        + "'"+vdth.getDondeFirmaInstala()+"',"
        + "'"+vdth.getTipoProducto()+"',"       
        + "'"+vdth.getAdicionales()+"',"
        + "'"+vdth.getEsquemaContratacionA()+"',"
        + "'"+vdth.getEsquemaContratacionB()+"',"
        + "'"+vdth.getEsquemaContratacionC()+"',"
        + "'"+vdth.getRentaPagar()+"',"
        + "'"+null+"',"
        + "'"+null+"',"
        + "'"+null+"',"
        + "'"+null+"',"
        + "'"+null+"',"
        + "'"+formatter.format(vg.getFechaEntrega())+"',"
        + "'"+vg.getHorarioEntrega()+"',"
        + "'"+vg.getComentariosVenta()+"',"
        + "'"+vg.getRegalia()+"',"
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+");";
//        <{NOMBRE_DE_USUARIO: }>,
//        <{RESPONSABLE_VENTAS: }>,
//        <{PENDIENTE_DOCUMENTACION_: }>,
//        <{FECHA_VENTAS: }>,
//        <{COMENTARIO_VENTAS: }>,
//        <{RESPONSABLE_BO: }>,
//        <{STATUS_BO: }>,
//        <{FECHA_BO: }>,
//        <{COMENTARIO_BO: }>,
//        <{CONTRATO: }>,
//        <{FECHA_SUBIDO_A_OPEN: }>,
//        <{FECHA_ACTIVACIÓN: }>,
//        <{CEDULA2: }>,
//        <{SUBIDO_POR: }>,
//        <{RESPONSABLE_LOGISTICA: }>,
//        <{FECHA_DE_ASIGNACION_: }>,
//        <{FECHA_DE_FIRMA: }>,
//        <{MENSAJERO: }>,
//        <{STATUS_LOGISTICA: }>,
//        <{FECHA_ULTIMO_STATUS: }>,
//        <{MENSAJERO_RUTA: }>,
//        <{FECHA_DE_SALIDA_DE_CONTRATO: }>,
//        <{FECHA_DE_REGRESO: }>,
//        <{STATUS_DEL_CONTRATO: }>,
//        <{FECHA_REPROCESO: }>,
//        <{FECHA_REGRESO_DEL_REPROCESO: }>,
//        <{MENSAJERO_REPROCESO: }>,
//        <{COMENTARIO_LOGISTICA: }>,
//        <{RESPONSABLE_CAJAS: }>,
//        <{STATUS_DE_CAJAS: }>,
//        <{FECHA_CAJAS: }>,
//        <{COMENTARIO_CAJAS: }>,
//        <{STATUS_LOGISTICA2: }>);
        

       System.out.println("\n insertar out bound\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public void Insertar_Movil(VentaGeneral vg, VentaMovil vm)
            throws Exception{
        DateFormat formatter ; 
        formatter = new SimpleDateFormat("dd/mm/yyyy");
        String query="INSERT INTO T_VENTA_NUEVA values ("
        + "'"+formatter.format(vg.getFechaLlamada())+"',"
        + "'"+vg.getAsesor()+"',"
        + "'"+vg.getNombreCliente()+"',"
        + "'"+vg.getCedula()+"',"
        + "'"+formatter.format(vg.getFechaVencCedula())+"',"
        + "'"+formatter.format(vg.getFechaNacimiento())+"',"
        + "'"+vg.getEstadoCivil()+"',"
        + "'"+vg.getTelMovil()+"',"
        + "'"+vg.getTelFijo()+"',"
        + "'"+vg.getTelTrabajo()+"',"
        + "'"+vg.getCorreoElectronico()+"',"
        + "'"+vg.getProvincia()+"',"
        + "'"+vg.getCanton()+"',"
        + "'"+vg.getDistrito()+"',"
        + "'"+vg.getDireccionCLiente()+"',"
        + "'"+vg.getCantonEntrega()+"',"
        + "'"+vg.getDireccionEntrega()+"',"
        + "'"+vg.getMontoOrden()+"',"
        + "'"+vg.getReferenciaLaboral()+"',"
        + "'"+vg.getTelReferenciaLaboral()+"',"
        + "'"+vg.getParentescoLaboral()+"',"
        + "'"+vg.getNomRefFamiliar()+"',"
        + "'"+vg.getTelRefFamiliar()+"',"
        + "'"+vg.getCantonRefFamiliar()+"',"
        + "'"+vg.getParentescoFamiliar()+"',"
        + "'"+vg.getNomRefPersonal()+"',"
        + "'"+vg.getTelRefPersonal()+"',"
        + "'"+vg.getCantonRefPersonal()+"',"
        + "'"+vg.getParentescoRefPersonal()+"',"
        + "'"+vg.getProcedenciaVenta()+"',"
        + "'"+vg.getRequisitosPoliticas()+"',"
        + "'"+vg.getProducto()+"',"
        // Se agrega informacion de Movil
        + "'"+vm.getNomEmpresaTrab()+"',"
        + "'"+vm.getDistritoTrabaja()+"',"
        + "'"+vm.getDireccionTrabaja()+"',"
        + "'"+vm.getMontoOrdenPatrol()+"',"
        + "'"+vm.getModeloTelefono()+"',"
        + "'"+vm.getTipoSim()+"',"
        + "'"+vm.getPlanPropuesto()+"',"
        + "'"+vm.getPaqueteMinutos()+"',"
        + "'"+vm.getPaqueteSms()+"',"
        + "'"+vm.getPaqueteDatos()+"',"
        + "'"+vm.getSinFronteras()+"',"
        + "'"+vm.isClienteExiste()+"',"
        + "'"+vm.getSegmentacion()+"',"
        + "'"+vm.getMontoSubsidio()+"',"
        + "'"+vm.getRentaAnterior()+"',"
        + "'"+vm.getRentaActual()+"',"
        + "'"+vm.getFormaPago()+"',"
        + "'"+vm.getInformacionTarjeta()+"',"
        + "'"+vm.getTipoVenta()+"',"
        //Se agrega informacion de DTH
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        + "'"+formatter.format(vg.getFechaEntrega())+"',"
        + "'"+vg.getHorarioEntrega()+"',"
        + "'"+vg.getComentariosVenta()+"',"
        + "'"+vg.getRegalia()+"',"
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+","
        +null+");";
//        <{NOMBRE_DE_USUARIO: }>,
//        <{RESPONSABLE_VENTAS: }>,
//        <{PENDIENTE_DOCUMENTACION_: }>,
//        <{FECHA_VENTAS: }>,
//        <{COMENTARIO_VENTAS: }>,
//        <{RESPONSABLE_BO: }>,
//        <{STATUS_BO: }>,
//        <{FECHA_BO: }>,
//        <{COMENTARIO_BO: }>,
//        <{CONTRATO: }>,
//        <{FECHA_SUBIDO_A_OPEN: }>,
//        <{FECHA_ACTIVACIÓN: }>,
//        <{CEDULA2: }>,
//        <{SUBIDO_POR: }>,
//        <{RESPONSABLE_LOGISTICA: }>,
//        <{FECHA_DE_ASIGNACION_: }>,
//        <{FECHA_DE_FIRMA: }>,
//        <{MENSAJERO: }>,
//        <{STATUS_LOGISTICA: }>,
//        <{FECHA_ULTIMO_STATUS: }>,
//        <{MENSAJERO_RUTA: }>,
//        <{FECHA_DE_SALIDA_DE_CONTRATO: }>,
//        <{FECHA_DE_REGRESO: }>,
//        <{STATUS_DEL_CONTRATO: }>,
//        <{FECHA_REPROCESO: }>,
//        <{FECHA_REGRESO_DEL_REPROCESO: }>,
//        <{MENSAJERO_REPROCESO: }>,
//        <{COMENTARIO_LOGISTICA: }>,
//        <{RESPONSABLE_CAJAS: }>,
//        <{STATUS_DE_CAJAS: }>,
//        <{FECHA_CAJAS: }>,
//        <{COMENTARIO_CAJAS: }>,
//        <{STATUS_LOGISTICA2: }>);

       System.out.println("\n insertar out bound\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public String[][] Buscar_Inbound_x_ID(String pcedula)throws Exception{
        
       String query="SELECT "
               + "ID_Contacto,"
               + "Fecha_Llamada,"
               + "ID_Usuario,"
               + "Telefono,"
               + "Nombre_Contacto,"
               + "Producto,"
               + "Detalle,"
               + "Renta,"
               + "Comentario,"
               + "Resultado "
               + "FROM T_Contacto_I WHERE ID_Contacto='"+pcedula+"'order by Fecha_Llamada DESC;";
System.out.println("\n buscar x id  IN bound\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("ID_Contacto").toString();
                 resultado[j][1]=rs.getObject("Fecha_Llamada").toString();
                 resultado[j][2]=rs.getObject("ID_Usuario").toString();
                 resultado[j][3]=rs.getObject("Telefono").toString();
                 resultado[j][4]=rs.getObject("Nombre_Contacto").toString();
                 resultado[j][5]=rs.getObject("Producto").toString();
                 resultado[j][6]=rs.getObject("Detalle").toString();
                 resultado[j][7]=rs.getObject("Renta").toString();
                 resultado[j][8]=rs.getObject("Comentario").toString();
                 resultado[j][9]=rs.getObject("Resultado").toString();
                 //System.out.print(resultado[j][1]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

    }
    
    public String[][] Buscar_Inbound_Todos(String pUsuario)throws Exception{
        String query="SELECT "
               + "ID_Contacto,"
               + "Fecha_Llamada,"
               + "ID_Usuario,"
               + "Telefono,"
               + "Nombre_Contacto,"
               + "Producto,"
               + "Detalle,"
               + "Renta,"
               + "Comentario,"
               + "Resultado "
               + "FROM T_Contacto_I WHERE ID_Usuario='"+pUsuario+"'order by Fecha_Llamada DESC;";
System.out.println("\n BUSCAR IN TODOS\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("ID_Contacto").toString();
                 resultado[j][1]=rs.getObject("Fecha_Llamada").toString();
                 resultado[j][2]=rs.getObject("ID_Usuario").toString();
                 resultado[j][3]=rs.getObject("Telefono").toString();
                 resultado[j][4]=rs.getObject("Nombre_Contacto").toString();
                 resultado[j][5]=rs.getObject("Producto").toString();
                 resultado[j][6]=rs.getObject("Detalle").toString();
                 resultado[j][7]=rs.getObject("Renta").toString();
                 resultado[j][8]=rs.getObject("Comentario").toString();
                 resultado[j][9]=rs.getObject("Resultado").toString();
                 //System.out.print(resultado[j][1]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[][] Buscar_Outbound_Todos(String pUsuario)throws Exception{
        String query="SELECT \n" +
                    "	ID_Contacto,\n" +
                    "	Nombre_Contacto,\n" +
                    "	Telefono,\n" +
                    "	Nombre_Base,\n" +
                    "	Status,\n" +
                    "	Fecha_Llamada,\n" +
                    "	Resultado\n" +
                    "FROM \n" +
                    "	T_Contacto_O C \n" +
                    "\n" +
                    "WHERE \n" +
                    "	C.ID_Usuario_Asignado='"+pUsuario+"' AND Status='Activo' \n" +
                    "AND\n" +
                    "	CASE WHEN Fecha_Llamada is NULL THEN 0 ELSE Fecha_Llamada END\n" +
                    "	IN\n" +
                    "	(SELECT CASE WHEN MAX(Fecha_Llamada) is NULL THEN 0 ELSE MAX(Fecha_Llamada) END 'MAX(Fecha_Llamada)' FROM T_Contacto_O WHERE C.Nombre_Contacto=Nombre_Contacto) \n" +
                    "\n" +
                    "ORDER BY Fecha_Llamada desc;";
System.out.println("\n BUSCAR TODOS = out bound\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("ID_Contacto").toString();
                 resultado[j][1]=rs.getObject("Nombre_Contacto").toString();
                 resultado[j][2]=rs.getObject("Telefono").toString();
                 resultado[j][3]=rs.getObject("Nombre_Base").toString();
                 resultado[j][4]=rs.getObject("Status").toString();
                 //System.out.print("--1-"+"----");
                 
                 try{
                 resultado[j][5]=rs.getObject("Fecha_Llamada").toString();
                 }catch(Exception ex){
                     resultado[j][5]=" ";
                 }
                 try{
                     resultado[j][6]=rs.getObject("Resultado").toString();
                 }catch(Exception ex){
                     resultado[j][6]=" ";
                 }
                 //System.out.print("--2-"+"----");
                 
                 //System.out.print("--3-"+"----");

                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[][] Buscar_Outbound_x_Criterio(String pCriterio, String pValor, String pUsuario)throws Exception{
        String query="SELECT \n" +
                    "	ID_Contacto,\n" +
                    "	Nombre_Contacto,\n" +
                    "	Telefono,\n" +
                    "	Nombre_Base,\n" +
                    "	Status,\n" +
                    "	Fecha_Llamada,\n" +
                    "	Resultado\n" +
                    "FROM \n" +
                    "	T_Contacto_O C \n" +
                    "\n" +
                    "WHERE \n" +
                    "	C."+pCriterio+" LIKE '%"+pValor+"%' AND Status='Activo' AND C.ID_Usuario_Asignado='"+pUsuario+"'\n" +
                    "AND\n" +
                    "	CASE WHEN Fecha_Llamada is NULL THEN 0 ELSE Fecha_Llamada END\n" +
                    "	IN\n" +
                    "	(SELECT CASE WHEN MAX(Fecha_Llamada) is NULL THEN 0 ELSE MAX(Fecha_Llamada) END 'MAX(Fecha_Llamada)' FROM T_Contacto_O WHERE C.Nombre_Contacto=Nombre_Contacto) \n" +
                    "\n" +
                    "ORDER BY Fecha_Llamada desc;";
        
System.out.println("\n BUSCAR X CRITERIO out bound\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 resultado[j][0]=rs.getObject("ID_Contacto").toString();
                 resultado[j][1]=rs.getObject("Nombre_Contacto").toString();
                 resultado[j][2]=rs.getObject("Telefono").toString();
                 resultado[j][3]=rs.getObject("Nombre_Base").toString();
                 resultado[j][4]=rs.getObject("Status").toString();
                 try{
                 resultado[j][5]=rs.getObject("Fecha_Llamada").toString();
                 }catch(Exception ex){
                     resultado[j][5]=" ";
                 }
                 try{
                     resultado[j][6]=rs.getObject("Resultado").toString();
                 }catch(Exception ex){
                     resultado[j][6]=" ";
                 }
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[][] Buscar_Outbound_Historial(String pNombre, String pTelefono)throws Exception{
        String query="Select Fecha_Llamada,Resultado,Comentario,ID_Usuario_Gestion from T_Contacto_O where Nombre_Contacto='"+pNombre+"' and Telefono='"+pTelefono+"' order by Fecha_Llamada desc;";
System.out.println("\n HISTORIAL = out bound\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 try{resultado[j][0]=rs.getObject("Fecha_Llamada").toString();}catch(Exception ex){resultado[j][0]=" ";}
                 try{resultado[j][1]=rs.getObject("Resultado").toString();}catch(Exception ex){resultado[j][1]=" ";}
                 try{resultado[j][2]=rs.getObject("Comentario").toString();}catch(Exception ex){resultado[j][2]=" ";}
                 try{resultado[j][3]=rs.getObject("ID_Usuario_Gestion").toString();}catch(Exception ex){resultado[j][3]=" ";}
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[] Cliente_OutBound(String pNombre,String pTelefono,String pBase)throws Exception{
        
        String query="Select \n" +
                        "DISTINCT\n" +
                        "ID_Contacto,\n" +
                        "Nombre_Contacto,\n" +
                        "Telefono,\n" +
                        "Nombre_Base,\n" +
                        "Identificador1_Nombre,\n" +
                        "Identificador1_Contenido,\n" +
                        "Identificador2_Nombre,\n" +
                        "Identificador2_Contenido,\n" +
                        "Identificador3_Nombre,\n" +
                        "Identificador3_Contenido\n" +
                        ",Identificador4_Nombre,\n" +
                        "Identificador4_Contenido,\n" +
                        "Identificador5_Nombre,\n" +
                        "Identificador5_Contenido,\n" +
                        "Identificador6_Nombre,\n" +
                        "Identificador6_Contenido,\n" +
                        "Identificador7_Nombre,\n" +
                        "Identificador7_Contenido,\n" +
                        "Identificador8_Nombre,\n" +
                        "Identificador8_Contenido,\n" +
                        "Identificador9_Nombre,\n" +
                        "Identificador9_Contenido\n" +
                        "from T_Contacto_O \n" +
                        "where Nombre_Contacto='"+pNombre+"' \n" +
                        "and Telefono='"+pTelefono+"' \n" +
                        "and Nombre_Base='"+pBase+"'\n" +
                        "LIMIT 1;";
        
System.out.println("\n CLIENTE out bound\n"+query);
       String resultado[]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int columnas = rsMd.getColumnCount();
           resultado=new String[columnas];
           try{
             while (rs.next()){
                     try{resultado[0]=rs.getObject("ID_Contacto").toString();}                  catch(Exception ex){resultado[0]=" ";}
                     try{resultado[1]=rs.getObject("Nombre_Contacto").toString();}              catch(Exception ex){resultado[1]=" ";}
                     try{resultado[2]=rs.getObject("Telefono").toString();}                     catch(Exception ex){resultado[2]=" ";}
                     try{resultado[3]=rs.getObject("Nombre_Base").toString();}                  catch(Exception ex){resultado[3]=" ";}
                     try{resultado[4]=rs.getObject("Identificador1_Nombre").toString();}        catch(Exception ex){resultado[4]=" ";}
                     try{resultado[5]=rs.getObject("Identificador1_Contenido").toString();}     catch(Exception ex){resultado[5]=" ";}
                     try{resultado[6]=rs.getObject("Identificador2_Nombre").toString();}        catch(Exception ex){resultado[6]=" ";}
                     try{resultado[7]=rs.getObject("Identificador2_Contenido").toString();}     catch(Exception ex){resultado[7]=" ";}
                     try{resultado[8]=rs.getObject("Identificador3_Nombre").toString();}        catch(Exception ex){resultado[8]=" ";}
                     try{resultado[9]=rs.getObject("Identificador3_Contenido").toString();}     catch(Exception ex){resultado[9]=" ";}
                     try{resultado[10]=rs.getObject("Identificador4_Nombre").toString();}       catch(Exception ex){resultado[10]=" ";}
                     try{resultado[11]=rs.getObject("Identificador4_Contenido").toString();}    catch(Exception ex){resultado[11]=" ";}
                     try{resultado[12]=rs.getObject("Identificador5_Nombre").toString();}       catch(Exception ex){resultado[12]=" ";}
                     try{resultado[13]=rs.getObject("Identificador5_Contenido").toString();}    catch(Exception ex){resultado[13]=" ";}
                     try{resultado[14]=rs.getObject("Identificador6_Nombre").toString();}       catch(Exception ex){resultado[14]=" ";}
                     try{resultado[15]=rs.getObject("Identificador6_Contenido").toString();}    catch(Exception ex){resultado[15]=" ";}
                     try{resultado[16]=rs.getObject("Identificador7_Nombre").toString();}       catch(Exception ex){resultado[16]=" ";}
                     try{resultado[17]=rs.getObject("Identificador7_Contenido").toString();}    catch(Exception ex){resultado[17]=" ";}
                     try{resultado[18]=rs.getObject("Identificador8_Nombre").toString();}       catch(Exception ex){resultado[18]=" ";}
                     try{resultado[19]=rs.getObject("Identificador8_Contenido").toString();}    catch(Exception ex){resultado[19]=" ";}
                     try{resultado[20]=rs.getObject("Identificador9_Nombre").toString();}       catch(Exception ex){resultado[20]=" ";}
                     try{resultado[21]=rs.getObject("Identificador9_Contenido").toString();}    catch(Exception ex){resultado[21]=" ";}                
                     
                }
               if(resultado[0]==null){
                   resultado=null;
                   throw new Exception("Cliente Inválido");
               }
           }
           finally { 
                  rs.close(); 
           }
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
       return resultado; 


    }
    
    public String[] Distict_Fechas()throws Exception{
        String query="select distinct Fecha_Llamadas Fecha_Llamada from \n" +
"(select  \n" +
"DATE_FORMAT(Fecha_Llamada,'%d %b %y') Fecha_Llamadas,Fecha_Llamada FL from T_Contacto_O where Fecha_Llamada is not null order by Fecha_Llamada desc) F;";
System.out.println("\n Distict_Fechas = out bound\n"+query);
       String resultado[]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas+1];
           int j=1;
           resultado[0]="Todos";
           try{
             while (rs.next()){
                 try{resultado[j]=rs.getObject("Fecha_Llamada").toString();}catch(Exception ex){resultado[j]=" ";}
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[] Distict_Bases()throws Exception{
        String query="select distinct Nombre_Base from T_Contacto_O;";
System.out.println("\n Distict_Fechas = out bound\n"+query);
       String resultado[]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas+1];
           int j=1;
           resultado[0]="Todos";
           try{
             while (rs.next()){
                 try{resultado[j]=rs.getObject("Nombre_Base").toString();}catch(Exception ex){resultado[j]=" ";}
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
    public String[] Distict_Asesores()throws Exception{
        String query="select distinct ID_Usuario_Asignado from T_Contacto_O where ID_Usuario_Asignado is not null;";
System.out.println("\n Distict_Fechas = out bound\n"+query);
       String resultado[]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas+1];
           int j=1;
           resultado[0]="Todos";
           try{
             while (rs.next()){
                 try{resultado[j]=rs.getObject("ID_Usuario_Asignado").toString();}catch(Exception ex){resultado[j]=" ";}
                 
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
    
     public String Distict_Contar(String pFecha,String pBase,String pAsesor)throws Exception{
       String query="select COUNT(distinct Nombre_Contacto) Cantidad from T_Contacto_O\n" +
"where \n" +
"Nombre_Contacto is not null\n";
                           if(pFecha.equals("Todos")){}else{query=query+"and Fecha_Llamada is not null and Fecha_Llamada < STR_TO_DATE('"+pFecha+" 23:59:59','%d %b %y %T')\n";}
                           if(pBase.equals("Todos")){}else{query=query+"and Nombre_Base = '"+pBase+"'\n" ;}
                           if(pAsesor.equals("Todos")){}else{query=query+"and ID_Usuario_Asignado = '"+pAsesor+"'\n";}
                  query=query+";"; 
System.out.println("\n Distict_Contar = out bound\n"+query);
       String resultado="0";

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);

           try{
while (rs.next()) {
                 try{resultado=rs.getObject("Cantidad").toString();}catch(Exception ex){System.out.println(ex);}
}
             
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado; 
    }
     
    public void Borrar_Base(String pFecha,String pBase,String pAsesor)
            throws Exception{
        
        String query="insert into T_Temporal_Borrar\n" +
                        "(select distinct Nombre_Contacto from T_Contacto_O\n" +
                            "where \n" +
                                "Nombre_Contacto is not null\n";
                           if(pFecha.equals("Todos")){}else{query=query+"and Fecha_Llamada is not null and Fecha_Llamada < STR_TO_DATE('"+pFecha+" 23:59:59','%d %b %y %T')\n";}
                           if(pBase.equals("Todos")){}else{query=query+"and Nombre_Base = '"+pBase+"'\n" ;}
                           if(pAsesor.equals("Todos")){}else{query=query+"and ID_Usuario_Asignado = '"+pAsesor+"'\n";}
                  query=query+");";               

                System.out.println("\n Borrar_Base Borrar_Base\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
           query="delete from T_Contacto_O where Nombre_Contacto in (SELECT * FROM T_Temporal_Borrar);";
           System.out.println("\n Borrar_Base Borrar_Base\n"+query);
           stmt.execute(query);
           query="delete from T_Temporal_Borrar;";
           System.out.println("\n Borrar_Base Borrar_Base\n"+query);
           stmt.execute(query);
           
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }  
    
    public void Insertar_Venta(
   String pAsesor, String pProducto, String pCedula_Cliente, String pNombre_Cliente, String pEstado_Civil, 
   String pTelefono_Cliente, String pProvincia, String pCanton, String pDistrito, String pDireccion, String pProcedencia, 
   String pProducto_Contratado, String pTipo_Renta, int pMnto_Renta, String pRenta_Anterior, String pForma_Pago, String pTarjeta, 
   String pAnticipo_opcion, String pAnticipo_Monto, String pR_Orden, String pR_Ced, String pR_EstadosCta, String pR_Recibo, 
   String pR_Pasaporte, String pReferencia1_Nombre, String pReferencia1_Telefono, String pReferencia1_Parentesco, String pReferencia2_Nombre, 
   String pReferencia2_Telefono, String pReferencia2_Parentesco, String pBase
    )throws Exception{
        
        String query="INSERT INTO `BD_Callcenter`.`T_Venta` \n" +
"(\n" +
"`Asesor`, `Producto`, `Cedula_Cliente`, `Nombre_Cliente`, `Estado_Civil`, `Telefono_Cliente`, `Provincia`, `Canton`, `Distrito`, `Direccion`, `Fecha_Venta`, `Procedencia`, `Producto_Contratado`, `Tipo_Renta`, `Mnto_Renta`, `Renta_Anterior`, `Forma_Pago`, `Tarjeta`, `Anticipo_opcion`, `Anticipo_Monto`, `R_Orden`, `R_Ced`, `R_EstadosCta`, `R_Recibo`, `R_Pasaporte`, `Referencia1_Nombre`, `Referencia1_Telefono`, `Referencia1_Parentesco`, `Referencia2_Nombre`, `Referencia2_Telefono`, `Referencia2_Parentesco`,`Base`) \n" +
"VALUES \n" +
"('"+pAsesor+"', '"+pProducto+"', '"+pCedula_Cliente+"', '"+pNombre_Cliente+"', '"+pEstado_Civil+"', '"+pTelefono_Cliente+"', '"+pProvincia+"', '"+pCanton+
"', '"+pDistrito+"', '"+pDireccion+"', SUBTIME(now(),'6:00:00'),'"+pProcedencia+"', '"+pProducto_Contratado+"', '"+pTipo_Renta+"', "+pMnto_Renta+", '"+pRenta_Anterior+
"', '"+pForma_Pago+"', '"+pTarjeta+"', '"+pAnticipo_opcion+"', '"+pAnticipo_Monto+"', '"+pR_Orden+"', '"+pR_Ced+"', '"+pR_EstadosCta+"', '"+pR_Recibo+"', '"+pR_Pasaporte+
"', '"+pReferencia1_Nombre+"', '"+pReferencia1_Telefono+"', '"+pReferencia1_Parentesco+"', '"+pReferencia2_Nombre+"', '"+pReferencia2_Telefono+"', '"+pReferencia2_Parentesco+"', '"+pBase+"');";

                System.out.println("\n insertar VENTA\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }    

        public String[][] Traer_Ventas(String pAsesor)throws Exception{
        
       String query="select Cod_Venta,DATE_FORMAT(Fecha_Venta,'%d %b %y') Fecha_Venta,\n" +
"Nombre_Cliente,Telefono_Cliente,Status from T_Venta \n" +
"where Asesor='"+pAsesor+"'\n" +
"order by Cod_Venta desc;";
System.out.println("\n buscar ventas\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 try{resultado[j][0]=rs.getObject("Cod_Venta").toString();}                  catch(Exception ex){resultado[j][0]=" ";}
                 try{resultado[j][1]=rs.getObject("Fecha_Venta").toString();}                catch(Exception ex){resultado[j][1]=" ";}
                 try{resultado[j][2]=rs.getObject("Nombre_Cliente").toString();}             catch(Exception ex){resultado[j][2]=" ";}
                 try{resultado[j][3]=rs.getObject("Telefono_Cliente").toString();}           catch(Exception ex){resultado[j][3]=" ";}
                 try{resultado[j][4]=rs.getObject("Status").toString();}                     catch(Exception ex){resultado[j][4]=" ";}
                 //System.out.print(resultado[j][1]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

    }
        

        public String[][] Traer_Ventas_deTodos(String cedula)throws Exception{
        
       String query="select Cod_Venta,DATE_FORMAT(Fecha_Venta,'%d %b %y') Fecha_Venta,\n" +
                    "Nombre_Cliente,Telefono_Cliente,Status from T_Venta \n" +
                    "where Cedula_Cliente like '%"+cedula+"%' order by Cod_Venta desc;";
       
                System.out.println("\n buscar ventas\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){
                 try{resultado[j][0]=rs.getObject("Cod_Venta").toString();}                  catch(Exception ex){resultado[j][0]=" ";}
                 try{resultado[j][1]=rs.getObject("Fecha_Venta").toString();}                catch(Exception ex){resultado[j][1]=" ";}
                 try{resultado[j][2]=rs.getObject("Nombre_Cliente").toString();}             catch(Exception ex){resultado[j][2]=" ";}
                 try{resultado[j][3]=rs.getObject("Telefono_Cliente").toString();}           catch(Exception ex){resultado[j][3]=" ";}
                 try{resultado[j][4]=rs.getObject("Status").toString();}                     catch(Exception ex){resultado[j][4]=" ";}
                 //System.out.print(resultado[j][1]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

    }
                
public String[][] Todas_Ventas_Admin()throws Exception{
        
       String query="select \n" +
"Cod_Venta, \n" +
"Asesor, \n" +
"Producto, \n" +
"Cedula_Cliente, \n" +
"Nombre_Cliente, \n" +
"Estado_Civil, \n" +
"Telefono_Cliente, \n" +
"Provincia, \n" +
"Canton, \n" +
"Distrito, \n" +
"Direccion, \n" +
"Fecha_Venta, \n" +
"Procedencia, \n" +
"Producto_Contratado, \n" +
"Tipo_Renta, \n"+
"Mnto_Renta, \n" +
"Renta_Anterior, \n" +
"Forma_Pago, \n" +
"Tarjeta, \n" +
"Anticipo_opcion, \n" +
"Anticipo_Monto, \n" +
"R_Orden, \n" +
"R_Ced, \n" +
"R_EstadosCta, \n" +
"R_Recibo, \n" +
"R_Pasaporte, \n" +
"Referencia1_Nombre, \n" +
"Referencia1_Telefono, \n" +
"Referencia1_Parentesco, \n" +
"Referencia2_Nombre, \n" +
"Referencia2_Telefono, \n" +
"Referencia2_Parentesco, \n" +
"Base, \n" +
"logistica_comentario, \n" +
"Status, \n" +
"Contrato, \n" +
"Responsable, \n" +
"Nombre_terminal, \n" +
"SIM, \n" +
"Comentario_Adicional, \n" +
"Firma_Instala, \n" +
"Monto_Recibido, \n" +
"IMEI\n" +
" from T_Venta;";
System.out.println("\n ventas admin\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){

try{resultado[j][0]=rs.getObject("Cod_Venta" ).toString();} catch(Exception ex){resultado[j][0]= " ";}
try{resultado[j][1]=rs.getObject("Asesor" ).toString();} catch(Exception ex){resultado[j][1]= " ";}
try{resultado[j][2]=rs.getObject("Producto" ).toString();} catch(Exception ex){resultado[j][2]= " ";}
try{resultado[j][3]=rs.getObject("Cedula_Cliente" ).toString();} catch(Exception ex){resultado[j][3]= " ";}
try{resultado[j][4]=rs.getObject("Nombre_Cliente" ).toString();} catch(Exception ex){resultado[j][4]= " ";}
try{resultado[j][5]=rs.getObject("Estado_Civil" ).toString();} catch(Exception ex){resultado[j][5]= " ";}
try{resultado[j][6]=rs.getObject("Telefono_Cliente" ).toString();} catch(Exception ex){resultado[j][6]= " ";}
try{resultado[j][7]=rs.getObject("Provincia" ).toString();} catch(Exception ex){resultado[j][7]= " ";}
try{resultado[j][8]=rs.getObject("Canton" ).toString();} catch(Exception ex){resultado[j][8]= " ";}
try{resultado[j][9]=rs.getObject("Distrito" ).toString();} catch(Exception ex){resultado[j][9]= " ";}
try{resultado[j][10]=rs.getObject("Direccion" ).toString();} catch(Exception ex){resultado[j][10]= " ";}
try{resultado[j][11]=rs.getObject("Fecha_Venta" ).toString();} catch(Exception ex){resultado[j][11]= " ";}
try{resultado[j][12]=rs.getObject("Procedencia" ).toString();} catch(Exception ex){resultado[j][12]= " ";}
try{resultado[j][13]=rs.getObject("Producto_Contratado" ).toString();} catch(Exception ex){resultado[j][13]= " ";}
try{resultado[j][14]=rs.getObject("Tipo_Renta" ).toString();} catch(Exception ex){resultado[j][14]= " ";}
try{resultado[j][15]=rs.getObject("Mnto_Renta" ).toString();} catch(Exception ex){resultado[j][15]= " ";}
try{resultado[j][16]=rs.getObject("Renta_Anterior" ).toString();} catch(Exception ex){resultado[j][16]= " ";}
try{resultado[j][17]=rs.getObject("Forma_Pago" ).toString();} catch(Exception ex){resultado[j][17]= " ";}
try{resultado[j][18]=rs.getObject("Tarjeta" ).toString();} catch(Exception ex){resultado[j][18]= " ";}
try{resultado[j][19]=rs.getObject("Anticipo_opcion" ).toString();} catch(Exception ex){resultado[j][19]= " ";}
try{resultado[j][20]=rs.getObject("Anticipo_Monto" ).toString();} catch(Exception ex){resultado[j][20]= " ";}
try{resultado[j][21]=rs.getObject("R_Orden" ).toString();} catch(Exception ex){resultado[j][21]= " ";}
try{resultado[j][22]=rs.getObject("R_Ced" ).toString();} catch(Exception ex){resultado[j][22]= " ";}
try{resultado[j][23]=rs.getObject("R_EstadosCta" ).toString();} catch(Exception ex){resultado[j][23]= " ";}
try{resultado[j][24]=rs.getObject("R_Recibo" ).toString();} catch(Exception ex){resultado[j][24]= " ";}
try{resultado[j][25]=rs.getObject("R_Pasaporte" ).toString();} catch(Exception ex){resultado[j][25]= " ";}
try{resultado[j][26]=rs.getObject("Referencia1_Nombre" ).toString();} catch(Exception ex){resultado[j][26]= " ";}
try{resultado[j][27]=rs.getObject("Referencia1_Telefono" ).toString();} catch(Exception ex){resultado[j][27]= " ";}
try{resultado[j][28]=rs.getObject("Referencia1_Parentesco" ).toString();} catch(Exception ex){resultado[j][28]= " ";}
try{resultado[j][29]=rs.getObject("Referencia2_Nombre" ).toString();} catch(Exception ex){resultado[j][29]= " ";}
try{resultado[j][30]=rs.getObject("Referencia2_Telefono" ).toString();} catch(Exception ex){resultado[j][30]= " ";}
try{resultado[j][31]=rs.getObject("Referencia2_Parentesco" ).toString();} catch(Exception ex){resultado[j][31]= " ";}
try{resultado[j][32]=rs.getObject("Base" ).toString();} catch(Exception ex){resultado[j][32]= " ";}
try{resultado[j][33]=rs.getObject("logistica_comentario" ).toString();} catch(Exception ex){resultado[j][33]= " ";}
try{resultado[j][34]=rs.getObject("Status" ).toString();} catch(Exception ex){resultado[j][34]= " ";}
try{resultado[j][35]=rs.getObject("Contrato" ).toString();} catch(Exception ex){resultado[j][35]= " ";}
try{resultado[j][36]=rs.getObject("Responsable" ).toString();} catch(Exception ex){resultado[j][36]= " ";}
try{resultado[j][37]=rs.getObject("Nombre_terminal" ).toString();} catch(Exception ex){resultado[j][37]= " ";}
try{resultado[j][38]=rs.getObject("SIM" ).toString();} catch(Exception ex){resultado[j][38]= " ";}
try{resultado[j][39]=rs.getObject("Comentario_Adicional" ).toString();} catch(Exception ex){resultado[j][39]= " ";}
try{resultado[j][40]=rs.getObject("Firma_Instala" ).toString();} catch(Exception ex){resultado[j][40]= " ";}
try{resultado[j][41]=rs.getObject("Monto_Recibido" ).toString();} catch(Exception ex){resultado[j][41]= " ";}
try{resultado[j][42]=rs.getObject("IMEI").toString();} catch(Exception ex){resultado[j][42]= " ";}
                 
                 System.out.print("query problem: "+resultado[j][0]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

    }

public String[][] Todas_Ventas_Criterio(String pCriterio, String pValor)throws Exception{
        
String query="select \n" +
"Cod_Venta, \n" +
"Asesor, \n" +
"Producto, \n" +
"Cedula_Cliente, \n" +
"Nombre_Cliente, \n" +
"Estado_Civil, \n" +
"Telefono_Cliente, \n" +
"Provincia, \n" +
"Canton, \n" +
"Distrito, \n" +
"Direccion, \n" +
"Fecha_Venta, \n" +
"Procedencia, \n" +
"Producto_Contratado, \n" +
"Tipo_Renta, \n"+
"Mnto_Renta, \n" +
"Renta_Anterior, \n" +
"Forma_Pago, \n" +
"Tarjeta, \n" +
"Anticipo_opcion, \n" +
"Anticipo_Monto, \n" +
"R_Orden, \n" +
"R_Ced, \n" +
"R_EstadosCta, \n" +
"R_Recibo, \n" +
"R_Pasaporte, \n" +
"Referencia1_Nombre, \n" +
"Referencia1_Telefono, \n" +
"Referencia1_Parentesco, \n" +
"Referencia2_Nombre, \n" +
"Referencia2_Telefono, \n" +
"Referencia2_Parentesco, \n" +
"Base, \n" +
"logistica_comentario, \n" +
"Status, \n" +
"Contrato, \n" +
"Responsable, \n" +
"Nombre_terminal, \n" +
"SIM, \n" +
"Comentario_Adicional, \n" +
"Firma_Instala, \n" +
"Monto_Recibido, \n" +
"IMEI\n" +
" from T_Venta "
        + "where "+pCriterio+" like '%"+pValor+"%';";

System.out.println("\n ventas admin\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){

try{resultado[j][0]=rs.getObject("Cod_Venta" ).toString();} catch(Exception ex){resultado[j][0]= " ";}
try{resultado[j][1]=rs.getObject("Asesor" ).toString();} catch(Exception ex){resultado[j][1]= " ";}
try{resultado[j][2]=rs.getObject("Producto" ).toString();} catch(Exception ex){resultado[j][2]= " ";}
try{resultado[j][3]=rs.getObject("Cedula_Cliente" ).toString();} catch(Exception ex){resultado[j][3]= " ";}
try{resultado[j][4]=rs.getObject("Nombre_Cliente" ).toString();} catch(Exception ex){resultado[j][4]= " ";}
try{resultado[j][5]=rs.getObject("Estado_Civil" ).toString();} catch(Exception ex){resultado[j][5]= " ";}
try{resultado[j][6]=rs.getObject("Telefono_Cliente" ).toString();} catch(Exception ex){resultado[j][6]= " ";}
try{resultado[j][7]=rs.getObject("Provincia" ).toString();} catch(Exception ex){resultado[j][7]= " ";}
try{resultado[j][8]=rs.getObject("Canton" ).toString();} catch(Exception ex){resultado[j][8]= " ";}
try{resultado[j][9]=rs.getObject("Distrito" ).toString();} catch(Exception ex){resultado[j][9]= " ";}
try{resultado[j][10]=rs.getObject("Direccion" ).toString();} catch(Exception ex){resultado[j][10]= " ";}
try{resultado[j][11]=rs.getObject("Fecha_Venta" ).toString();} catch(Exception ex){resultado[j][11]= " ";}
try{resultado[j][12]=rs.getObject("Procedencia" ).toString();} catch(Exception ex){resultado[j][12]= " ";}
try{resultado[j][13]=rs.getObject("Producto_Contratado" ).toString();} catch(Exception ex){resultado[j][13]= " ";}
try{resultado[j][14]=rs.getObject("Tipo_Renta" ).toString();} catch(Exception ex){resultado[j][14]= " ";}
try{resultado[j][15]=rs.getObject("Mnto_Renta" ).toString();} catch(Exception ex){resultado[j][15]= " ";}
try{resultado[j][16]=rs.getObject("Renta_Anterior" ).toString();} catch(Exception ex){resultado[j][16]= " ";}
try{resultado[j][17]=rs.getObject("Forma_Pago" ).toString();} catch(Exception ex){resultado[j][17]= " ";}
try{resultado[j][18]=rs.getObject("Tarjeta" ).toString();} catch(Exception ex){resultado[j][18]= " ";}
try{resultado[j][19]=rs.getObject("Anticipo_opcion" ).toString();} catch(Exception ex){resultado[j][19]= " ";}
try{resultado[j][20]=rs.getObject("Anticipo_Monto" ).toString();} catch(Exception ex){resultado[j][20]= " ";}
try{resultado[j][21]=rs.getObject("R_Orden" ).toString();} catch(Exception ex){resultado[j][21]= " ";}
try{resultado[j][22]=rs.getObject("R_Ced" ).toString();} catch(Exception ex){resultado[j][22]= " ";}
try{resultado[j][23]=rs.getObject("R_EstadosCta" ).toString();} catch(Exception ex){resultado[j][23]= " ";}
try{resultado[j][24]=rs.getObject("R_Recibo" ).toString();} catch(Exception ex){resultado[j][24]= " ";}
try{resultado[j][25]=rs.getObject("R_Pasaporte" ).toString();} catch(Exception ex){resultado[j][25]= " ";}
try{resultado[j][26]=rs.getObject("Referencia1_Nombre" ).toString();} catch(Exception ex){resultado[j][26]= " ";}
try{resultado[j][27]=rs.getObject("Referencia1_Telefono" ).toString();} catch(Exception ex){resultado[j][27]= " ";}
try{resultado[j][28]=rs.getObject("Referencia1_Parentesco" ).toString();} catch(Exception ex){resultado[j][28]= " ";}
try{resultado[j][29]=rs.getObject("Referencia2_Nombre" ).toString();} catch(Exception ex){resultado[j][29]= " ";}
try{resultado[j][30]=rs.getObject("Referencia2_Telefono" ).toString();} catch(Exception ex){resultado[j][30]= " ";}
try{resultado[j][31]=rs.getObject("Referencia2_Parentesco" ).toString();} catch(Exception ex){resultado[j][31]= " ";}
try{resultado[j][32]=rs.getObject("Base" ).toString();} catch(Exception ex){resultado[j][32]= " ";}
try{resultado[j][33]=rs.getObject("logistica_comentario" ).toString();} catch(Exception ex){resultado[j][33]= " ";}
try{resultado[j][34]=rs.getObject("Status" ).toString();} catch(Exception ex){resultado[j][34]= " ";}
try{resultado[j][35]=rs.getObject("Contrato" ).toString();} catch(Exception ex){resultado[j][35]= " ";}
try{resultado[j][36]=rs.getObject("Responsable" ).toString();} catch(Exception ex){resultado[j][36]= " ";}
try{resultado[j][37]=rs.getObject("Nombre_terminal" ).toString();} catch(Exception ex){resultado[j][37]= " ";}
try{resultado[j][38]=rs.getObject("SIM" ).toString();} catch(Exception ex){resultado[j][38]= " ";}
try{resultado[j][39]=rs.getObject("Comentario_Adicional" ).toString();} catch(Exception ex){resultado[j][39]= " ";}
try{resultado[j][40]=rs.getObject("Firma_Instala" ).toString();} catch(Exception ex){resultado[j][40]= " ";}
try{resultado[j][41]=rs.getObject("Monto_Recibido" ).toString();} catch(Exception ex){resultado[j][41]= " ";}
try{resultado[j][42]=rs.getObject("IMEI").toString();} catch(Exception ex){resultado[j][42]= " ";}
                 
                 System.out.print("query problem: "+resultado[j][0]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

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
 String Referencia2_Parentesco
)throws Exception{
        String query="UPDATE `BD_Callcenter`.`T_Venta` SET \n" +
                        "`logistica_comentario`='"+plogistica_comentario+"', \n" +
                        "`Status`='"+pStatus+"', \n" +
                        "`Contrato`='"+pContrato+"', \n" +
                        "`Responsable`='"+pResponsable+"', \n" +
                        "`Nombre_terminal`='"+pNombre_terminal+"', \n" +
                        "`SIM`='"+pSIM+"', \n" +
                        "`Comentario_Adicional`='"+pComentario_Adicional+"', \n" +
                        "`Firma_Instala`='"+pFirma_Instala+"', \n" +
                        "`Monto_Recibido`="+Monto_Recibido+", \n" +
                        "`IMEI`='"+IMEI+"', \n"+
                        "`Producto`='"+Producto+"', \n"+
                        "`Cedula_Cliente`='"+Cedula_Cliente+"',\n"+
                        "`Nombre_Cliente`='"+Nombre_Cliente+"',\n"+
                        "`Estado_Civil`='"+Estado_Civil+"', \n"+
                        "`Telefono_Cliente`='"+Telefono_Cliente+"', \n"+
                        "`Provincia`='"+Provincia+"',\n"+
                        "`Canton`='"+Canton+"', \n"+
                        "`Distrito`='"+Distrito+"',\n"+
                        "`Direccion`='"+Direccion+"', \n"+
                        "`Procedencia`='"+Procedencia+"', \n"+
                        "`Producto_Contratado`='"+Producto_Contratado+"', \n"+
                        "`Tipo_Renta`='"+Tipo_Renta+"', \n"+
                        "`Mnto_Renta`='"+Mnto_Renta+"', \n"+
                        "`Renta_Anterior`='"+Renta_Anterior+"', \n"+
                        "`Forma_Pago`='"+Forma_Pago+"',\n"+
                        "`Tarjeta`='"+Tarjeta+"', \n"+
                        "`Anticipo_opcion`='"+Anticipo_opcion+"',\n"+
                        "`Anticipo_Monto`='"+Anticipo_Monto+"', \n"+
                        "`Referencia1_Nombre`='"+Referencia1_Nombre+"',\n"+
                        "`Referencia1_Telefono`='"+Referencia1_Telefono+"',\n"+
                        "`Referencia1_Parentesco`='"+Referencia1_Parentesco+"',\n"+
                        "`Referencia2_Nombre`='"+Referencia2_Nombre+"',\n"+
                        "`Referencia2_Telefono`='"+Referencia2_Telefono+"',\n"+
                        "`Referencia2_Parentesco`='"+Referencia2_Parentesco+"'"+
                        " WHERE `Cod_Venta`='"+pcod_Venta+"';";
        

                System.out.println("\n insertar out bound\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
           
           // inserta en histórico 
           query = "INSERT INTO `BD_Callcenter`.`T_Historico_Venta` \n" +
                "(    `fecha_mov`, "
                   + "`usuario_mov`, "
                   + "`Cod_Venta`,"
                   + "`logistica_comentario`,"
                   + "`Status`,"
                   + "`Contrato`,"
                   + "`Responsable`,"
                   + "`Nombre_terminal`, "
                   + "`SIM`,"
                   + "`Comentario_Adicional`,"
                   + "`Firma_Instala`,"
                   + "`Monto_Recibido`,"
                   + "`IMEI`) \n" +
                "VALUES \n" +
                "(" +
                    "SUBTIME(now(),'6:00:00'), \n" +
                    "'"+Usuario+"', \n" +
                    "'"+pcod_Venta+"',\n" +
                    " '"+plogistica_comentario+"',\n" +
                    " '"+pStatus+"', \n" +
                    "'"+pContrato+"',\n" +
                    "'"+pResponsable+"', \n" +
                    "'"+pNombre_terminal+"', \n" +
                    "'"+pSIM+"', \n" +
                    "'"+pComentario_Adicional+"',\n" +
                    " '"+pFirma_Instala+"', \n" +
                    +Monto_Recibido+", \n" +
                    "'"+IMEI+"');";
           stmt.execute(query);
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }   

public String[][] Historico(String pventa)throws Exception{
        
String query="select "
        + "fecha_mov, "
        + "usuario_mov, "
        + "logistica_comentario, "
        + "Status, "
        + "Contrato, "
        + "Responsable, "
        + "Nombre_terminal, "
        + "SIM, "
        + "Comentario_Adicional, "
        + "Firma_Instala, "
        + "Monto_Recibido, "
        + "IMEI"
        + ""
        + " from T_Historico_Venta "
        + "where Cod_Venta="+pventa+" "
        + "order by fecha_mov desc;";

System.out.println("\n ventas admin\n"+query);
       String resultado[][]=null;

       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         try {
           ResultSet rs = stmt.executeQuery(query);
           ResultSetMetaData rsMd = rs.getMetaData();

           int columnas = rsMd.getColumnCount();
           rs.last();
           int filas = rs.getRow();
           rs.beforeFirst();
           resultado = new String[filas][columnas];
           int j=0;
           try{
             while (rs.next()){

try{resultado[j][0]=rs.getObject("fecha_mov" ).toString();} catch(Exception ex){resultado[j][0]= " ";}
try{resultado[j][1]=rs.getObject("usuario_mov" ).toString();} catch(Exception ex){resultado[j][1]= " ";}
try{resultado[j][2]=rs.getObject("logistica_comentario" ).toString();} catch(Exception ex){resultado[j][2]= " ";}
try{resultado[j][3]=rs.getObject("Status" ).toString();} catch(Exception ex){resultado[j][3]= " ";}
try{resultado[j][4]=rs.getObject("Contrato" ).toString();} catch(Exception ex){resultado[j][4]= " ";}
try{resultado[j][5]=rs.getObject("Responsable" ).toString();} catch(Exception ex){resultado[j][5]= " ";}
try{resultado[j][6]=rs.getObject("Nombre_terminal" ).toString();} catch(Exception ex){resultado[j][6]= " ";}
try{resultado[j][7]=rs.getObject("SIM" ).toString();} catch(Exception ex){resultado[j][7]= " ";}
try{resultado[j][8]=rs.getObject("Comentario_Adicional" ).toString();} catch(Exception ex){resultado[j][8]= " ";}
try{resultado[j][9]=rs.getObject("Firma_Instala" ).toString();} catch(Exception ex){resultado[j][9]= " ";}
try{resultado[j][10]=rs.getObject("Monto_Recibido" ).toString();} catch(Exception ex){resultado[j][10]= " ";}
try{resultado[j][11]=rs.getObject("IMEI" ).toString();} catch(Exception ex){resultado[j][11]= " ";}

                 
                 System.out.print("query problem: "+resultado[j][0]);
                 j++;  
             } 
           }
           finally {
                  rs.close(); 
           }
         } 
         finally {
               stmt.close(); 
         }
       } 
       finally {
             conn.close(); 
       }
    return resultado;  

    }

public void crear_usuario(
String ID,
String nombre,
String clave,
String correo, 
String rol)
            throws Exception{
        
        String query="INSERT INTO `BD_Callcenter`.`T_Usuario` "
                + "(`ID_Usuario`, `Nombre_Usuario`, `Clave_Usuario`, `Correo_Usuario`, `Proyecto_Usuario`) "
                + "VALUES "
                + "('"+ID+"', '"+nombre+"', '"+clave+"', '"+correo+"', '"+rol+"');";
        

                System.out.println("\n insertar asesor\n"+query);
                
       Class.forName ("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://173.194.232.184:3306/BD_Callcenter", "app_cnx01_stt", "cemmeWrev1");
       try {
         Statement stmt = conn.createStatement();
         try {
           stmt.execute(query);
           
         }
         finally {
               stmt.close(); 
         }
       }
       finally {
             conn.close(); 
       }
    }   



}
