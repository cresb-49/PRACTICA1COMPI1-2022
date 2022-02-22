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

    public ArrayList<String[]> reportOcurrencias(ArrayList<OcurrenciaOperador> ocurrenciaOperador){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        for(OcurrenciaOperador ocu:ocurrenciaOperador){
            tmp = new String[] {ocu.getOperador(), String.valueOf(ocu.getLinea()), String.valueOf(ocu.getColumna()), ocu.getOcurrencia()};
            erros.add(tmp);
        }
        return  erros;
    }
    public ArrayList<String[]> reportGraficos(int Pie,int Barras){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        tmp = new String[] {"Barras",String.valueOf(Barras)};
        erros.add(tmp);
        tmp = new String[] {"Pie",String.valueOf(Pie)};
        erros.add(tmp);
        return  erros;
    }

    public ArrayList<String[]> ejemplo1(){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        for(int i =0;i<20;i++){
            tmp = new String[] {"&", "2", "13", "Léxico", "Símbolo no existe en el lenguaje"};
            erros.add(tmp);
        }
        return  erros;
    }
    public ArrayList<String[]> ejemplo1v2(){
        ArrayList<String[]> erros = new ArrayList<>();
        return  erros;
    }

    public ArrayList<String[]> ejemplo2(){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        for(int i =0;i<6;i++){
            tmp = new String[] {"Suma", "1", "15", "12  + 2"};
            erros.add(tmp);
        }
        return  erros;
    }

    public ArrayList<String[]> ejemplo3(){
        ArrayList<String[]> erros = new ArrayList<>();
        String[] tmp;
        tmp = new String[] {"Barras",String.valueOf(2)};
        erros.add(tmp);
        tmp = new String[] {"Pie",String.valueOf(5)};
        erros.add(tmp);
        return  erros;
    }
}
