package Graphism;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BattleShip.BattleShip;
import BattleShip.Controler;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;
import tools.BoatImageProvider;

public class MonPlateau extends AbstractPlateau {
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	private int xInit;
	private int yInit;
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
