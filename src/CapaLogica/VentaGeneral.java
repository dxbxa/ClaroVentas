/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.util.Date;

/**
 *
 * @author macBook
 */
public class VentaGeneral {

    
    
    public VentaGeneral(String procencia, String NombreCliente, int Cedula, Date fechaVencCedula, String Asesor, Date fechaNacimiento, String estadoCivil, int telMovil, int telFijo, int telTrabajo, String provincia, String canton, String distrito, String direccionCLiente, String cantonEntrega, String direccionEntrega, double montoOrden, String referenciaLaboral, int telReferenciaLaboral, String parentescoLaboral, String nomRefFamiliar, int telRefFamiliar, String parentescoFamiliar, String cantonRefFamiliar, String nomRefPersonal, int telRefPersonal, String parentescoRefPersonal, String cantonRefPersonal, String procedenciaVenta, String requisitosPoliticas, String producto, Date fechaEntrega, String horarioEntrega, String comentariosVenta, Boolean regalia) {
        this.procencia = procencia;
        this.NombreCliente = NombreCliente;
        this.Cedula = Cedula;
        this.fechaVencCedula = fechaVencCedula;
        this.Asesor = Asesor;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.telMovil = telMovil;
        this.telFijo = telFijo;
        this.telTrabajo = telTrabajo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccionCLiente = direccionCLiente;
        this.cantonEntrega = cantonEntrega;
        this.direccionEntrega = direccionEntrega;
        this.montoOrden = montoOrden;
        this.referenciaLaboral = referenciaLaboral;
        this.telReferenciaLaboral = telReferenciaLaboral;
        this.parentescoLaboral = parentescoLaboral;
        this.nomRefFamiliar = nomRefFamiliar;
        this.telRefFamiliar = telRefFamiliar;
        this.parentescoFamiliar = parentescoFamiliar;
        this.cantonRefFamiliar = cantonRefFamiliar;
        this.nomRefPersonal = nomRefPersonal;
        this.telRefPersonal = telRefPersonal;
        this.parentescoRefPersonal = parentescoRefPersonal;
        this.cantonRefPersonal = cantonRefPersonal;
        this.procedenciaVenta = procedenciaVenta;
        this.requisitosPoliticas = requisitosPoliticas;
        this.producto = producto;
        this.fechaEntrega = fechaEntrega;
        this.horarioEntrega = horarioEntrega;
        this.comentariosVenta = comentariosVenta;
        this.regalia = regalia;
    }
    String procencia;
    String NombreCliente;
    int Cedula;
    Date fechaVencCedula;
    String Asesor;
    Date fechaNacimiento;
    String estadoCivil;
    int telMovil;
    int telFijo;
    int telTrabajo;
    String provincia;
    String canton;
    String distrito;
    String direccionCLiente;
    String cantonEntrega;
    String direccionEntrega;
    double montoOrden;
    String referenciaLaboral;
    int telReferenciaLaboral;
    String parentescoLaboral;
    String nomRefFamiliar;
    int telRefFamiliar;
    String parentescoFamiliar;
    String cantonRefFamiliar;
    String nomRefPersonal;
    int telRefPersonal;
    String parentescoRefPersonal;
    String cantonRefPersonal;
    String procedenciaVenta;
    String requisitosPoliticas;
    String producto;
    Date fechaEntrega;
    String horarioEntrega;
    String comentariosVenta;
    Boolean regalia;

    public String getProcencia() {
        return procencia;
    }

