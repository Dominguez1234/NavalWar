package Graphism;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;


import BattleShip.BattleShip;

import Boats.AbstractBateau;


public class BoardDeux extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel panel;
	public JPanel monPlateau;
	public JPanel mesChiffres;
	public JPanel mesLettres;
	public JPanel tPlateau;
	public JPanel tesChiffres;
	public JPanel tesLettres;
	public static JTextArea textArea;
	public static JButton btnJouer;
	int xInit;
	int yInit;
	ArrayList<AbstractBateau> al = new ArrayList<AbstractBateau>();
	//Bateau.direction dir = Bateau.direction.verticale;
	//String mes = "Horizontal";
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	// ------------------	

	public BoardDeux() throws FontFormatException, IOException {
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
		AbstractPlateau plateau = new MonPlateau(91,138,al);
		AbstractPlateau tonPlateau = new TonPlateau(550,138,al);
		monPlateau = plateau.creationPlateau();
		mesChiffres = plateau.Chiffres();
		mesLettres = plateau.Lettres();
		tPlateau = tonPlateau.creationPlateau();
		tesChiffres = tonPlateau.Chiffres();
		tesLettres = tonPlateau.Lettres();
		
		al.add(bs.getAbstractBateau("Porte-Avions"));
		al.add(bs.getAbstractBateau("Croiseur"));
		al.add(bs.getAbstractBateau("Sous-Marin"));		
		al.add(bs.getAbstractBateau("Destroyer"));
		al.add(bs.getAbstractBateau("Patrouilleur"));
		
		//Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setFont(new Font("Battleground", Font.PLAIN, 75));
		lblNavalWar.setBounds(360, 10, 240, 80);		
		this.add(lblNavalWar);
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(new Font("Battleground", Font.PLAIN, 47));
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
}
