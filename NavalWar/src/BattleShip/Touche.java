package BattleShip;

/*
 * Classe crée pour représenter un point de la carte.
 * Si la case a été ciblé par un tir => isTargeted = true
 * Si la case a été touché => isTouche = true
 */

public class Touche {
	
	// Attributs
	public boolean isTargeted;
	public boolean isTouche;

	// Constructeur, tout à faux.
	public Touche(){
		this.isTargeted = false;
		this.isTouche = false;
	}

	@Override
	public String toString() {
		String affiche="";
		if(isTargeted == true){
			if(isTouche == true)
				affiche = "X";
			else
				affiche= "O";
		}
		else{	
			affiche = "-";	
		}
		return affiche;
	}	
}
