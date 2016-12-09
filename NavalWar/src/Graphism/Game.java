package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Game {

	private JFrame frame;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 204));		
		frame.getContentPane().setLayout(null);
		
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
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setFont(new Font("Battleground", Font.PLAIN, 20));
		lblChat.setBounds(714, 114, 187, 19);
		panel.add(lblChat);
		
		JLabel lblVotreFlotte = new JLabel("Votre flotte");
		lblVotreFlotte.setFont(new Font("Battleground", Font.PLAIN, 20));
		lblVotreFlotte.setBounds(461, 114, 187, 19);
		panel.add(lblVotreFlotte);
		
		JLabel AVous = new JLabel("C'est a vous de jouer.");
		AVous.setFont(new Font("Battleground", Font.PLAIN, 20));
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

		
		frame.getContentPane().add(panel);
		frame.setBounds(100, 100, 450, 300);
		frame.setBackground(new Color(0, 153, 204));
		frame.setSize(960,540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);
		
		JPanel PanelChat = new JPanel();
		PanelChat.setToolTipText("Chat");
		PanelChat.setBounds(714, 139, 173, 324);
		panel.add(PanelChat);
		

		
		
	}
}