    public void setProcencia(String procencia) {
        this.procencia = procencia;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public Date getFechaVencCedula() {
        return fechaVencCedula;
    }

    public void setFechaVencCedula(Date fechaVencCedula) {
        this.fechaVencCedula = fechaVencCedula;
    }

    public String getAsesor() {
        return Asesor;
    }

    public void setAsesor(String Asesor) {
        this.Asesor = Asesor;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(int telMovil) {
        this.telMovil = telMovil;
    }

    public int getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(int telFijo) {
        this.telFijo = telFijo;
    }

    public int getTelTrabajo() {
        return telTrabajo;
    }

    public void setTelTrabajo(int telTrabajo) {
        this.telTrabajo = telTrabajo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccionCLiente() {
        return direccionCLiente;
    }

    public void setDireccionCLiente(String direccionCLiente) {
        this.direccionCLiente = direccionCLiente;
    }

    public String getCantonEntrega() {
        return cantonEntrega;
    }

    public void setCantonEntrega(String cantonEntrega) {
        this.cantonEntrega = cantonEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getMontoOrden() {
        return montoOrden;
    }

    public void setMontoOrden(double montoOrden) {
        this.montoOrden = montoOrden;
    }

    public String getReferenciaLaboral() {
        return referenciaLaboral;
    }

    public void setReferenciaLaboral(String referenciaLaboral) {
        this.referenciaLaboral = referenciaLaboral;
    }

    public int getTelReferenciaLaboral() {
        return telReferenciaLaboral;
    }

    public void setTelReferenciaLaboral(int telReferenciaLaboral) {
        this.telReferenciaLaboral = telReferenciaLaboral;
    }

    public String getParentescoLaboral() {
        return parentescoLaboral;
    }

    public void setParentescoLaboral(String parentescoLaboral) {
        this.parentescoLaboral = parentescoLaboral;
    }

    public String getNomRefFamiliar() {
        return nomRefFamiliar;
    }

    public void setNomRefFamiliar(String nomRefFamiliar) {
        this.nomRefFamiliar = nomRefFamiliar;
    }

    public int getTelRefFamiliar() {
        return telRefFamiliar;
    }

    public void setTelRefFamiliar(int telRefFamiliar) {
        this.telRefFamiliar = telRefFamiliar;
    }

    public String getParentescoFamiliar() {
        return parentescoFamiliar;
    }

    public void setParentescoFamiliar(String parentescoFamiliar) {
        this.parentescoFamiliar = parentescoFamiliar;
    }

    public String getCantonRefFamiliar() {
        return cantonRefFamiliar;
    }

    public void setCantonRefFamiliar(String cantonRefFamiliar) {
        this.cantonRefFamiliar = cantonRefFamiliar;
    }

    public String getNomRefPersonal() {
        return nomRefPersonal;
    }

    public void setNomRefPersonal(String nomRefPersonal) {
        this.nomRefPersonal = nomRefPersonal;
    }

    public int getTelRefPersonal() {
        return telRefPersonal;
    }

    public void setTelRefPersonal(int telRefPersonal) {
        this.telRefPersonal = telRefPersonal;
    }

    public String getParentescoRefPersonal() {
        return parentescoRefPersonal;
    }

    public void setParentescoRefPersonal(String parentescoRefPersonal) {
        this.parentescoRefPersonal = parentescoRefPersonal;
    }

    public String getCantonRefPersonal() {
        return cantonRefPersonal;
    }

    public void setCantonRefPersonal(String cantonRefPersonal) {
        this.cantonRefPersonal = cantonRefPersonal;
    }

    public String getProcedenciaVenta() {
        return procedenciaVenta;
    }

    public void setProcedenciaVenta(String procedenciaVenta) {
        this.procedenciaVenta = procedenciaVenta;
    }

    public String getRequisitosPoliticas() {
        return requisitosPoliticas;
    }

    public void setRequisitosPoliticas(String requisitosPoliticas) {
        this.requisitosPoliticas = requisitosPoliticas;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getComentariosVenta() {
        return comentariosVenta;
    }

    public void setComentariosVenta(String comentariosVenta) {
        this.comentariosVenta = comentariosVenta;
    }

    public Boolean getRegalia() {
        return regalia;
    }

    public void setRegalia(Boolean regalia) {
        this.regalia = regalia;
    }
    
    
}
