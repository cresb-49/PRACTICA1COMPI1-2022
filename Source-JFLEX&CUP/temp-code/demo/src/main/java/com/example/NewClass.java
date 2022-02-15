/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public class NewClass {
    StringBuffer string = new StringBuffer();
    private ArrayList<Object> lexErrors = new ArrayList<>();
    
    public ArrayList<Object> getLexErrors() {
        return lexErrors;
    }

    private void addError(Object object){
        this.lexErrors.add(object);
        System.out.println("Se decto un error");
    }
}
