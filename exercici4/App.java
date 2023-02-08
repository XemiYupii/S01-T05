package exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		
		if (args.length <= 0)
			System.out.println("No has introduit cap argument");
		
		String ruta = args[0];
		File fitxer = new File (ruta);
		
		if (comprobacioFitxer(fitxer))
			llegirMostrarFitxer(fitxer);
		else
			System.out.println("El fitxer " +ruta +" no es valid");
	}
	public static boolean comprobacioFitxer (File fitxer) {
		return (fitxer.isFile() && fitxer.exists());
	}
	public static void llegirMostrarFitxer (File fitxer) {
		try (BufferedReader reader = new BufferedReader( new FileReader(fitxer))) {
			String linia = "";
			while ((linia = reader.readLine()) != null) {
				System.out.println(linia);
			}
		} catch (IOException  e) {
			System.out.println("Error al llegir l'artxiu");
			System.out.println(e.getMessage());
		}
	}

}
