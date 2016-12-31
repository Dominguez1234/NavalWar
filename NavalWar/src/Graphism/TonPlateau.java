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
import BattleShip.Controler;
import BattleShip.Coord;
import BattleShip.Ocean;
import BattleShip.Touche;
import Boats.AbstractBateau;
import Boats.Bateau;
import Weapon.Arme;
import tools.BoatImageProvider;

public class TonPlateau extends AbstractPlateau {
	
	private int xInit;
	private int yInit;
	 ArrayList<AbstractBateau> al;
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	
	public TonPlateau(int posx, int posy, ArrayList<AbstractBateau> al, Controler fenetreMere) {
		super(posx, posy, fenetreMere);
		this.al=al;
		// TODO Auto-generated constructor stub
	}
	
	public void resetPlateau() {
		Touche[][] grille = this.controler.getTouches(Ocean.joueur.ennemi);
		
		int i,j;
		int pos=0;
		
		for(i=0;i<10;i++) {
			for(j=0;j<10;j++) {
				if(grille[i][j].isTouche)
					plateau.getComponent(pos).setBackground(new Color(255,28,28));
				else if(grille[i][j].isTargeted)
					plateau.getComponent(pos).setBackground(new Color(66, 129, 255));
				else
					plateau.getComponent(pos).setBackground(Color.WHITE);
				pos++;
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		this.resetPlateau();
		
		Touche[][] grille = this.controler.getTouches(Ocean.joueur.ennemi);
		
		Component c = plateau.findComponentAt(e.getX(), e.getY());
		Coord coord = new Coord();
		coord.x = (e.getY() / (c.getWidth()));
        coord.y = (e.getX() / (c.getHeight()));
        
        if(coord.coordonnees_valides() && !grille[coord.x][coord.y].isTargeted && !grille[coord.x][coord.y].isTouche) {
        	int pos = ((coord.x)*10) + (coord.y);
        	plateau.getComponent(pos).setBackground(Color.GRAY);	
        }
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Component v;
		int varx,vary;
			
		Touche[][] grille = this.controler.getTouches(Ocean.joueur.ennemi);

		Component c = plateau.findComponentAt(e.getX(), e.getY());
		Coord coord = new Coord();
		coord.x = (e.getY() / (c.getWidth()));
        coord.y = (e.getX() / (c.getHeight()));
        
        if(coord.coordonnees_valides() && !grille[coord.x][coord.y].isTargeted && !grille[coord.x][coord.y].isTouche) {
//        	int pos = ((coord.x)*10) + (coord.y);
//        	plateau.getComponent(pos).setBackground(Color.RED);
//        	if(controler.jAttaque(coord, "Nuke", Arme.Sens.HORIZONTAL))
//        		this.resetPlateau();
        	controler.jAttaque(coord, "Missile", Arme.Sens.HORIZONTAL);
//        	this.resetPlateau();
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

