package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;


public class Tp310 {

    public Tp310() {}

    public ArrayList<Integer> getNumbers() {
        File archivo = null;
        FileReader lee = null;
        BufferedReader buf = null;
        ArrayList<Integer> numeros = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        String linea;
        try {
            archivo = new File("C:/Users/Cas/Downloads/Ej10.txt");//aca va la direccion donde se encuentra el archivo
                 if (!archivo.exists())
                    {System.out.println("no estas leyendo nada bb");}
            lee = new FileReader(archivo);
            buf = new BufferedReader(lee);
            while ((linea = buf.readLine()) != null) {
                Integer A = (Integer.parseInt(linea.substring(0, linea.length() - 1)));
                numeros.add(A);
            }
            return numeros;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lee!=null)
                    lee.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return numeros;
    }
}



