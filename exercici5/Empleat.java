package exercici5;

import java.io.Serializable;

public class Empleat implements Serializable {
	
	private String nom;
	private int edat;
	private double sou;
	
	public Empleat (String nom, int edat, double sou ) {
		this.nom = nom;
		this.edat = edat;
		this.sou = sou;
	}
	
	public String toString() {
		return nom +"  " +edat +"  " +sou;
	}

}
