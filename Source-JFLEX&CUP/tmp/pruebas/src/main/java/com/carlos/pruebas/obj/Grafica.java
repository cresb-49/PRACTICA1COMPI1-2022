package com.carlos.pruebas.obj;

/**
 *
 * @author carlo
 */
public class Grafica {
    private String titulo;
    
    
    private String[] tag;
    private Double[] val;
    
    private int linUnir;
    private int colUnir;
    
    public Grafica() {
    }
    
    public Grafica(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public Double[] getVal() {
        return val;
    }

    public void setVal(Double[] val) {
        this.val = val;
    }

    public int getLinUnir() {
        return linUnir;
    }

    public void setLinUnir(int linUnir) {
        this.linUnir = linUnir;
    }

    public int getColUnir() {
        return colUnir;
    }

    public void setColUnir(int colUnir) {
        this.colUnir = colUnir;
    }
}
