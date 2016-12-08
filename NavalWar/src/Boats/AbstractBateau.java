package Boats;

public class AbstractBoat {
	
	private String nom = "";
	private int nbrCases = 0;
	
	public AbstractBoat(String n, int nbr) {
		this.nom = n;
		this.nbrCases = nbr;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbrCases() {
		return this.nbrCases;
	}
	
}
