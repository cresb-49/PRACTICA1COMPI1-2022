package com.carlos.android_practica1.backened.lexerParser;

import java.util.ArrayList;
import java.util.List;

public class SimbolosTerminales {

    public static final String[] terminalNames = new String[] {
            "",
            "",
            "def",
            "Barras",
            "Pie",
            "titulo",
            "ejex",
            "ejey",
            "etiquetas",
            "valores",
            "union",
            "tipo",
            "Porcentaje/Cantidad",
            "total",
            "extra",
            "Ejecutar",
            "+",
            "-",
            "*",
            "/",
            "(",
            ")",
            "[",
            "]",
            "{",
            "}",
            ",",
            ":",
            ";",
            "cadena",
            "numero",
            "decimal"
    };

    public SimbolosTerminales() {

    }

    public List<String> obtenerSimbolos(List<Integer> expected_tokens) {
        List<String> resultados = new ArrayList<>();
        for (Integer entero : expected_tokens) {
            if (!(entero == 1 || entero == 0)) {
                resultados.add(terminalNames[entero]);
            }
        }
        return resultados;
    }
}
