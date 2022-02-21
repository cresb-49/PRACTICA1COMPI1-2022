package com.carlos.android_practica1.backened.obj;

import java.util.ArrayList;
import java.util.Arrays;

public class GraficaPie extends Grafica {

    private String tipo;
    private String[] etiquetas;
    private Double[] valores;
    private ArrayList<Union> unir;
    private Double total;
    private String extra;

    public GraficaPie(String titulo, String tipo, String[] etiquetas, Double[] valores, ArrayList<Union> unir, Double total, String extra) {
        super(titulo);
        this.tipo = tipo;
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.unir = unir;
        this.total = total;
        this.extra = extra;
    }

    public GraficaPie() {
        super();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Double[] getValores() {
        return valores;
    }

    public void setValores(Double[] valores) {
        this.valores = valores;
    }

    public ArrayList<Union> getUnir() {
        return unir;
    }

    public void setUnir(ArrayList<Union> unir) {
        this.unir = unir;
    }

    public void addUnir(Union unir) {
        this.unir.add(unir);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public ArrayList<String> verificarGrafica() {
        ArrayList<String> errores = new ArrayList<>();
        if (this.tipo == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"tipo\"");
            this.verificacion(errores, 0);
            return errores;
        } else if (this.tipo.equals("Cantidad")) {
            this.verificacion(errores, 1);
            return errores;
        } else if (this.tipo.equals("Porcentaje")) {
            this.verificacion(errores, 0);
            return errores;
        } else {
            errores.add("Grafica de Pie, la definicion de \"tipo\" no es correcta");
            return errores;
        }
    }

    private void verificacion(ArrayList<String> errores, int tipo) {
        if (this.getTitulo() == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"titulo\"");
        }
        if (this.etiquetas == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"etiquetas\"");
        }
        if (this.valores == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"valores\"");
        }
        if (tipo == 1) {
            if (this.total == null) {
                errores.add("Grafica de Pie, no esta definido el parametro \"total\"");
            }
        } else {
            if (this.total != null) {
                errores.add("Grafica de Pie, no es necesario definir el parametro \"total\"");
            }
        }
        if (this.unir == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"unir\"");
        }
        if (this.extra == null) {
            errores.add("Grafica de Pie, no esta definido el parametro \"extra\"");
        }
    }

    public ArrayList<ErrorAnalisis> analizarUnir() {
        ArrayList<ErrorAnalisis> errores = new ArrayList<>();
        for (Union union : this.unir) {
            if (!(union.getEtiqueta_x() < this.etiquetas.length)) {
                errores.add(new ErrorAnalisis("Sintactico", String.valueOf(union.getEtiqueta_x()), union.getLinea(), union.getColumna(), "Grafica de Pie, no esta definido un valor en el espacio solictado de las etiquetas"));
            }
            if (!(union.getValor_y() < this.valores.length)) {
                errores.add(new ErrorAnalisis("Sintactico", String.valueOf(union.getValor_y()), union.getLinea(), union.getColumna(), "Grafica de Pie, no esta definido un valor en el espacio solictado de los valores"));
            }
        }
        return errores;
    }

    public void triangularUniones() {
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        for (Union union : this.unir) {
            if ((union.getEtiqueta_x() < this.etiquetas.length)) {
                x.add(this.etiquetas[union.getEtiqueta_x()]);
            }
            if ((union.getValor_y() < this.valores.length)) {
                y.add(this.valores[union.getValor_y()]);
            }
        }
        String[]x_2 = x.toArray(new String[x.size()]);
        Double[]y_2 = y.toArray(new Double[y.size()]);
        this.setTag(x_2);
        this.setVal(y_2);
        
    }

    @Override
    public String toString() {
        return "GraficaPie{" + "titulo=" + this.getTitulo() + ", tipo=" + tipo + ", etiquetas=" + Arrays.toString(etiquetas) + ", valores=" + Arrays.toString(valores) + ", unir=" + unir + ", total=" + total + ", extra=" + extra + '}';
    }
}
