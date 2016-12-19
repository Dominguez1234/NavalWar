package Graphism;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BattleShip.BattleShip;

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
	
	private JFrame maman;
	
	public MonObservable monObservable = new MonObservable();
			
//	public class MonObservable extends Observable {
//		public void envoie() {
//			this.setChanged();
//			this.notifyObservers();
//		}
//	};
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Accueil window = new Accueil();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		super();
		initialize();
	}
	
	
	public Accueil(Observer observer) {
		this();
		this.monObservable.addObserver(observer);
	}
	
	public Accueil(JFrame fenetreMere) {
		this();
		this.maman = fenetreMere;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(Color.WHITE);		
		this.setLayout(null);
		
		//Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setFont(new Font("fonts/Battleground.ttf", Font.PLAIN, 50));
		lblNavalWar.setBounds(360, 10, 240, 80);		
		//frame.getContentPane().add(lblNavalWar);
		this.add(lblNavalWar);
		
		
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(new Font("Battleground", Font.PLAIN, 30));
		lblBattleShip.setBounds(330, 50, 300, 80);		
//		frame.getContentPane().add(lblBattleShip);
		this.add(lblBattleShip);
		
		//Image de fond
		ImageIcon image = new ImageIcon("img/Fond.png"); 
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(0, 0, 960, 511);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		final JButton btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Battleground", Font.PLAIN, 30));
		btnConnect.setBounds(625, 181, 150, 34);
		panel.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				bs.connexion("127.0.0.1");
				System.out.println(IPAddrField.getText());
			}
			
		});
		
		//Listener et bouton du mode standard
		JButton btnModeStandard = new JButton("Mode standard");
		btnModeStandard.setBounds(360, 310, 240, 80);
		panel.add(btnModeStandard);
		btnModeStandard.setFont(new Font("Battleground", Font.PLAIN, 40));
		btnModeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
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
		JButton btnModeWorms = new JButton("Mode worms");
		btnModeWorms.setBounds(360, 396, 240, 80);
		panel.add(btnModeWorms);
		btnModeWorms.setFont(new Font("Battleground", Font.PLAIN, 40));
		btnModeWorms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("clic! worms");
				monObservable.myNotify();
			}
		});
		panel.add(label);
		panel.setBounds(0, 0, 960, 511);
		
		
//		frame.getContentPane().add(panel);
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
//		frame.setBounds(100, 100, 450, 300);
//		frame.setBackground(new Color(0, 153, 204));
//		frame.setSize(960,540);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		this.add(panel);
		
				
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