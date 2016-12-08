package BattleShip;

/*
 * Classe cr�e pour repr�senter un point de la carte.
 * Si la case a �t� cibl� par un tir => isTargeted = true
 * Si la case a �t� touch� => isTouche = true
 */

public class Touche {
	
	// Attributs
	public boolean isTargeted;
	public boolean isTouche;

	// Constructeur, tout � faux.
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
