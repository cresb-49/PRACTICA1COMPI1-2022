/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.pruebas.obj;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Benjamin
 */
public class VerficacionValuesPie {

    public VerficacionValuesPie() {

    }

    public String verficarPiePorcentaje(GraficaPie gp) {
        String error = "";
        double tmpSum = 0;
        Double[] tmpVal = new Double[gp.getVal().length];
        int count = 0;
        for (Double double1 : gp.getVal()) {
            if (double1 < 0) {
                tmpVal[count] = (double1 / 10);
                tmpSum = tmpSum + (double1 / 10);
            } else {
                tmpVal[count] = double1;
                tmpSum = tmpSum + double1;
            }
            count++;
        }
        if (tmpSum > 100) {
            error = ("Los valores seleccionados a graficar: "+Arrays.toString(gp.getVal())+", suman mas del 100%");
        } else {
            if (tmpSum < 100) {
                System.out.println("Se agrego un sobrante a la grafica");
                gp.setVal(this.agregarSobrante(tmpVal, tmpSum));
                gp.setTag(this.agregarTagSobrante(gp.getTag(),gp.getExtra()));
            }else{
                System.out.println("La grafica estaba exacta");
            }
        }
        return error;
    }
    
    public Double[] agregarSobrante(Double[] valuePercent,double total){
        Double[] newValues = new Double[valuePercent.length+1];
        int cont = 0;
        for (Double double1 : valuePercent) {
            newValues[0]=double1;
            cont++;
        }
        newValues[cont]=(100-total);
        return newValues;
    }
    
    public String[] agregarTagSobrante(String[] tags,String extra){
        String[] newTags = new String[tags.length+1];
        int cont = 0;
        for (String str : tags) {
            newTags[0]=str;
            cont++;
        }
        newTags[cont]=extra;
        return newTags;
    }
}
