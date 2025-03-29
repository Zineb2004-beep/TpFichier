package problemB2;

import java.io.*;

public class GoodTriangle {
    public static void main(String[] args) throws IOException {
    	
    	String cheminEntree = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemB2\\in";
		String cheminSortie = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemB2\\out";
		
        File fichierEntree = new File(cheminEntree);
        File fichierSortie = new File(cheminSortie);
        
        BufferedReader read = new BufferedReader(new FileReader(fichierEntree));
        PrintWriter write = new PrintWriter(fichierSortie);
        
        int nombreCas = Integer.parseInt(read.readLine());
        
        for (int cas = 1; cas <= nombreCas; cas++) {
            int n = Integer.parseInt(read.readLine());
            
            long resultat = 0;
            
            for (int k = 1; k <= n; k++) {
                long T = (k + 1) * (k + 2) / 2;  
                resultat += k * T;                
            }
            
            write.println(cas + " " + n + " " + resultat);
        }
        
        read.close();
        write.close();
    }
}