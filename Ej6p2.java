package com.company;

import java.lang.reflect.Array;
import java.util.Vector;
public class Ej6p2 {
    public Ej6p2() {
    }

    ;

    public float obtener_primer_simb(float[] vetor_est) {

        float r = (float) Math.random();
        for (int i = 0; i < vetor_est.length; i++) {
            if (r < (vetor_est[i])) {
                return i;

            }
        }
        System.out.println("fallo el primer simbolo");
        return 0;// si el rand falla
    }

    public int obtener_Simb_dado_anterior(float[][] matriz_pro_acum, int simbolo_anterior, float[] Simbolos) {// anda joyelli
        float R = (float) Math.random();
        for (int i = 0; i < Simbolos.length; i++) {
            if (R < matriz_pro_acum[i][simbolo_anterior]) {
                System.out.println("simbolo" + i);
                return i;
            }
        }
        return 1; // en caso de que no haya en el for
    }

    public boolean converge(float[] v_estado_est_ant, float[] v_estado_est_act, float epsilon) { //anda bien
        for (int i = 0; i < v_estado_est_act.length; i++) {
            if ((Math.abs(v_estado_est_ant[i] - v_estado_est_act[i])) > epsilon) {
                return false;
            }
        }
        return true;
    }

    public float[] estado_estacionario(float[][] matriz_pro_cond) {
        float[] simbolos = new float[]{0, 1, 2};
        float[][] matriz_prob_cond_acum = matriz_pro_cond;
        for (int i = 1; i < matriz_pro_cond.length; i++) {
            for (int j = 0; j < matriz_pro_cond.length; j++) {
                matriz_prob_cond_acum[i][j] = matriz_prob_cond_acum[i - 1][j] + matriz_pro_cond[i][j];
            }
        }

        float[] Actual = new float[]{0, 0, 0};
        float[] Anterior = new float[]{-1, -1, -1};
        float[] CantSimb = new float[]{0, 0, 0};

        int simb_anterior = -1;
        int simbolo_actual = 0;
        /*if (Actual.length == 0) {
            simbolo_actual = obtener_primer_simb(Anterior);
        }*/


        int min_pasos = 30;
        int pasos = 0;
        int nuevo_simbolo;

        while ((pasos < min_pasos) || (!converge(Anterior, Actual, (float) 0.000001))) {
            simbolo_actual=obtener_Simb_dado_anterior(matriz_prob_cond_acum,simbolo_actual,simbolos);
            CantSimb[simbolo_actual]=CantSimb[simbolo_actual]+1;
            pasos++;
            Anterior[simbolo_actual]=Actual[simbolo_actual];
            Actual[simbolo_actual]=CantSimb[simbolo_actual]/pasos;
            System.out.println(simbolo_actual);
        }
        return Actual;
    }
}












