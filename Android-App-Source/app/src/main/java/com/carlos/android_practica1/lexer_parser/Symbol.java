package com.carlos.android_practica1.lexer_parser;

public class Symbol {
    private String lexema;
    private int linea;
    private int columna;
    private Symbol anterior;

    public Symbol() {
    }

    public Symbol(String lexema, int linea, int columna, Symbol anterior) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.anterior = anterior;
    }

    public Symbol(String lexema, int linea, int columna) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.anterior = anterior;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
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

    public Symbol getAnterior() {
        return anterior;
    }

    public void setAnterior(Symbol anterior) {
        this.anterior = anterior;
    }
}
