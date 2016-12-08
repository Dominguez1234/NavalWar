package Graphism;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import BattleShip.BattleShip;
import Boats.AbstractBateau;
import Boats.Bateau;

import javax.swing.JTextArea;

public class Board implements MouseListener, MouseMotionListener, Observer{

	private JFrame frame;
	public JPanel square;
	public JPanel panel;
	JTextArea textArea = new JTextArea();
	int xInit;
	int yInit;
	AbstractBateau abs1 = new AbstractBateau();
	AbstractBateau abs2 = new AbstractBateau();
	AbstractBateau abs3 = new AbstractBateau();
	AbstractBateau abs4 = new AbstractBateau();
	AbstractBateau abs5 = new AbstractBateau();
	ArrayList al= new ArrayList();
	
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
					Board window = new Board();
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
	public Board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//panel
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(31, 51, 200, 200);
		frame.getContentPane().add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		
		//création du quadrillage
		for (int i = 0; i < 100; i++) {
            square = new JPanel( new BorderLayout() );
            panel.add( square );
            square.setBorder(new LineBorder(new Color(0, 0, 0)));
 
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(277, 51, 200, 200);
		frame.getContentPane().add(panel_1);
		
		al.add(abs1 = bs.getAbstractBateau("Porte-Avions"));
		al.add(abs2 = bs.getAbstractBateau("Croiseur"));
		al.add(abs3 = bs.getAbstractBateau("Sous-Marin"));		
		al.add(abs4 = bs.getAbstractBateau("Destroyer"));
		al.add(abs5 = bs.getAbstractBateau("Patrouilleur"));
		
		textArea.setBounds(31, 304, 200, 31);
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(textArea);
		textArea.add(scrollPane);
//		for(Object o : al){
//			textArea.setText("Placer le "+((AbstractBateau) o).getNom()+"\n");
//		}

	
	}
	public void mouseClicked(MouseEvent e) {
		//quand on clique sur une case, elle devient verte
		System.out.println(e.getX() + " " + e.getY());		
		Component c = panel.findComponentAt(e.getX(), e.getY());
		this.xInit=e.getX();
		this.yInit=e.getY();
		for(int j =xInit; j< xInit+5;j++){
			c.setBackground(Color.green);
		}
		
		
	}
	public void mousePressed(MouseEvent e){
		Component c = panel.findComponentAt(e.getX(), e.getY());
		c.setBackground(Color.green);

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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		for(int h=0;h<=al.size();h++){
//			textArea.setText("Placer le "+al.get(h)+"\n");
//			h++;
//		}
		for(Object o : al){
			textArea.setText("Placer le "+((AbstractBateau) o).getNom()+"\n");
		}
		
	}
}	
