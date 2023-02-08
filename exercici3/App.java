package exercici3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;



public class App {

	public static void main(String[] args) {
		
		if (args.length <= 0)
			System.out.println("No has introduit cap argument");
		
		String ruta = args[0];
		File directori = new File (ruta);
		
		if (comprobacioDirectori (directori)) {
			llistarContingutAlfabeticament(directori);
			llistarArbreDirectori (directori);
			guardarContingutFitxer (directori);
		}
		else
			System.out.println("ERROR " +ruta + " no es valid");
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
	public static void llistarArbreDirectori (File directori) {
		File [] rutes =directori.listFiles();
		Arrays.sort(rutes);
		
		for (int i = 0; i < rutes.length; i ++) {
			Date dataModificacio = new Date (rutes[i].lastModified());
			System.out.println(rutes[i].getName() +"  " +(rutes[i].isDirectory() ? "D" : "F") +"  " +dataModificacio );
			if (rutes[i].isDirectory())
				llistarArbreDirectori(rutes[i]);
		}
	}
	public static void guardarContingutFitxer (File directori) {
		File [] rutes =directori.listFiles();
		Arrays.sort(rutes);
		
		try (BufferedWriter writer = new BufferedWriter ( new FileWriter ("informacio.txt", true))){
			for (File file : rutes) {
				Date dataModificacio = new Date (file.lastModified());
				writer.write(file.getName() +"  " +(file.isDirectory() ? "D" : "F") +"  " +dataModificacio);
				writer.newLine();
				if(file.isDirectory())
					guardarContingutFitxer(file);
			}
		}catch (IOException e) {
				System.out.println("Error al crear l'artxiu");
				e.printStackTrace();
		}
	}
}