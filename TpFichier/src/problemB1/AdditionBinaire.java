package problemB1;

import java.io.*;
import java.util.StringTokenizer;

public class AdditionBinaire {
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter writer = null;

		String cheminEntree = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemB1\\bin.in";
		String cheminSortie = "C:\\Users\\User\\eclipse-workspace\\TpFichier\\src\\problemB1\\binOut";

		try {
			reader = new BufferedReader(new FileReader(cheminEntree));
			writer = new PrintWriter(new FileWriter(cheminSortie));

			int N = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= N; i++) {
				String ligne = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(ligne);
				String bin1 = tokenizer.nextToken();
				String bin2 = tokenizer.nextToken();

				int num1 = convertirEnDecimal(bin1);
				int num2 = convertirEnDecimal(bin2);

				int somme = num1 + num2;

				String resultat = convertirEnBinaire(somme);

				writer.println(i + " " + resultat);
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.getMessage();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static int convertirEnDecimal(String binaire) {
		int decimal = 0;
		for (int i = 0; i < binaire.length(); i++) {
			decimal = decimal * 2 + (binaire.charAt(i) - '0');
		}
		return decimal;
	}

	public static String convertirEnBinaire(int decimal) {
		if (decimal == 0)
			return "0";

		String binaire = "";
		while (decimal > 0) {
			binaire = (decimal % 2) + binaire;
			decimal = decimal / 2;
		}
		return binaire;
	}
}