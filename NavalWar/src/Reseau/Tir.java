package Reseau;


//info a envoyer:
//-liste de cible
//infos a retourner:
//- liste de cible avec loupé/touché
//- si le bateau à été coulé ou non
//- si coulé, nom du bateau



import java.io.Serializable;

import BattleShip.Coord;
import Boats.Bateau;

public class Tir implements Serializable{
	
	private Coord coordCible;
	private String nomArme;
	private Coord coordTouche;
	private boolean bateauCoule;
	
	public Tir(Coord coord, String arme) {
		this.coordCible = coord;
		this.nomArme = arme;
	}
	
	public Coord getCoordCible() {
		return coordCible;
	}

	public void setCoordCible(Coord coordCible) {
		this.coordCible = coordCible;
	}

	public String getNomArme() {
		return nomArme;
	}

	public void setNomArme(String nomArme) {
		this.nomArme = nomArme;
	}

	public Coord getCoordTouche() {
		return coordTouche;
	}

	public void setCoordTouche(Coord coordTouche) {
		this.coordTouche = coordTouche;
	}

	public boolean getBateauCoule() {
		return bateauCoule;
	}

	public void setBateauCoule(boolean bateauCoule) {
		this.bateauCoule = bateauCoule;
	}
	
	@Override
	public String toString() {
		return "Tir de l'arme "+this.nomArme+" !";
	}

}
