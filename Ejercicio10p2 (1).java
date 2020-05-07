import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio10p2 {
	private static int MIN=20000;
	private static double EPSILON=0.001;
	public Ejercicio10p2() { }
	 public ArrayList<Integer> getNumbers() {
	        File archivo = null;
	        FileReader lee = null;
	        BufferedReader buf = null;
	        ArrayList<Integer> numeros = new ArrayList();
	        ArrayList<Integer> b = new ArrayList();
	        String linea;
	        try {
	            archivo = new File("C:\\Users\\sofia\\Documents\\ingenieria\\TeoriadelaInformacion\\Practico 2_DatosEntrada-Ej10.txt");//aca va la direccion donde se encuentra el archivo
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
	 
	
	 
	 public double prob_prim_rec(int pasos, int simbolo) {
		 int tac=0;
		 int recurrencias=0;
		 int aciertos=0;
		 int ultimo=-1;
		 double pac=0.0;
		 double pan=-1.0;
		 int posicion=0;
		 int s=-500;
		 ArrayList<Integer> lista= this.getNumbers();
		 while ((posicion<lista.size())&&((recurrencias<MIN)||!(converge(pan,pac)))) {
			 s=lista.get(posicion);
			 posicion++;
			 if(s==simbolo) {
				 if (ultimo>-1) {// la primera vez que lo encuentro no la cuento{
					 recurrencias++;
					 if(tac-ultimo==pasos)
						 aciertos++;
					 pan=pac;
					 pac=(double) aciertos/recurrencias;
				 }
				 ultimo=tac;
			 }
			 tac++;
		 }
		 return pac;
	 }
	 
	private boolean converge(double pan, double pac) {
		return (Math.abs(pan-pac)<=EPSILON);
	}
	
}
