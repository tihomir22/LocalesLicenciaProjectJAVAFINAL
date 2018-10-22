/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Local {

    private int id;
    private String emplazamiento;
    private int codPortal;
    private int codVia;
    private String numVia;
    private String referenciaCatastral;
    private String  referenciaMunicipal;
    private int poligono;
    private String zonaSaturada;
    private String Comentarios;
    ArrayList<Licencia> listaLicencias = new ArrayList<>();

    public Local(int id, String emplazamiento, int codPortal, int codVia, String numVia, String referenciaCatastral, String referenciaMunicipal, int poligono, String zonaSaturada, String Comentarios) {
        this.id = id;
        this.emplazamiento = emplazamiento;
        this.codPortal = codPortal;
        this.codVia = codVia;
        this.numVia = numVia;
        this.referenciaCatastral = referenciaCatastral;
        this.referenciaMunicipal = referenciaMunicipal;
        this.poligono = poligono;
        this.zonaSaturada = zonaSaturada;
        this.Comentarios = Comentarios;
    }

    public Local() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmplazamiento() {
        return emplazamiento;
    }

    public void setEmplazamiento(String emplazamiento) {
        this.emplazamiento = emplazamiento;
    }

    public int getCodPortal() {
        return codPortal;
    }

    public void setCodPortal(int codPortal) {
        this.codPortal = codPortal;
    }

    public int getCodVia() {
        return codVia;
    }

    public void setCodVia(int codVia) {
        this.codVia = codVia;
    }

    public String getNumVia() {
        return numVia;
    }

    public void setNumVia(String numVia) {
        this.numVia = numVia;
    }

    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }

    public void setReferenciaCatastral(String referenciaCatastral) {
        this.referenciaCatastral = referenciaCatastral;
    }

    public String getReferenciaMunicipal() {
        return referenciaMunicipal;
    }

    public void setReferenciaMunicipal(String referenciaMunicipal) {
        this.referenciaMunicipal = referenciaMunicipal;
    }

    public int getPoligono() {
        return poligono;
    }

    public void setPoligono(int poligono) {
        this.poligono = poligono;
    }

    public String getZonaSaturada() {
        return zonaSaturada;
    }

    public void setZonaSaturada(String zonaSaturada) {
        this.zonaSaturada = zonaSaturada;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public ArrayList<Licencia> getListaLicencias() {
        return listaLicencias;
    }

    public void setListaLicencias(ArrayList<Licencia> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }

    @Override
    public String toString() {
        return "Local{" + "id=" + id + ", emplazamiento=" + emplazamiento + ", codPortal=" + codPortal + ", codVia=" + codVia + ", numVia=" + numVia + ", referenciaCatastral=" + referenciaCatastral + ", referenciaMunicipal=" + referenciaMunicipal + ", poligono=" + poligono + ", zonaSaturada=" + zonaSaturada + ", Comentarios=" + Comentarios + ", listaLicencias=" + listaLicencias + '}';
    }

}
