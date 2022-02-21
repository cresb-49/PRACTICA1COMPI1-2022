package com.carlos.android_practica1.backened.obj;

public class OcurrenciaOperador {
    private String operador;
    private int linea;
    private int columna;
    private String ocurrencia;
    public OcurrenciaOperador(){

    }
    public OcurrenciaOperador(String operador, int linea, int columna, String ocurrencia) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ocurrencia = ocurrencia;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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

    public String getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(String ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    @Override
    public String toString() {
        return "OcurrenciaOperador{" + "operador=" + operador + ", linea=" + linea + ", columna=" + columna + ", ocurrencia=" + ocurrencia + '}';
    }
}
