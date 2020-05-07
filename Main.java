package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World");
       /* Ej7 A = new Ej7();
        System.out.println(A.resultados());*/

        /*float prob[][]=new float[3][3];//fila , columna
        prob[0][0]=(float)0;
        prob[0][1]=(float)0.25;
        prob[0][2]=(float)0.25;
        prob[1][0]=(float)0.5;
        prob[1][1]=(float)0.5;
        prob[1][2]=(float)0.25;
        prob[2][0]=(float)0.5;
        prob[2][1]=(float)0.5;
        prob[2][2]=(float)0.25;
        float [] resultado= new float[3];
        Ej6p2 B =new Ej6p2();
        resultado=B.estado_estacionario(prob);
        for (int i = 0; i <resultado.length ; i++) {
            System.out.println( (float)resultado[i]);
        }*/
      Tp310 C= new Tp310();
        ArrayList Res= C.getNumbers();
        for (int i=0; i<Res.size();i++){
            System.out.print(Res.get(i));
            System.out.print("-");
        }
        System.out.println();
        System.out.println("El arreglo tiene "+Res.size()+ "  cantidad de enteros");
        System.out.println("cambio");
        System.out.println("El arreglo tiene "+Res.size()+ "  cantidad de enteros");
        System.out.println("El arreglo tiene "+Res.size()+ "  cantidad de enteros");
        System.out.println("El arreglo tiene "+Res.size()+ "  cantidad de enteros");
        System.out.println("El arreglo tiene "+Res.size()+ "  cantidad de enteros");
       
        
    }
    }

