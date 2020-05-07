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
	 
	public double[] media_recurrencia() {
		int tac=0;
		ArrayList<Integer> lista=this.getNumbers();
		int recurrencias[] = new int[256];// cantidad de recurrencias de cada simbolo
		int ultimo[] = new int[256];// ultima tiempo donde se encontro cada simbolo
		int pasos[] = new int[256];//suma de las distancias entre cada recurrencia
		double mac[] = new double[256];//media actual
		double man[] = new double[256]; //media anterior
		int n=0;// se usa para calcular la posicion en el arreglo de un simbolo
		int dist=0;// se usa para calcular la distancia de la recurrencia actual
		int s;// simbolo actual
		int pos=0;// posicion de la lista que se lee
		for (int i=0;i<256;i++) {
			recurrencias[i]=0;
			ultimo[i]=-1;
			pasos[i]=0;
			mac[i]=0.0;
			man[i]=-1.0;
		}
		while((pos<lista.size()&&((tac<MIN)||(!converge(man,mac))))){
			s=lista.get(pos);
			pos++;
			if(s<0) //numeros del -127 al -1
				n=Math.abs(s);// posicion del 1 al 127
			else if(s>0)// del 1 al 127
				n=128+s;// posicion del 128 al 256
			else n=0; //0
			if(ultimo[n]>-1) {// hay recurrencia
				recurrencias[n]++;
				dist=tac-ultimo[n];
				pasos[n]+=dist;
			}
			ultimo[n]=tac;
			tac++;
			for(int i=0;i<256;i++) {
				man[i]=mac[i];
				if(recurrencias[i]>0)
					mac[i]=(double) pasos[i]/recurrencias[i];
			}
		}
		return mac;
	}
	 
	private boolean converge(double[] man, double[] mac) {
		for(int i=0;i<256;i++) {
			if(Math.abs(mac[i]-man[i])>EPSILON)
				return false;
		}
		return true;
	}
	private boolean converge(double pan, double pac) {
		return (Math.abs(pan-pac)<=EPSILON);
	}
	
}
