package com.carlos.android_practica1.backened.obj;

import java.util.ArrayList;

public class ConvertRow {
    public ConvertRow(){

    }

    public ArrayList<String[]> errorReport(ArrayList<ErrorAnalisis> errorAnalises){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        for(ErrorAnalisis err:errorAnalises){
            tmp = new String[] {err.getLexema(), String.valueOf(err.getLinea()), String.valueOf(err.getColumna()),err.getTipo(),err.getDescipcion()};
            erros.add(tmp);
        }
        return  erros;
    }

    public ArrayList<String[]> ejemplo(){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        for(int i =0;i<20;i++){
            tmp = new String[] {"&", "2", "13", "Léxico", "Símbolo no existe en el lenguaje"};
            erros.add(tmp);
        }
        return  erros;
    }
}
