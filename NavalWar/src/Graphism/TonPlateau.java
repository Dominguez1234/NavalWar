package Graphism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

import BattleShip.BattleShip;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;


public class TonPlateau extends AbstractPlateau {
	private int xInit;
	private int yInit;

	 ArrayList<AbstractBateau> al;
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	public TonPlateau(int posx, int posy, ArrayList<AbstractBateau> al) {
		super(posx, posy);
		this.al=al;
		// TODO Auto-generated constructor stub
	}

	int index=0;
	@Override
	
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP){
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Component v;
		int varx,vary;
			

			Component c = Plateau.findComponentAt(e.getX(), e.getY());
			this.xInit = (e.getX() / ((c.getWidth())))+1;
	        this.yInit = (e.getY() / ((c.getHeight())))+1;
	        Coord coord = new Coord(xInit,yInit);
	        System.out.println(coord.x +" " + coord.y);
	        varx = coord.x * ((c.getWidth()));
        	vary = coord.y * ((c.getWidth()));
        	v = Plateau.findComponentAt(varx, vary);
         	v.setBackground(Color.red);		
	}

}

