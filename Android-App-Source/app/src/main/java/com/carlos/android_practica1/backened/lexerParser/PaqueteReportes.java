package com.carlos.android_practica1.backened.lexerParser;

import com.carlos.android_practica1.backened.obj.ErrorAnalisis;

import java.io.Serializable;
import java.util.ArrayList;

public class PaqueteReportes implements Serializable {
    private ArrayList<String[]> erroresFinal;
    private ArrayList<String[]> ocurrencias;
    private ArrayList<String[]> graficos;

    public PaqueteReportes(ArrayList<String[]> erroresFinal, ArrayList<String[]> ocurrencias, ArrayList<String[]> graficos) {
        this.erroresFinal = erroresFinal;
        this.ocurrencias = ocurrencias;
        this.graficos = graficos;
    }

    public ArrayList<String[]> getErroresFinal() {
        return erroresFinal;
    }

    public void setErroresFinal(ArrayList<String[]> erroresFinal) {
        this.erroresFinal = erroresFinal;
    }

    public ArrayList<String[]> getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(ArrayList<String[]> ocurrencias) {
        this.ocurrencias = ocurrencias;
    }

    public ArrayList<String[]> getGraficos() {
        return graficos;
    }

    public void setGraficos(ArrayList<String[]> graficos) {
        this.graficos = graficos;
    }
}
