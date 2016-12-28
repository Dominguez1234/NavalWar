package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Game2 extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Game2() throws FontFormatException, IOException {
		initialize();
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
	    // ***********************************
		
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setFont(new Font("Battleground", Font.PLAIN, 20));
		lblChat.setBounds(714, 114, 187, 19);
		panel.add(lblChat);
		
		JLabel lblVotreFlotte = new JLabel("Votre flotte");
		lblVotreFlotte.setFont(BattlegroundSmall);
		lblVotreFlotte.setBounds(461, 114, 187, 19);
		panel.add(lblVotreFlotte);
		
		JLabel AVous = new JLabel("C'est a vous de jouer.");
		AVous.setFont(BattlegroundSmall);
		AVous.setBounds(92, 77, 187, 19);
		panel.add(AVous);
		
		//Ma Flotte
		JPanel MaFlotte = new JPanel();
		MaFlotte.setBorder(new LineBorder(Color.BLACK));
		MaFlotte.setBounds(461, 138, 200, 200);
		panel.add(MaFlotte);
		MaFlotte.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			MaFlotte.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		
		//Lettres du dessus grille flotte ennemie
		JPanel LettresGridEnnemie = new JPanel();
		LettresGridEnnemie.setBounds(91, 107, 325, 26);
		panel.add(LettresGridEnnemie);
		LettresGridEnnemie.setOpaque(false);
		
		GridLayout gl_LettresGridEnnemie = new GridLayout(0, 10);
		LettresGridEnnemie.setLayout(gl_LettresGridEnnemie);
		JLabel[] lbls = new JLabel[10];
		String[] labelLettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            lbls[i] = new JLabel("    " + labelLettres[i] + "");
            LettresGridEnnemie.add(lbls[i]);
        }
        
        //Chiffre à gauche grille flotte ennemie
  		JPanel ChiffresGridEnnemie = new JPanel();
  		ChiffresGridEnnemie.setBounds(58, 138, 26, 325);
  		panel.add(ChiffresGridEnnemie);
  		ChiffresGridEnnemie.setOpaque(false);
  		
  		GridLayout gl_ChiffresGridEnnemie = new GridLayout(10, 0);
  		ChiffresGridEnnemie.setLayout(gl_ChiffresGridEnnemie);
  		JLabel[] lbls1 = new JLabel[10];
  		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
          for (int i = 0; i < 10; i++) {
              lbls1[i] = new JLabel(num[i] + "");
              ChiffresGridEnnemie.add(lbls1[i]);
          }		
		
		//Plateau
		JPanel FlotteEnnemie = new JPanel();
		FlotteEnnemie.setBounds(91, 138, 325, 325);
		panel.add(FlotteEnnemie);
		FlotteEnnemie.setBorder(new LineBorder(Color.BLACK));
		FlotteEnnemie.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			FlotteEnnemie.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}

		panel.add(label);
		panel.setBounds(0, 0, 960, 540);
		
		this.add(panel);
		
//		JPanel PanelChat = new JPanel();
//		PanelChat.setToolTipText("Chat");
//		PanelChat.setBounds(714, 139, 173, 324);
//		panel.add(PanelChat);
	
	}
}
