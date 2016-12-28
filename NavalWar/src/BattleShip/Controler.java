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

public class Controler extends JFrame implements Observer {
	
	BattleShip bs = null;
	JPanel accueil;
	JPanel placement;
	
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
		
//		accueil = new Accueil(this);
		accueil = new Game2();
		
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
		JPanel placement = null;
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
	public void changeToGame() {
		System.out.println("\nYa rien pour le moment mdr\nTu peux pas jouer. Tu vas faire quoi ?\nTocard");
	}

	
}
