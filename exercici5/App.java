package exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

	public static void main(String[] args) {
		
		Empleat treballador = new Empleat ("Gemma", 36, 1975.69);
		
		serialitzarObjecte(treballador);
		Empleat treballador2 = desserialitzarObjecte();
		System.out.println(desserialitzarObjecte());
		
	}
	public static void serialitzarObjecte (Empleat empleat) {
		try (ObjectOutputStream serialitzant = new ObjectOutputStream (new FileOutputStream ("serialitzacio.ser"))){
			serialitzant.writeObject(empleat);
		} catch (IOException e) {
			System.out.println("Error al serialitzar Empleat " +e.getMessage());
		}
	}
	public static Empleat desserialitzarObjecte () {
		Empleat treballador2 = null;
		try (ObjectInputStream desserialitzant = new ObjectInputStream( new FileInputStream( "serialitzacio.ser"))){
			Object objecteObtingut = desserialitzant.readObject();
			if (objecteObtingut instanceof Empleat) 
				treballador2 = (Empleat)objecteObtingut;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al desserialitzar Empleat " +e.getMessage());
		}
		return treballador2;
	}

}
