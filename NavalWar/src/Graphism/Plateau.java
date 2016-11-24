package Graphism;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class Plateau {

	private JFrame frame;
	private JTextField TxtNavalWar;
	private JTextField TxtBattleshipGame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plateau window = new Plateau();
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
	public Plateau() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 204));
		
		TxtNavalWar = new JTextField();
		TxtNavalWar.setDropMode(DropMode.ON);
		TxtNavalWar.setHorizontalAlignment(SwingConstants.CENTER);
		TxtNavalWar.setForeground(Color.WHITE);
		TxtNavalWar.setFont(new Font("Battleground", Font.PLAIN, 100));
		TxtNavalWar.setText("NavalWar");
		TxtNavalWar.setOpaque(false);
		TxtNavalWar.setColumns(10);
	
		
		frame.getContentPane().add(TxtNavalWar, BorderLayout.NORTH);
		
		TxtBattleshipGame = new JTextField();
		TxtBattleshipGame.setForeground(Color.WHITE);
		TxtBattleshipGame.setText("BattleShip Game");
		TxtBattleshipGame.setHorizontalAlignment(SwingConstants.CENTER);
		TxtBattleshipGame.setDropMode(DropMode.ON);
		TxtBattleshipGame.setFont(new Font("Battleground", Font.PLAIN, 70));
		frame.getContentPane().add(TxtBattleshipGame, BorderLayout.CENTER);
		TxtBattleshipGame.setColumns(10);
		TxtBattleshipGame.setOpaque(false);

		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960,540);
	}

}
