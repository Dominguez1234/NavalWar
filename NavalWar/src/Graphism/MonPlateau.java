package Graphism;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import BattleShip.BattleShip;
import BattleShip.Controler;
import Boats.AbstractBateau;
import Boats.Bateau;

public class MonPlateau extends AbstractPlateau {
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	 ArrayList<AbstractBateau> al;
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	public MonPlateau(int posx, int posy, ArrayList<AbstractBateau> al, Controler fenetreMere) {
		super(posx, posy, fenetreMere);
		this.al=al;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetPlateau() {
		// TODO Auto-generated method stub
		
	}
	
//	public static int getIndex(){
//		return index;
//	}

}
