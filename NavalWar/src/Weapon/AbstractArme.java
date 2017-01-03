package Weapon;

public class AbstractArme {
	
	private String nom;
	private int nbrRestant;
	
	public AbstractArme(String n, int r) {
		this.nom = n;
		this.nbrRestant = r;
	}

	public String getNom() {
		return nom;
	}

	public int getNbrRestant() {
		return nbrRestant;
	}
	
	@Override
	public String toString() {
		return "Arme sélectionnée : "+nom+" ; "+nbrRestant+" coup(s) restant(s)";
	}
	
}
