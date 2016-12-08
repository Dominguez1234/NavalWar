package Boats;

/*
 * Version simplifiée d'un bateau
 */

public class AbstractBateau {
	
	// Attributs
	private String nom = "";
	private int nbrCases = 0;
	
	// Contruscteurs
	public AbstractBateau(String n, int nbr) {
		this.nom = n;
		this.nbrCases = nbr;
	}
	
	public AbstractBateau() {
		
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbrCases() {
		return this.nbrCases;
	}
	
}
