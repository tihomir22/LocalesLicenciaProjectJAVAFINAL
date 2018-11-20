/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sportak
 */
public class Licencia {

    private String expediente;
    private String anyo;
    private int id;
    private int idLocal;
    private String titulo;
    private String fechaCreacion;

    public Licencia(String expediente, String anyo, int id, String titulo, String fechaCreacion) {
        this.expediente = expediente;
        this.anyo = anyo;
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
    }

    public Licencia() {
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public String toString() {
        return "Licencia{" + "expediente=" + expediente + ", anyo=" + anyo + ", id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + '}';
    }

}
