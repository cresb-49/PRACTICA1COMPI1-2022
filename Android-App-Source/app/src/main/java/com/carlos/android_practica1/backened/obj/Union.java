package com.carlos.android_practica1.backened.obj;

public class Union {
    private int etiqueta_x;
    private int valor_y;
    
    private int linea;
    private int columna;
    
    public Union(int etiqueta_x, int valor_y) {
        this.etiqueta_x = etiqueta_x;
        this.valor_y = valor_y;
    }

    public Union(int etiqueta_x, int valor_y, int linea, int columna) {
        this.etiqueta_x = etiqueta_x;
        this.valor_y = valor_y;
        this.linea = linea;
        this.columna = columna;
    }
    
    public Union() {
    }
    public int getEtiqueta_x() {
        return etiqueta_x;
    }
    public void setEtiqueta_x(int etiqueta_x) {
        this.etiqueta_x = etiqueta_x;
    }
    public int getValor_y() {
        return valor_y;
    }
    public void setValor_y(int valor_y) {
        this.valor_y = valor_y;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    @Override
    public String toString() {
        return "Union{" + "et_x=" + etiqueta_x + ", val_y=" + valor_y + '}';
    }
}
