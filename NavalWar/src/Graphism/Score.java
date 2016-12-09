package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class Score {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score window = new Score();
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
	public Score() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(30, 144, 255));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);		
		frame.getContentPane().setLayout(null);
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(new Font("Battleground", Font.PLAIN, 47));
		lblBattleShip.setBounds(330, 50, 300, 80);		
		frame.getContentPane().add(lblBattleShip);
		
		//Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setBounds(0, 0, 960, 88);
		frame.getContentPane().add(lblNavalWar);
		lblNavalWar.setFont(new Font("Battleground", Font.PLAIN, 75));
		
		//Champ du nom du gagnat
		JLabel lblNomGagnant = new JLabel("NomGagnant");
		lblNomGagnant.setForeground(new Color(245, 255, 250));
		lblNomGagnant.setBackground(new Color(144, 238, 144));
		lblNomGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomGagnant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		lblNomGagnant.setToolTipText("");
		lblNomGagnant.setBounds(240, 170, 240, 80);
		lblNomGagnant.setOpaque(true);
		frame.getContentPane().add(lblNomGagnant);
		
		//Champ du score du gagnant
		JLabel lblScoreGagnant = new JLabel("SCORE");
		lblScoreGagnant.setForeground(new Color(144, 238, 144));
		lblScoreGagnant.setOpaque(true);
		lblScoreGagnant.setBackground(new Color(255, 255, 240));
		lblScoreGagnant.setBounds(480, 170, 240, 80);
		frame.getContentPane().add(lblScoreGagnant);
		lblScoreGagnant.setToolTipText("");
		lblScoreGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreGagnant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		
		//Champ du nom du perdant
		JLabel lblNomPerdant = new JLabel("NomPerdant");
		lblNomPerdant.setOpaque(true);
		lblNomPerdant.setForeground(new Color(255, 255, 255));
		lblNomPerdant.setBackground(new Color(240, 128, 128));
		lblNomPerdant.setBounds(240, 260, 240, 80);
		frame.getContentPane().add(lblNomPerdant);
		lblNomPerdant.setToolTipText("");
		lblNomPerdant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomPerdant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		
		//Champ du score du perdant
		JLabel lblScorePerdant = new JLabel("SCORE");
		lblScorePerdant.setOpaque(true);
		lblScorePerdant.setBackground(new Color(255, 255, 240));
		lblScorePerdant.setForeground(new Color(240, 128, 128));
		lblScorePerdant.setBounds(480, 260, 240, 80);
		frame.getContentPane().add(lblScorePerdant);
		lblScorePerdant.setToolTipText("");
		lblScorePerdant.setHorizontalAlignment(SwingConstants.CENTER);
		lblScorePerdant.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		
		//Bouton rejouer
		JButton btnRejouer = new JButton("Rejouer");
		btnRejouer.setFont(new Font("Dialog", Font.PLAIN, 40));
		btnRejouer.setBounds(220, 360, 240, 80);
		frame.getContentPane().add(btnRejouer);
		
		//Bouton quitter
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(500, 360, 240, 80);
		frame.getContentPane().add(btnQuitter);
		btnQuitter.setFont(new Font("Dialog", Font.PLAIN, 40));
		
		//Image de fond
		ImageIcon image = new ImageIcon("img/Fond.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add( label, BorderLayout.CENTER );
		panel.setBounds(0, 0, 960, 540);
				
				
		frame.getContentPane().add(panel);
		frame.setBounds(100, 100, 450, 300);
		frame.setBackground(new Color(0, 153, 204));
		frame.setSize(960,540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
