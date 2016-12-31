package Graphism;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;


import BattleShip.BattleShip;
import BattleShip.Controler;
import BattleShip.Ocean;
import BattleShip.Touche;
import Boats.AbstractBateau;


public class BoardDeux extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Controler controler = null;

	private JPanel panel;
	private JPanel monPlateau;
	private JPanel mesChiffres;
	private JPanel mesLettres;
	private JPanel tPlateau;
	private JPanel tesChiffres;
	private JPanel tesLettres;
	private static JTextArea textArea;
	private static JButton btnJouer;
	
	AbstractPlateau plateau = null;
	AbstractPlateau tonPlateau = null;
	
	int xInit;
	int yInit;
	ArrayList<AbstractBateau> al = new ArrayList<AbstractBateau>();
	
	// ------------------	

	public BoardDeux(Controler fenetreMere, JPanel plateauLocal) throws FontFormatException, IOException {
		this.controler = fenetreMere;
		this.monPlateau = plateauLocal;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	private void initialize() throws FontFormatException, IOException {
		
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
	    // ***********************************
		
		this.setLayout(null);	// A AJOUTER POUR QUE CA FONCTIONNE !!!
		
		plateau = new MonPlateau(91,138,al,controler);
		tonPlateau = new TonPlateau(550,138,al,controler);
		
//		monPlateau = plateau.creationPlateau();
		mesChiffres = plateau.Chiffres();
		mesLettres = plateau.Lettres();
		tPlateau = tonPlateau.creationPlateau();
		tesChiffres = tonPlateau.Chiffres();
		tesLettres = tonPlateau.Lettres();
//		
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
	
		panel.add(monPlateau);
		panel.add(mesChiffres);
		panel.add(mesLettres);
		panel.add(tPlateau).setVisible(true);
		panel.add(tesChiffres).setVisible(true);
		panel.add(tesLettres).setVisible(true);
		panel.setBounds(100, 100, 450, 300);
		
		this.add(panel);
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);

	}
	
	public void resetGrilles() {
		tonPlateau.resetPlateau();	// Pour la grille ennemie
		
		// Pour la grille locale
		Touche[][] grille = this.controler.getTouches(Ocean.joueur.moi);
		
		int i,j;
		int pos=0;
		
		for(i=0;i<10;i++) {
			for(j=0;j<10;j++) {
				if(grille[i][j].isTouche)
					monPlateau.getComponent(pos).setBackground(new Color(255,28,28));
				else if(grille[i][j].isTargeted)
					monPlateau.getComponent(pos).setBackground(new Color(66, 129, 255));
				else
					monPlateau.getComponent(pos).setBackground(Color.WHITE);
				pos++;
			}
		}
	}
}
