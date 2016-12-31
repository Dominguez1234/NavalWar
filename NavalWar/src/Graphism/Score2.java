package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BattleShip.Controler;
import BattleShip.Ocean;

import javax.swing.JToggleButton;
import javax.swing.JButton;

public class Score2 extends JPanel {

	private Controler controler = null;
	
	JLabel lblNomGagnant = new JLabel("NomGagnant");
	JLabel lblScoreGagnant = new JLabel("SCORE");
	JLabel lblNomPerdant = new JLabel("NomPerdant");
	JLabel lblScorePerdant = new JLabel("SCORE");
	
	Ocean.joueur winner;
	Ocean.joueur loser;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Score2(Controler fenetreMere) throws FontFormatException, IOException {
		initialize();
		this.controler = fenetreMere;
		calculScore();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	private void initialize() throws FontFormatException, IOException {
		
		this.setLayout(null);	// A AJOUTER POUR QUE CA FONCTIONNE !!!
		
		// ************* POLICE **************
		//Création de la police BattlegroundBig avec la taille
	    Font BattlegroungBig = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(75f);
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    //Enregistrement de la police BattlegroundBig
	    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
	    
	    //Création de la police BattlegroundMedium avec la taille
	    Font BattlegroundMedium = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(47f);
	    GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    //Enregistrement de la police BattlegroundBig
	    ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
	    
	    //Création de la police v avec la taille
	    Font BattlegroundSmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(35f);
	    GraphicsEnvironment ge11 = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    //Enregistrement de la police BattlegroundSmall
	    ge11.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
		
	    //Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setFont(BattlegroungBig);
		lblNavalWar.setBounds(360, 10, 240, 80);		
		this.add(lblNavalWar);
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(BattlegroundMedium);
		lblBattleShip.setBounds(330, 50, 300, 80);		
		this.add(lblBattleShip);
		
		//Image de fond
		ImageIcon image = new ImageIcon("img/Fond.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(0, 0, 944, 501);
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Champ du nom du gagnat
		lblNomGagnant.setForeground(new Color(245, 255, 250));
		lblNomGagnant.setBackground(new Color(144, 238, 144));
		lblNomGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomGagnant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		lblNomGagnant.setToolTipText("");
		lblNomGagnant.setBounds(240, 170, 240, 80);
		lblNomGagnant.setOpaque(true);
		this.add(lblNomGagnant);
		
		//Champ du score du gagnant
		lblScoreGagnant.setForeground(new Color(144, 238, 144));
		lblScoreGagnant.setOpaque(true);
		lblScoreGagnant.setBackground(new Color(255, 255, 240));
		lblScoreGagnant.setBounds(480, 170, 240, 80);
		lblScoreGagnant.setToolTipText("");
		lblScoreGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreGagnant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		this.add(lblScoreGagnant);
		
		//Champ du nom du perdant
		lblNomPerdant.setOpaque(true);
		lblNomPerdant.setForeground(new Color(255, 255, 255));
		lblNomPerdant.setBackground(new Color(240, 128, 128));
		lblNomPerdant.setBounds(240, 260, 240, 80);
		lblNomPerdant.setToolTipText("");
		lblNomPerdant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomPerdant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		this.add(lblNomPerdant);
		
		//Champ du score du perdant
		lblScorePerdant.setOpaque(true);
		lblScorePerdant.setBackground(new Color(255, 255, 240));
		lblScorePerdant.setForeground(new Color(240, 128, 128));
		lblScorePerdant.setBounds(480, 260, 240, 80);
		lblScorePerdant.setToolTipText("");
		lblScorePerdant.setHorizontalAlignment(SwingConstants.CENTER);
		lblScorePerdant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		this.add(lblScorePerdant);
		
		//Bouton quitter
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnQuitter.setBounds(350, 360, 240, 80);
		this.add(btnQuitter);
		btnQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.fermerJeu();
			}
			
		});
		
	}
	
	private void calculScore() {
		Ocean.joueur winner = controler.getWinner();
		
		this.winner = controler.getWinner();
		
		if(this.winner.equals(Ocean.joueur.moi))
			this.loser = Ocean.joueur.ennemi;
		else
			this.loser = Ocean.joueur.moi;
		
		changeNomLabel(lblNomGagnant, true);
		changeNomLabel(lblNomPerdant, false);
		
		changeScoreLabel(lblScoreGagnant, true);
		changeScoreLabel(lblScorePerdant, false);
	}
	
	private void changeNomLabel(JLabel label, boolean afficherGagnant) {
		if(afficherGagnant) {
			if(this.winner.equals(Ocean.joueur.moi))
				label.setText("Vous");
			else
				label.setText("Adversaire");
		} else {
			if(this.winner.equals(Ocean.joueur.moi))
				label.setText("Adversaire");
			else
				label.setText("Vous");
		}
	}
	
	private void changeScoreLabel(JLabel label, boolean afficherGagnant) {
		if(afficherGagnant)
			label.setText(""+controler.getRatio(this.winner));
		else
			label.setText(""+controler.getRatio(this.loser));
	}
}
