package com.carlos.pruebas.lexerParser;

import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public class GraficaBarra {

    private String titulo;
    private String[] ejex;
    private Double[] ejey;
    private ArrayList<Union> unir;

    public GraficaBarra() {
    }

    public GraficaBarra(String titulo, String[] ejex, Double[] ejey, ArrayList<Union> unir) {
        this.titulo = titulo;
        this.ejex = ejex;
        this.ejey = ejey;
        this.unir = unir;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getEjex() {
        return ejex;
    }

    public void setEjex(String[] ejex) {
        this.ejex = ejex;
    }

    public Double[] getEjey() {
        return ejey;
    }

    public void setEjey(Double[] ejey) {
        this.ejey = ejey;
    }

    public ArrayList<Union> getUnir() {
        return unir;
    }

    public void setUnir(ArrayList<Union> unir) {
        this.unir = unir;
    }
    
    public  void addUnir(Union unir){
        this.unir.add(unir);
    }

    @Override
    public String toString() {
        return "GraficaBarra{" + "titulo=" + titulo + ", ejex=" + ejex + ", ejey=" + ejey + ", unir=" + unir + '}';
    }

}