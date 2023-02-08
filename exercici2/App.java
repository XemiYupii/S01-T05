package exercici2;
import java.io.File;
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
		File [] contingut =directori.listFiles();
		Arrays.sort(contingut);
		
		for (int i = 0; i < contingut.length; i ++) {
			Date dataModificacio = new Date (contingut[i].lastModified());
			System.out.println(contingut[i].getName() +"  " +(contingut[i].isDirectory() ? "D" : "F") +"  " +dataModificacio );
			if (contingut[i].isDirectory())
				llistarArbreDirectori(contingut[i]);
		}
	}

}
