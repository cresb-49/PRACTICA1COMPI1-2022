package com.carlos.android_practica1.backened.obj;

/**
 *
 * @author carlo
 */
public class Grafica {
    private String titulo;
    
    
    private String[] tag;
    private Double[] val;
    
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
}
