package Graphism;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BattleShip.BattleShip;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;
import tools.BoatImageProvider;

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
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		super.mouseMoved(e);
		
		Component v;
		int varx,vary,i;
		
//		for(i=0;i<100;i++) {
//			
//		}
		
		Component c = plateau.findComponentAt(e.getX(), e.getY());
		this.xInit = (e.getX() / ((c.getWidth())))+1;
        this.yInit = (e.getY() / ((c.getHeight())))+1;
        Coord coord = new Coord(xInit,yInit);
        System.out.println(coord.x +" " + coord.y);
        varx = coord.x * ((c.getWidth()));
    	vary = coord.y * ((c.getWidth()));
    	v = plateau.findComponentAt(varx, vary);
     	v.setBackground(Color.GRAY);		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Component v;
		int varx,vary;
			

			Component c = plateau.findComponentAt(e.getX(), e.getY());
			this.xInit = (e.getX() / ((c.getWidth())))+1;
	        this.yInit = (e.getY() / ((c.getHeight())))+1;
	        Coord coord = new Coord(xInit,yInit);
	        System.out.println(coord.x +" " + coord.y);
	        varx = coord.x * ((c.getWidth()));
        	vary = coord.y * ((c.getWidth()));
        	v = plateau.findComponentAt(varx, vary);
         	v.setBackground(Color.red);		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

