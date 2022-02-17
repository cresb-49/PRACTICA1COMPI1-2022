package com.carlos.pruebas.lexerParser;

public class Symbol extends java_cup.runtime.Symbol{
    private String lexema;
    private int linea;
    private int columna;
    private Symbol anterior;
}
