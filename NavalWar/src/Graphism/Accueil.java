package Graphism;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BattleShip.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JFrame frame;
	private JTextField UsernameField;
	private JTextField IPAddrField;
	
	private Controler controler;
	
	public MonObservable monObservable = new MonObservable();

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Accueil() throws FontFormatException, IOException {
		super();
		initialize();
	}
	
	public Accueil(Controler fenetreMere) throws FontFormatException, IOException {
		this();
		this.controler = fenetreMere;
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
		label.setBounds(0, 0, 960, 511);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		final JButton btnConnect = new JButton("Connect");
		btnConnect.setEnabled(false);
		btnConnect.setFont(BattlegroundSmall);
		btnConnect.setBounds(625, 181, 150, 34);
		panel.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				bs.connexion("127.0.0.1");
//				System.out.println(IPAddrField.getText());
//				controler.connexionReseau(IPAddrField.getText());
				controler.connexionReseau("127.0.0.1");
			}
			
		});
		
		//Listener et bouton du mode standard
		final JButton btnModeStandard = new JButton("Mode standard");
		btnModeStandard.setBounds(360, 310, 240, 80);
		panel.add(btnModeStandard);
		btnModeStandard.setFont(BattlegroundSmall);
		
		JLabel lblIPAddr = new JLabel("IP Address:");
		lblIPAddr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIPAddr.setBounds(360, 136, 184, 34);
		panel.add(lblIPAddr);
		
		//Label du nom
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(360, 220, 184, 34);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		//Listener et bouton du mode worms
		final JButton btnModeWorms = new JButton("Mode worms");
		btnModeWorms.setBounds(360, 396, 240, 80);
		panel.add(btnModeWorms);
		btnModeWorms.setFont(BattlegroundSmall);
		
		panel.add(label);
		panel.setBounds(0, 0, 960, 511);
		
		this.add(panel);
		
		//Champ de nom
		UsernameField = new JTextField();
		UsernameField.setBounds(360, 265, 240, 34);
		panel.add(UsernameField);
		UsernameField.setColumns(10);
		
		IPAddrField = new JTextField();
		IPAddrField.setColumns(10);
		IPAddrField.setBounds(360, 181, 240, 34);
		panel.add(IPAddrField);
		
		// Boutons choix mode
		btnModeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controler.choixModeJeu(BattleShip.modeJeu.NORMAL);
				btnConnect.setEnabled(true);
				btnModeWorms.setEnabled(false);
				btnModeStandard.setBackground(new Color(86, 255, 94));
			}
		});
		
		btnModeWorms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controler.choixModeJeu(BattleShip.modeJeu.TOTALWAR);
				btnConnect.setEnabled(true);
				btnModeStandard.setEnabled(false);
				btnModeWorms.setBackground(new Color(86, 255, 94));
			}
		});
				
		IPAddrField.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    changed();
			  }

			  public void changed() {
			     if (IPAddrField.getText().equals("")){
			    	 btnConnect.setEnabled(false);
			     }
			     else {
			    	 btnConnect.setEnabled(true);
			    }

			  }
			});
		
		
	}


}