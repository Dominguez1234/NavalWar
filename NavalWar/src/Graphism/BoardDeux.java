package Graphism;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
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
	private JComboBox combo = new JComboBox();
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

	    combo.setBounds(91, 475, 100, 20);;

		
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
		
		textArea = new JTextArea();
		textArea.setBounds(579, 379, 245, 80);
		textArea.setText("Utilisez les fleches haut/bas \n" + "pour changer de sens");	
		textArea.setEditable(false);
		panel.add(textArea);
		panel.add(combo).setVisible(false);;
	
		panel.add(monPlateau);
		panel.add(mesChiffres);
		panel.add(mesLettres);
		panel.add(tPlateau).setVisible(false);
		panel.add(tesChiffres).setVisible(false);
		panel.add(tesLettres).setVisible(false);
		panel.setBounds(100, 100, 450, 300);
		this.add(panel);
		
		//Listener et bouton du bouton dï¿½marrer
		btnJouer = new JButton("Jouez");
		btnJouer.setEnabled(false);
		btnJouer.setBounds(579, 231, 240, 80);
		panel.add(btnJouer);
		btnJouer.setFont(new Font("Battleground", Font.PLAIN, 40));
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel.remove(btnJouer);
				panel.remove(textArea);
				tPlateau.setVisible(true);
				tesChiffres.setVisible(true);
				tesLettres.setVisible(true);
				combo.setVisible(true);
				panel.setVisible(true);
				
			}
		});
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);

	}
}
