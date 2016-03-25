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
public class VentaDTH {
    
    String numeroBurro;
    String anticipo;
    String dondeFirmaInstala;
    String tipoProducto;
    double rentaPagar;
    String adicionales;
    String esquemaContratacionA;
    String esquemaContratacionB;
    String esquemaContratacionC;
    
    public VentaDTH(String numeroBurro, String anticipo, String dondeFirmaInstala, String tipoProducto, double rentaPagar, String adicionales, String esquemaContratacionA, String esquemaContratacionB, String esquemaContratacionC) {
        this.numeroBurro = numeroBurro;
        this.anticipo = anticipo;
        this.dondeFirmaInstala = dondeFirmaInstala;
        this.tipoProducto = tipoProducto;
        this.rentaPagar = rentaPagar;
        this.adicionales = adicionales;
        this.esquemaContratacionA = esquemaContratacionA;
        this.esquemaContratacionB = esquemaContratacionB;
        this.esquemaContratacionC = esquemaContratacionC;
    }
    
    
    public String getNumeroBurro() {
        return numeroBurro;
    }

    public void setNumeroBurro(String numeroBurro) {
        this.numeroBurro = numeroBurro;
    }

    public String getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(String anticipo) {
        this.anticipo = anticipo;
    }

    public String getDondeFirmaInstala() {
        return dondeFirmaInstala;
    }

    public void setDondeFirmaInstala(String dondeFirmaInstala) {
        this.dondeFirmaInstala = dondeFirmaInstala;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getRentaPagar() {
        return rentaPagar;
    }

    public void setRentaPagar(int rentaPagar) {
        this.rentaPagar = rentaPagar;
    }

    public String getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(String adicionales) {
        this.adicionales = adicionales;
    }

    public String getEsquemaContratacionA() {
        return esquemaContratacionA;
    }

    public void setEsquemaContratacionA(String esquemaContratacionA) {
        this.esquemaContratacionA = esquemaContratacionA;
    }

    public String getEsquemaContratacionB() {
        return esquemaContratacionB;
    }

    public void setEsquemaContratacionB(String esquemaContratacionB) {
        this.esquemaContratacionB = esquemaContratacionB;
    }

    public String getEsquemaContratacionC() {
        return esquemaContratacionC;
    }

    public void setEsquemaContratacionC(String esquemaContratacionC) {
        this.esquemaContratacionC = esquemaContratacionC;
    }
}
