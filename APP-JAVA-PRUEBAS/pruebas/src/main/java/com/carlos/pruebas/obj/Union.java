package com.carlos.pruebas.obj;

public class Union {
    private int etiqueta_x;
    private int valor_y;

    public Union(int etiqueta_x, int valor_y) {
        this.etiqueta_x = etiqueta_x;
        this.valor_y = valor_y;
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
    @Override
    public String toString() {
        return "Union{" + "etiqueta_x=" + etiqueta_x + ", valor_y=" + valor_y + '}';
    }
}
