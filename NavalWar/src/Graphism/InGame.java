package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextPane;

import tools.BoatImageProvider;
import BattleShip.BattleShip;
import BattleShip.Coord;
import BattleShip.Flotte;
import Boats.AbstractBateau;
import Boats.Bateau;

import javax.swing.JComboBox;

public class InGame implements MouseListener, MouseMotionListener, Observer, KeyListener {

	JFrame frame;
	public JPanel square;
	public JPanel panel;
	public JPanel monJeu;
	public JPanel SonJeu;
	public JTextArea textArea;
	int xInit;
	int yInit;
	AbstractBateau abs1 = new AbstractBateau();
	AbstractBateau abs2 = new AbstractBateau();
	AbstractBateau abs3 = new AbstractBateau();
	AbstractBateau abs4 = new AbstractBateau();
	AbstractBateau abs5 = new AbstractBateau();
	ArrayList<AbstractBateau> al= new ArrayList();
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	Flotte flotte = new Flotte();
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	// ------------------	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InGame window = new InGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public InGame() throws FontFormatException, IOException {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	private void initialize() throws FontFormatException, IOException {
		// ************* POLICE **************
				//Cr�ation de la police BattlegroundBig avec la taille
			    Font BattlegroungBig = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(75f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //Enregistrement de la police BattlegroundBig
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
			    
			    //Cr�ation de la police BattlegroundMedium avec la taille
			    Font BattlegroundMedium = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(47f);
			    GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //Enregistrement de la police BattlegroundBig
			    ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
			    
			    //Cr�ation de la police v avec la taille
			    Font BattlegroundSmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")).deriveFont(35f);
			    GraphicsEnvironment ge11 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //Enregistrement de la police BattlegroundSmall
			    ge11.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Battleground.ttf")));
			    // ***********************************
			    
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 153, 204));		
		frame.getContentPane().setLayout(null);

		
		al.add(abs1 = bs.getAbstractBateau("Porte-Avions"));
		al.add(abs2 = bs.getAbstractBateau("Croiseur"));
		al.add(abs3 = bs.getAbstractBateau("Sous-Marin"));		
		al.add(abs4 = bs.getAbstractBateau("Destroyer"));
		al.add(abs5 = bs.getAbstractBateau("Patrouilleur"));
		
		//Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setFont(new Font("Battleground", Font.PLAIN, 75));
		lblNavalWar.setBounds(360, 10, 240, 80);		
		frame.getContentPane().add(lblNavalWar);
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(new Font("Battleground", Font.PLAIN, 47));
		lblBattleShip.setBounds(330, 50, 300, 80);		
		frame.getContentPane().add(lblBattleShip);
		
		//Image de fond
		ImageIcon image = new ImageIcon("img/Fond.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(0, 0, 944, 501);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 475, 124, 19);
		comboBox.addItem("Missile");
		comboBox.addItem("Torpille");
		comboBox.addItem("Nuke");
		comboBox.addItem("Option 4");
		panel.add(comboBox);
		
		txtMap = new JTextField();
		txtMap.setText("Map");
		txtMap.setBounds(761, 475, 114, 19);
		panel.add(txtMap);
		txtMap.setColumns(10);
		
		txtMonJeu = new JTextField();
		txtMonJeu.setText("Mon Jeu");
		txtMonJeu.setBounds(271, 475, 114, 19);
		panel.add(txtMonJeu);
		txtMonJeu.setColumns(10);
		
//		textArea = new JTextArea();
//		textArea.setBounds(579, 379, 245, 80);
//		textArea.setText("Appuyez sur les fleches haut/bas \n"
//				+ "pour changer de sens");
//		//textArea.setEditable(false);
//		panel.add(textArea);
		
		
		//Lettres du dessus
		JPanel Lettres = new JPanel();
		Lettres.setBounds(91, 107, 325, 26);
		panel.add(Lettres);
		Lettres.setOpaque(false);
		
		GridLayout grilleLettres = new GridLayout(0, 10);
		Lettres.setLayout(grilleLettres);
		JLabel[] lbls = new JLabel[10];
		String[] labelLettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            lbls[i] = new JLabel("    " + labelLettres[i] + "");
            Lettres.add(lbls[i]);

        }
        
		JPanel tLettres = new JPanel();
		tLettres.setBounds(550, 107, 325, 26);
		panel.add(tLettres);
		tLettres.setOpaque(false);
		
		GridLayout tgrilleLettres = new GridLayout(0, 10);
		tLettres.setLayout(tgrilleLettres);
		JLabel[] tlbls = new JLabel[10];
		String[] tlabelLettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
            tlbls[i] = new JLabel("    " + tlabelLettres[i] + "");
            tLettres.add(tlbls[i]);

        }
        
        //Chiffre � gaucheframe
  		JPanel Chiffres = new JPanel();
  		Chiffres.setBounds(58, 138, 26, 325);
  		panel.add(Chiffres);
  		Chiffres.setOpaque(false);
  		
  		GridLayout grilleChiffres = new GridLayout(10, 0);
  		Chiffres.setLayout(grilleChiffres);
  		JLabel[] lbls1 = new JLabel[10];
  		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
          for (int i = 0; i < 10; i++) {
              lbls1[i] = new JLabel(num[i] + "");
              Chiffres.add(lbls1[i]);
          }		
  		
    		JPanel tChiffres = new JPanel();
      		tChiffres.setBounds(518, 138, 26, 325);
      		panel.add(tChiffres);
      		tChiffres.setOpaque(false);
      		
      		GridLayout tgrilleChiffres = new GridLayout(10, 0);
      		tChiffres.setLayout(tgrilleChiffres);
      		JLabel[] tlbls1 = new JLabel[10];
      		int[] tnum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
              for (int i = 0; i < 10; i++) {
                  tlbls1[i] = new JLabel(tnum[i] + "");
                  tChiffres.add(tlbls1[i]);
              }		
  		

		
		//Affiche la grille de mon jeu
		monJeu = new JPanel();
		monJeu.setBounds(91, 138, 325, 325);
		panel.add(monJeu);
		monJeu.setBorder(new LineBorder(Color.BLACK));
		monJeu.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			monJeu.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
//		monJeu.addMouseListener(this);
//		monJeu.addMouseMotionListener(this);
		
		// Affiche son jeu
		SonJeu = new JPanel();
		SonJeu.setBounds(550, 138, 325, 325);
		panel.add(SonJeu);
		SonJeu.setBorder(new LineBorder(Color.BLACK));
		SonJeu.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			SonJeu.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		SonJeu.addMouseListener(this);
		SonJeu.addMouseMotionListener(this);
		
		//fenetre
		frame.getContentPane().add(panel);
		frame.setBounds(100, 100, 450, 300);
		frame.setBackground(new Color(0, 153, 204));
		frame.setSize(960,540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);

	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	int index=0;
	private JTextField txtMonJeu;
	private JTextField txtMap;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Component c = SonJeu.findComponentAt(e.getX(), e.getY());
		this.xInit = (e.getX() / ((c.getWidth())))+1;
        this.yInit = (e.getY() / ((c.getHeight())))+1;
        Coord coord = new Coord(xInit,yInit);
        System.out.println(xInit + " " + yInit);
        flotte.fire(coord);
        c.setBackground(Color.darkGray);

	}

				
	
		

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
