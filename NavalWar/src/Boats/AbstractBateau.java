package Boats;

import java.util.ArrayList;

import BattleShip.Coord;

/*
 * Version simplifiée d'un bateau
 */

public class AbstractBateau  {
	
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
	
	// Calcul des positions en fonction d'une coordonnée de référence
	public ArrayList<Coord> calculPositions(Coord origine, Bateau.direction sens) {
		ArrayList<Coord> result = new ArrayList<>();
		int i;
		int x = origine.x;
		int y = origine.y;
		boolean possible = true;
		Coord coordTemp;
		
		for (i = 0; i < this.nbrCases; i++) {
			coordTemp = new Coord(x,y);
			result.add(coordTemp);
			possible &= coordTemp.coordonnees_valides();
			if(sens.equals(Bateau.direction.horizontale))
				y++;
			else
				x++;
		}
		
		if(!possible)
			result.clear();
		
		return result;
	}
	
}
