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

import Boats.Bateau;
import Boats.Patrouilleur;
import Boats.PorteAvions;
import Graphism.*;

public class Controler extends JFrame implements Observer {
	
	BattleShip bs;
	JPanel accueil;
	
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
		this.getContentPane().setBackground(Color.WHITE);
		
		this.setBounds(100, 100, 450, 300);
		this.setSize(960,540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		accueil = new Accueil(this);
		this.getContentPane().add(accueil);
		
//		JPanel placement = new Placement();
//		this.getContentPane().add(placement);
	}


	@Override
	public void update(Observable o, Object arg) {
		System.out.println("j'ai été notifié - "+arg);
	}

	public void choixModeJeu(BattleShip.modeJeu mode) {
		bs = new BattleShip(mode);
		System.out.println("Choix mode de jeu : "+mode);
	}
	
	public void connexionReseau(String ip) {
		if(bs.connexion(ip)) {
			this.changeToPlacement();
		}
	}
	
	public void changeToPlacement() {
		System.out.println("Changement de JPanel => Placement");
		JPanel placement = new Placement();
		this.removeAll();
		this.getContentPane().add(placement);
		this.repaint();
	}

	
}
