package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import BattleShip.BattleShip;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;

public class PlacementB extends JPanel implements MouseListener, MouseMotionListener, Observer, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	JFrame frame;
	public JPanel square;
	public JPanel panel;
	public JPanel Plateau;
	public JTextArea textArea;
	int xInit;
	int yInit;
	ArrayList<AbstractBateau> al = new ArrayList<AbstractBateau>();
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	// ------------------	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Placement window = new Placement();
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
	public PlacementB() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(0, 153, 204));		
//		frame.getContentPane().setLayout(null);
		
		this.setLayout(null);	// A AJOUTER POUR QUE CA FONCTIONNE !!!
		
		al.add(bs.getAbstractBateau("Porte-Avions"));
		al.add(bs.getAbstractBateau("Croiseur"));
		al.add(bs.getAbstractBateau("Sous-Marin"));		
		al.add(bs.getAbstractBateau("Destroyer"));
		al.add(bs.getAbstractBateau("Patrouilleur"));
		
		//Label NavalWar
		JLabel lblNavalWar = new JLabel("NavalWar", SwingConstants.CENTER);
		lblNavalWar.setFont(new Font("Battleground", Font.PLAIN, 75));
		lblNavalWar.setBounds(360, 10, 240, 80);		
//		frame.getContentPane().add(lblNavalWar);
		this.add(lblNavalWar);
		
		//Label Battleship Game
		JLabel lblBattleShip = new JLabel("Battleship Game", SwingConstants.CENTER);
		lblBattleShip.setFont(new Font("Battleground", Font.PLAIN, 47));
		lblBattleShip.setBounds(330, 50, 300, 80);		
//		frame.getContentPane().add(lblBattleShip);
		this.add(lblBattleShip);
		
		//Image de fond
		ImageIcon image = new ImageIcon("img/Fond.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(0, 0, 944, 501);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(579, 379, 245, 80);
		textArea.setEditable(false);
		panel.add(textArea);
		
		JLabel lblClicDroitSur = new JLabel("Appuyez sur les fl�ches haut et bas pour changer le sens");
		lblClicDroitSur.setFont(new Font("Battleground", Font.PLAIN, 30));
		lblClicDroitSur.setBounds(490, 165, 400, 50);
//		panel.add(lblClicDroitSur);
		
		
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
        
        //Chiffre � gaucheframe
  		JPanel Chiffres = new JPanel();
  		Chiffres.setBounds(58, 138, 26, 325);
  		panel.add(Chiffres);
  		Chiffres.setOpaque(false);
  		
  		GridLayout grilleChiffres = new GridLayout(10, 0);
  		Chiffres.setLayout(grilleChiffres);
  		JLabel[] lbls1 = new JLabel[10];
	      for (int i = 0; i < 10; i++) {
	          lbls1[i] = new JLabel(i+1 + "");
	          Chiffres.add(lbls1[i]);
	      }		
		
		//Plateau
		Plateau = new JPanel();
		Plateau.setBounds(91, 138, 325, 325);
		Plateau.setBorder(new LineBorder(Color.BLACK));
		Plateau.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			Plateau.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}

		Plateau.addMouseListener(this);

		Plateau.addMouseMotionListener(this);
		panel.add(Plateau);
		//Plateau
//		frame.getContentPane().add(panel);
//		frame.setBounds(100, 100, 450, 300);
//		frame.setBackground(new Color(0, 153, 204));
//		frame.setSize(960,540);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.addKeyListener(this);
//		frame.setFocusable(true);
		panel.setBounds(100, 100, 450, 300);
		this.add(panel);
		
		//Listener et bouton du bouton d�marrer
		JButton btnModeStandard = new JButton("Demarrer");
		btnModeStandard.setBounds(579, 231, 240, 80);
		panel.add(btnModeStandard);
		btnModeStandard.setFont(new Font("Battleground", Font.PLAIN, 40));
		btnModeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dir= Bateau.direction.horizontale;
			mes="Vertical";
			textArea.setText("sens : " + mes +"\nPlacer le "+al.get(index).getNom()+"\n" +"("+al.get(index).getNbrCases()+" cases)\n");
			}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dir = Bateau.direction.verticale;
			mes="Horizontal";
			textArea.setText("sens : " + mes +"\nPlacer le "+al.get(index).getNom()+"\n" +"("+al.get(index).getNbrCases()+" cases)\n");
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
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int varx,vary,cox,coy,pos;
		Coord testCo = new Coord();
		boolean co_Valid=true;
		ArrayList<Coord> coo;
		Component v;
		//quand on clique sur une case, elle devient verte
			
		if(index<5){
			System.out.println(e.getX() + " " + e.getY());
			Component c = Plateau.findComponentAt(e.getX(), e.getY());
			this.xInit = (e.getX() / ((c.getWidth())))+1;
	        this.yInit = (e.getY() / ((c.getHeight())))+1;
	        Coord coord = new Coord(xInit,yInit);
	        System.out.println(xInit + " " + yInit);
	        
	        coo = al.get(index).calculPositions(coord, dir);	
	        System.out.println("\n\n"+coo+"\n");
	        
	        for(Coord o: coo){
	        	cox=(o.x)-1;
	        	coy=(o.y)-1;
	        	testCo.x =cox;
	        	testCo.y =coy;
	        	co_Valid &= testCo.coordonnees_valides();
	        	co_Valid &= !bs.isSomethingHere(o);
	        	//System.out.println(co_Valid);
	        	System.out.println(bs.isSomethingHere(o));
	        	}
	       
	        if(co_Valid==true){
	        	bs.setPosBoat(al.get(index).getNom(),coord, dir);
	        for(Coord o: coo){
	        	varx = o.x * ((c.getWidth()));
	        	vary = o.y * ((c.getWidth()));
	        	v = Plateau.findComponentAt(varx, vary);
	         	v.setBackground(Color.green);

	         	//System.out.println("Placer le "+al.get(index).getNom()+"\n" +"("+al.get(index).getNbrCases()+" cases)\n");
	        }
	        textArea.setText("sens : " + mes +"\nPlacer le "+al.get(index).getNom()+"\n" +"("+al.get(index).getNbrCases()+" cases)\n");
	        index++;
	        }
	        else{
	        	textArea.setText("Erreur de placement");
	        }
		}
		else{System.out.println("Coucouy");}
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
