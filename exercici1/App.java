package exercici1;

import java.io.File;
import java.util.Arrays;



public class App {

	public static void main(String[] args) {
		
		if (args.length <= 0)
			System.out.println("No has introduit cap argument");
		
		String ruta = args[0];
		File directori = new File (ruta);
		
		if (comprobacioDirectori (directori))
			llistarContingutAlfabeticament(directori);
		else
			System.out.println("ERROR " +ruta +" no es valid");
	}
	public static boolean comprobacioDirectori (File directori) {
		return (directori.isDirectory() && directori.exists());
	}
	public static void llistarContingutAlfabeticament(File directori) {
		String [] contingut = directori.list();
		Arrays.sort(contingut);
		for (int i= 0; i < contingut.length; i++) {
			System.out.println(contingut[i]);
		}
	}

}
