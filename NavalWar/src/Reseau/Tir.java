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
	
	public Coord coordCible;
	public String nomArme;
	public Coord coordTouche;
	public boolean bateauCoule;
	

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


}
