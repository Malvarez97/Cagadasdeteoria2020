package com.company;

public class Ej7 {
    public Ej7(){};

    private boolean converge(double proact, double proant){
        double numero=(proact-proant);
        if (numero<0) {
            numero = (numero * -1);
        }
        return (numero<0.000000001);
    }

    private boolean sobreFacil (double cantFaciles,double cantTotal){// puse las variables afuera por si es o no con reposicion
       double G= Math.random()*cantTotal;
        if (G<cantFaciles){
            return true;
        }
        return  false;
    }
    public  double resultados(){
        double minimo =10;
        double exito =0;
        double pruebas=0;
        double proact=0;
        double proant=-1;// para que entre en la primera iteracion
        while ((!converge(proact,proant)) || (pruebas<minimo)) {
            boolean e1=sobreFacil(3,5);
            boolean e2=sobreFacil(3,5);
            if (e1||e2){
                exito++;
            }
            pruebas++;
            proant=proact;
            proact=exito/pruebas;

        }
        pruebas++;
        System.out.println(pruebas);
        return proact;

    }
}

