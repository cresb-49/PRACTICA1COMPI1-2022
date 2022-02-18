package com.carlos.pruebas.lexerParser;

public class Union {
    private int etiqueta;
    private int valor;

    public Union(int etiqueta, int valor) {
        this.etiqueta = etiqueta;
        this.valor = valor;
    }
    public Union() {
    }
    public int getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
}
