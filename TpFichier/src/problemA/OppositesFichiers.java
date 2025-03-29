package problemA;

import java.io.*;
import java.util.StringTokenizer;

public class OppositesFichiers {
	public static void main(String[] args) {
		// Chemin absolu vers le fichier d'entrée et de sortie:
		String cheminEntree = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemA\\in";
		String cheminSortie = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemA\\out";

		BufferedReader read = null;
		PrintWriter write = null;

		try {
			read = new BufferedReader(new FileReader(cheminEntree));
			write = new PrintWriter(new FileWriter(cheminSortie));
			int N = Integer.parseInt(read.readLine());
			int[] nombres = new int[N];

			StringTokenizer st = new StringTokenizer(read.readLine());
			for (int i = 0; i < N; i++) {
				nombres[i] = Integer.parseInt(st.nextToken());
			}

			int compteur = 0;
			for (int i = 0; i < N; i++) {
				if (nombres[i] > 0) {
					boolean opposeTrouve = false;
					boolean dejaCompte = false;

					for (int j = 0; j < N; j++) {
						if (nombres[j] == -nombres[i]) {
							opposeTrouve = true;
							break;
						}
					}

					for (int k = 0; k < i; k++) {
						if (nombres[k] == nombres[i]) {
							dejaCompte = true;
							break;
						}
					}

					if (opposeTrouve && !dejaCompte) {
						compteur++;
					}
				}
			}

			write.println(compteur);
			System.out.println("Traitement terminé. Résultat écrit dans: " + cheminSortie);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		write.close();
	}
}