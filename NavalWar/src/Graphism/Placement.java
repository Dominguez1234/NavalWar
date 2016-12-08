package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;

public class Placement {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField UnDeux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Placement window = new Placement();
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
	public Placement() {
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
		ImageIcon image = new ImageIcon("C:/Users/mathieu.pierluigi/Desktop/Fond.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(0, 0, 944, 501);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
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
        
        //Chiffre à gauche
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
    
		
		
		//Plateau
		JPanel Plateau = new JPanel();
		Plateau.setBounds(91, 138, 325, 325);
		panel.add(Plateau);
		Plateau.setBorder(new LineBorder(Color.BLACK));
		Plateau.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			Plateau.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}

		
		//Plateau
		frame.getContentPane().add(panel);
		frame.setBounds(100, 100, 450, 300);
		frame.setBackground(new Color(0, 153, 204));
		frame.setSize(960,540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		
		//Listener et bouton du bouton démarrer
		JButton btnModeStandard = new JButton("Demarrer");
		btnModeStandard.setBounds(579, 231, 240, 80);
		panel.add(btnModeStandard);
		btnModeStandard.setFont(new Font("Battleground", Font.PLAIN, 40));
		btnModeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add( label );
		panel.setBounds(0, 0, 944, 501);
	}
}
