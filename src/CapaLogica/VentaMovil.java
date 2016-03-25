/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

/**
 *
 * @author macBook
 */
public class VentaMovil {

    public String getNomEmpresaTrab() {
        return NomEmpresaTrab;
    }

    public void setNomEmpresaTrab(String NomEmpresaTrab) {
        this.NomEmpresaTrab = NomEmpresaTrab;
    }

    public String getDistritoTrabaja() {
        return distritoTrabaja;
    }

    public void setDistritoTrabaja(String distritoTrabaja) {
        this.distritoTrabaja = distritoTrabaja;
    }

    public String getDireccionTrabaja() {
        return direccionTrabaja;
    }

    public void setDireccionTrabaja(String direccionTrabaja) {
        this.direccionTrabaja = direccionTrabaja;
    }

    public double getMontoOrdenPatrol() {
        return montoOrdenPatrol;
    }

    public void setMontoOrdenPatrol(double montoOrdenPatrol) {
        this.montoOrdenPatrol = montoOrdenPatrol;
    }

    public String getModeloTelefono() {
        return modeloTelefono;
    }

    public void setModeloTelefono(String modeloTelefono) {
        this.modeloTelefono = modeloTelefono;
    }

    public String getTipoSim() {
        return tipoSim;
    }

    public void setTipoSim(String tipoSim) {
        this.tipoSim = tipoSim;
    }

    public String getPlanPropuesto() {
        return planPropuesto;
    }

    public void setPlanPropuesto(String planPropuesto) {
        this.planPropuesto = planPropuesto;
    }

    public String getPaqueteMinutos() {
        return paqueteMinutos;
    }

    public void setPaqueteMinutos(String paqueteMinutos) {
        this.paqueteMinutos = paqueteMinutos;
    }

    public String getPaqueteSms() {
        return paqueteSms;
    }

    public void setPaqueteSms(String paqueteSms) {
        this.paqueteSms = paqueteSms;
    }

    public String getPaqueteDatos() {
        return paqueteDatos;
    }

    public void setPaqueteDatos(String paqueteDatos) {
        this.paqueteDatos = paqueteDatos;
    }

    public boolean isClienteExiste() {
        return clienteExiste;
    }

    public void setClienteExiste(boolean clienteExiste) {
        this.clienteExiste = clienteExiste;
    }

    public String getSegmentacion() {
        return segmentacion;
    }

    public void setSegmentacion(String segmentacion) {
        this.segmentacion = segmentacion;
    }

    public double getMontoSubsidio() {
        return montoSubsidio;
    }

    public void setMontoSubsidio(double montoSubsidio) {
        this.montoSubsidio = montoSubsidio;
    }

    public double getRentaAnterior() {
        return rentaAnterior;
    }

    public void setRentaAnterior(double rentaAnterior) {
        this.rentaAnterior = rentaAnterior;
    }

    public double getRentaActual() {
        return rentaActual;
    }

    public void setRentaActual(double rentaActual) {
        this.rentaActual = rentaActual;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getSinFronteras() {
        return sinFronteras;
    }

    public void setSinFronteras(String sinFronteras) {
        this.sinFronteras = sinFronteras;
    }

    public String getInformacionTarjeta() {
        return informacionTarjeta;
    }

    public void setInformacionTarjeta(String informacionTarjeta) {
        this.informacionTarjeta = informacionTarjeta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public VentaMovil(String NomEmpresaTrab, String distritoTrabaja, String direccionTrabaja, double montoOrdenPatrol, String modeloTelefono, String tipoSim, String planPropuesto, String paqueteMinutos, String paqueteSms, String paqueteDatos, boolean clienteExiste, String segmentacion, double montoSubsidio, double rentaAnterior, double rentaActual, String formaPago, String sinFronteras, String informacionTarjeta, String tipoVenta) {
        this.NomEmpresaTrab = NomEmpresaTrab;
        this.distritoTrabaja = distritoTrabaja;
        this.direccionTrabaja = direccionTrabaja;
        this.montoOrdenPatrol = montoOrdenPatrol;
        this.modeloTelefono = modeloTelefono;
        this.tipoSim = tipoSim;
        this.planPropuesto = planPropuesto;
        this.paqueteMinutos = paqueteMinutos;
        this.paqueteSms = paqueteSms;
        this.paqueteDatos = paqueteDatos;
        this.clienteExiste = clienteExiste;
        this.segmentacion = segmentacion;
        this.montoSubsidio = montoSubsidio;
        this.rentaAnterior = rentaAnterior;
        this.rentaActual = rentaActual;
        this.formaPago = formaPago;
        this.sinFronteras = sinFronteras;
        this.informacionTarjeta = informacionTarjeta;
        this.tipoVenta = tipoVenta;
    }
    String NomEmpresaTrab;
    String distritoTrabaja;
    String direccionTrabaja;
    double montoOrdenPatrol;
    String modeloTelefono;
    String tipoSim;
    String planPropuesto;
    String paqueteMinutos;
    String paqueteSms;
    String paqueteDatos;
    boolean clienteExiste;
    String segmentacion;
    double montoSubsidio;
    double rentaAnterior;
    double rentaActual;
    String formaPago;
    String sinFronteras;
    String informacionTarjeta;
    String tipoVenta;
    
}
