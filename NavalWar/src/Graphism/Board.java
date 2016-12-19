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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;

import javax.swing.JTextArea;


public class Board implements MouseListener, MouseMotionListener, Observer, KeyListener{

	private JFrame frame;
	public JPanel square;
	public JPanel panel;
	int xInit;
	int yInit;
	AbstractBateau abs1 = new AbstractBateau();
	AbstractBateau abs2 = new AbstractBateau();
	AbstractBateau abs3 = new AbstractBateau();
	AbstractBateau abs4 = new AbstractBateau();
	AbstractBateau abs5 = new AbstractBateau();
	ArrayList<AbstractBateau> al= new ArrayList();
	Bateau.direction dir = Bateau.direction.verticale;
	
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
		frame.addKeyListener(this);
		panel.addMouseMotionListener(this);
		//panel.add(scrollPane);
		
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
		
		//textArea.setBounds(31, 304, 200, 100);		
		//frame.getContentPane().add(textArea);
		//textArea.add(scrollPane);
		
		for(Object o : al){
			System.out.println("Placer le "+((AbstractBateau) o).getNom()+"\n");
		}
	
	}
	
	int nb=0;
	int index=0;
	boolean placement=false;
	public void mouseClicked(MouseEvent e) {
		int varx,vary;
		boolean co_Valid=true;
		Component v;
		//quand on clique sur une case, elle devient verte
			ArrayList<Coord> coo;
			System.out.println(e.getX() + " " + e.getY());
			Component c = panel.findComponentAt(e.getX(), e.getY());
			this.xInit = (e.getX() / ((c.getWidth())));
	        this.yInit = (e.getY() / ((c.getHeight())));
	        Coord coord = new Coord(xInit,yInit);
	        System.out.println(xInit + " " + yInit);
	        coo = al.get(index).calculPositions(coord, dir);	
	        System.out.println("\n\n"+coo+"\n");
	        for(Coord o: coo){
	        	co_Valid &= o.coordonnees_valides();
	        	System.out.println(co_Valid);
	        	}
	        if(co_Valid==true){
	        for(Coord o: coo){
	        	varx = o.x * ((c.getWidth()));
	        	vary = o.y * ((c.getWidth()));
	        	v = panel.findComponentAt(varx, vary);
	         	v.setBackground(Color.green);
	         	
	         	//System.out.println("Placer le "+al.get(index).getNom()+"\n" +"("+al.get(index).getNbrCases()+" cases)\n");
	        }
	        index++;
	        }
	        else{
	        	System.out.println("replacer bateau");
	        }
				
		}
		
		
	
	public void mousePressed(MouseEvent e){
		

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void mouseDragged(MouseEvent e) {
	
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
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dir = Bateau.direction.verticale;
			}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dir= Bateau.direction.horizontale;
		}
		else{}
	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}	
