package BattleShip;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Boats.Bateau;
import Boats.Patrouilleur;
import Boats.PorteAvions;
import Graphism.*;

public class TEst3 extends JFrame implements Observer {
	
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFrame p = new TEst3();
					p.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TEst3() {
		
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);		
		// this.getContentPane().setLayout(null);
		
		this.setBounds(100, 100, 450, 300);
		this.setSize(960,540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel accueil = new Accueil((JFrame) this);
		this.getContentPane().add(accueil);
	}


	@Override
	public void update(Observable o, Object arg) {
		System.out.println("j'ai été notifié - "+arg);
	}



	
}
