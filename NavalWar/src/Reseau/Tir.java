package Reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//info a envoyer:
//-liste de cible
//infos a retourner:
//- liste de cible avec loupé/touché
//- si le bateau à été coulé ou non
//- si coulé, nom du bateau



import BattleShip.Coord;
import Boats.Bateau;

public class Tir {
	
	public Coord coordCible;
	public String nomArme;
	public Coord coordTouche;
	public Bateau bateauCoule;
	

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

	public Bateau getBateauCoule() {
		return bateauCoule;
	}

	public void setBateauCoule(Bateau bateauCoule) {
		this.bateauCoule = bateauCoule;
	}


}
