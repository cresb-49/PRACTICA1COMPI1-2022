package com.carlos.pruebas.lexerParser;

import java.util.ArrayList;

public class GraficaPie {
    private String titulo;
    private String tipo;
    private String[] etiquetas;
    private Double[] valores;
    private ArrayList<Union> unir;
    private Double total;
    private String resto;

    public GraficaPie(String titulo, String tipo, String[] etiquetas, Double[] valores, ArrayList<Union> unir, Double total, String resto) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.unir = unir;
        this.total = total;
        this.resto = resto;
    }

    public GraficaPie() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Double[] getValores() {
        return valores;
    }

    public void setValores(Double[] valores) {
        this.valores = valores;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getResto() {
        return resto;
    }

    public void setResto(String resto) {
        this.resto = resto;
    }

    @Override
    public String toString() {
        return "GraficaPie{" + "titulo=" + titulo + ", tipo=" + tipo + ", etiquetas=" + etiquetas + ", valores=" + valores + ", unir=" + unir + ", total=" + total + ", resto=" + resto + '}';
    }
    
}
