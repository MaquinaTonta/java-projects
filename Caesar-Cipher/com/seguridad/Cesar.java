/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguridad;

/**
 *
 * @author Ing. Eduardo Basurto
 */
public class Cesar {

    private static int k;
    private static String textoP;
    private static String textoC;
    private static String alfabeto = "";

 
    public static void setK(int ka){
        k=ka;
    }
    
    public static void setAlfabeto(String alfa){
        alfabeto=alfa;
    }
    
    public static String getAlfabeto(){
        return alfabeto;
    }

    public static String cifrar(String mensaje) {
        String txtCif = "";
        int pos;
        int recorrido;
        int posFinal;
        for (int i = 0; i < mensaje.length(); i++) {
            pos = alfabeto.indexOf(mensaje.charAt(i));
            recorrido = pos + k;
            posFinal = recorrido % alfabeto.length();
            txtCif += alfabeto.toCharArray()[posFinal];
        }
        return txtCif;
    }

    public static String decifrar(String codificado) {
        String txtPlano = "";
        int pos;
        int recorrido;
        int posFinal;
        for (int i = 0; i < codificado.length(); i++) {
            pos = alfabeto.indexOf(codificado.charAt(i));
            if (pos - k < 0) {
                pos += alfabeto.length();
            }
            recorrido = pos-k;
            posFinal=recorrido%alfabeto.length();
            txtPlano+=alfabeto.toCharArray()[posFinal];
        }
        return txtPlano;
    }

}
