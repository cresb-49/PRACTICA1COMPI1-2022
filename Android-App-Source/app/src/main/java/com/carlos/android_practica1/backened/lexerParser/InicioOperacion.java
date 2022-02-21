/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.android_practica1.backened.lexerParser;


import com.carlos.android_practica1.backened.obj.Token;

/**
 *
 * @author Benjamin
 */
public class InicioOperacion {
    private Double value;
    private Token token;

    public InicioOperacion(Double value, Token token) {
        this.value = value;
        this.token = token;
    }

    public InicioOperacion() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
