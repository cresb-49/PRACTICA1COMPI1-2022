package com.carlos.pruebas.obj;

import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> verificarGrafica(){
        ArrayList<String> errores = new ArrayList<>();
        if(this.titulo==null){
            errores.add("Grafica de Barras, no esta definido el parametro \"titulo\"");
        }
        if(this.ejex == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"ejex\"");
        }
        if(this.ejey == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"ejey\"");
        }
        if(this.unir == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"unir\"");
        }
        return errores;
    }

    @Override
    public String toString() {
        return "GraficaBarra{" + "titulo=" + titulo + ", ejex=" + Arrays.toString(ejex) + ", ejey=" + Arrays.toString(ejey) + ", unir=" + unir + '}';
    }

}
