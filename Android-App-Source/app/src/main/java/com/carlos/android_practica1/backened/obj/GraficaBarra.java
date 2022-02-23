package com.carlos.android_practica1.backened.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author benjamin
 */
public class GraficaBarra extends Grafica implements Serializable {
    private String[] ejex;
    private Double[] ejey;
    private ArrayList<Union> unir;

    public GraficaBarra() {
        super();
    }

    public GraficaBarra(String titulo, String[] ejex, Double[] ejey, ArrayList<Union> unir) {
        super(titulo);
        this.ejex = ejex;
        this.ejey = ejey;
        this.unir = unir;
    }

    public String[] getEjex() {
        return ejex;
    }

    public void setEjex(String[] ejex) {
        this.ejex = ejex;
    }

    public Double[] getEjey() {
        return ejey;
    }

    public void setEjey(Double[] ejey) {
        this.ejey = ejey;
    }

    public ArrayList<Union> getUnir() {
        return unir;
    }

    public void setUnir(ArrayList<Union> unir) {
        this.unir = unir;
    }
    
    public  void addUnir(Union unir){
        this.unir.add(unir);
    }

    public ArrayList<String> verificarGrafica(){
        ArrayList<String> errores = new ArrayList<>();
        if(this.getTitulo()==null){
            errores.add("Grafica de Barras, no esta definido el parametro \"titulo\"");
        }
        if(this.ejex == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"ejex\"");
        }
        if(this.ejey == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"ejey\"");
        }
        if(this.unir == null){
            errores.add("Grafica de Barras, no esta definido el parametro \"unir\"");
        }
        return errores;
    }
    
    public ArrayList<ErrorAnalisis> analizarUnir() {
        ArrayList<ErrorAnalisis> errores = new ArrayList<>();
        for (Union union : this.unir) {
            if (!(union.getEtiqueta_x() < this.ejex.length)) {
                errores.add(new ErrorAnalisis("Sintactico", String.valueOf(union.getEtiqueta_x()), union.getLinea(), union.getColumna(), "Grafica de Barras, no esta definido un valor en el espacio solictado del ejex"));
            }
            if (!(union.getValor_y() < this.ejey.length)) {
                errores.add(new ErrorAnalisis("Sintactico", String.valueOf(union.getValor_y()), union.getLinea(), union.getColumna(), "Grafica de Barras, no esta definido un valor en el espacio solictado del ejey"));
            }
        }
        return errores;
    }

    public void triangularUniones() {
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        for (Union union : this.unir) {
            if ((union.getEtiqueta_x() < this.ejex.length)) {
                x.add(this.ejex[union.getEtiqueta_x()]);
            }
            if ((union.getValor_y() < this.ejey.length)) {
                y.add(this.ejey[union.getValor_y()]);
            }
        }
        String[]x_2 = x.toArray(new String[x.size()]);
        Double[]y_2 = y.toArray(new Double[y.size()]);
        this.setTag(x_2);
        this.setVal(y_2);
        
    }

    @Override
    public String toString() {
        return "GraficaBarra{" + "titulo=" + this.getTitulo() + ", ejex=" + Arrays.toString(ejex) + ", ejey=" + Arrays.toString(ejey) + ", unir=" + unir + '}';
    }

}
