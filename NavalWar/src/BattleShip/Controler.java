package BattleShip;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Boats.AbstractBateau;
import Boats.Bateau;
import Boats.Patrouilleur;
import Boats.PorteAvions;
import Graphism.*;
import Weapon.Arme;

public class Controler extends JFrame implements Observer {
	
	BattleShip bs = null;
	JPanel accueil;
	JPanel placement;
	BoardDeux board;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame p = new Controler();
					p.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Controler() throws FontFormatException, IOException {
		
		this.setResizable(false);
		this.setBackground(Color.WHITE);
		
		this.setBounds(100, 100, 450, 300);
		this.setSize(960,540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		accueil = new Accueil(this);
//		accueil = new Game2();
//		accueil = new BoardDeux();
		
		this.add(accueil);
		
	}


	@Override
	public void update(Observable o, Object arg) {
		System.out.println("j'ai été notifié - "+arg);
	}

	public void choixModeJeu(BattleShip.modeJeu mode) {
		bs = new BattleShip(mode);
		System.out.println("Choix mode de jeu : "+mode+"\n\n"+bs);
	}
	
	public void connexionReseau(String ip) {
		if(bs.connexion(ip)) {
			this.changeToPlacement();
		}
	}
	
	// ----- ACCUEIL -----
	
	// Passage de l'accueil vers le placement
	public void changeToPlacement() {
		try {
			placement = new PlacementB2(this);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.remove(accueil);
		this.add(placement);
		this.revalidate();
		this.repaint();
		
		System.out.println("Changement de JPanel => Placement");
	}
	
	
	// ----- PLACEMENT -----
	
	public AbstractBateau getAbstractBateau(String nom) {
		return bs.getAbstractBateau(nom);
	}
	
	// Modifier la position d'un bateau
		public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
			bs.setPosBoat(nom, posOrigine, sens);
		}
	
	public boolean isSomethingHere(Coord c) {
		return bs.isSomethingHere(c);
	}
	
	// Passage du placement au plateau de jeu
	public void changeToBoard() {
		try {
			board = new BoardDeux(this);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.remove(placement);
		this.add(board);
		this.revalidate();
		this.repaint();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.lancement();
	}
	
	
	// ----- JEU -----
	
	// Wait Adversaire
	public boolean waitAdversaire() {
		return bs.waitAdversaire();
	}
	
	// Retourne la grille de Touche
	public Touche[][] getTouches(Ocean.joueur cible) {
		return bs.getTouches(cible);
	}
	
	public boolean jAttaque(Coord cible, String arme, Arme.Sens sens) {
		boolean result = false;
		
		try {
			result = bs.jAttaque(cible, arme, sens);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		board.resetGrilles();
		this.jAttendsLattaque();
		return result;
	}
	
	public boolean jAttendsLattaque() {
		boolean result = false;
		
		try {
			Thread.sleep(500);
			System.out.println("Wait before");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result = bs.jAttendsLattaque();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		board.resetGrilles();
		
		try {
			Thread.sleep(500);
			System.out.println("Wait after");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void lancement() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Attente de l'autre joueur...");
		if(!bs.waitAdversaire()) {
			System.out.println("L'adversaire commence.");
			jAttendsLattaque();
		} else
			System.out.println("Je commence.");
	}
	
}
