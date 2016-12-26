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
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

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

public class PlacementB2 extends JPanel implements MouseListener, MouseMotionListener, Observer, KeyListener {

	private static final long serialVersionUID = 1L;
	public JPanel square;
	public JPanel panel;
	public JPanel plateau;
	public JTextArea textArea;
	ArrayList<AbstractBateau> al = new ArrayList<AbstractBateau>();
	Bateau.direction dir = Bateau.direction.verticale;
	int numBateau = 0;
	
//	ArrayList<Component> preselection = new ArrayList<Component>();
	ArrayList<Integer> preselection = new ArrayList<Integer>();
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	// ------------------	

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public PlacementB2() throws FontFormatException, IOException {
		initialize();
		this.setMessagePlacement();
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
		
		al.add(bs.getAbstractBateau("Porte-Avions"));
		al.add(bs.getAbstractBateau("Croiseur"));
		al.add(bs.getAbstractBateau("Sous-Marin"));		
		al.add(bs.getAbstractBateau("Destroyer"));
		al.add(bs.getAbstractBateau("Patrouilleur"));
		
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
		label.setBounds(0, 0, 944, 501);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(579, 379, 245, 80);
		textArea.setEditable(false);
		panel.add(textArea);
		
		JLabel lblClicDroitSur = new JLabel("Appuyez sur les flèches haut et bas pour changer le sens");
		lblClicDroitSur.setFont(BattlegroundSmall);
		lblClicDroitSur.setBounds(490, 165, 400, 50);
		
		
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
        
        //Chiffre ï¿½ gaucheframe
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
		
		//plateau
		plateau = new JPanel();
		plateau.setBounds(91, 138, 325, 325);
		plateau.setBorder(new LineBorder(Color.BLACK));
		plateau.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			plateau.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}

		plateau.addMouseListener(this);

		plateau.addMouseMotionListener(this);
		panel.add(plateau);
		panel.setBounds(100, 100, 450, 300);
		this.add(panel);
		
		//Listener et bouton du bouton démarrer
		JButton btnModeStandard = new JButton("Demarrer");
		btnModeStandard.setBounds(579, 231, 240, 80);
		panel.add(btnModeStandard);
		btnModeStandard.setFont(BattlegroundSmall);
		btnModeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add( label );
		panel.setBounds(0, 0, 960, 540);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
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
	
	private void previsualisationPos(MouseEvent e) {
		if(numBateau < 5) {
			Component c;
			
			for(int id : preselection)
				plateau.getComponent(id).setBackground(Color.WHITE);
					
			preselection.clear();
	
			c = plateau.findComponentAt(e.getX(), e.getY());
			Coord coord = new Coord();
			coord.x = (e.getY() / (c.getWidth()));
	        coord.y = (e.getX() / (c.getHeight()));
	        
	        int pos = ((coord.x)*10) + (coord.y);
	        int i;
	        
	        ArrayList<Coord> coordPrevues = new ArrayList<Coord>();
	        coordPrevues = al.get(numBateau).calculPositions(coord, dir);
	        
	        for(Coord co : coordPrevues) {
	        	pos = ((co.x)*10) + (co.y);
	        	plateau.getComponent(pos).setBackground(Color.BLUE);
	        	preselection.add(pos);
	        }
		}
	}
	
	private void setMessagePlacement() {
		textArea.setText("Direction : "+dir+"\nPlacer le "+al.get(0).getNom()+"\n" +"("+al.get(0).getNbrCases()+" cases)\n");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.previsualisationPos(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int buttonDown = e.getButton();
		
		if (buttonDown == MouseEvent.BUTTON1) {	// Clic gauche
			
			int varx,vary,cox,coy,pos;
			int xInit, yInit;
			Coord testCo = new Coord();
			boolean co_Valid=true;
			ArrayList<Coord> coo;
			Component v;
			//quand on clique sur une case, elle devient verte
				
			if(numBateau<5){
				System.out.println(e.getX() + " " + e.getY());
				Component c = plateau.findComponentAt(e.getX(), e.getY());
				xInit = (e.getX() / ((c.getWidth())))+1;
		        yInit = (e.getY() / ((c.getHeight())))+1;
		        Coord coord = new Coord(xInit,yInit);
		        System.out.println(xInit + " " + yInit);
		        
		        coo = al.get(numBateau).calculPositions(coord, dir);	
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
		        	bs.setPosBoat(al.get(numBateau).getNom(),coord, dir);
		        for(Coord o: coo){
		        	varx = o.x * ((c.getWidth()));
		        	vary = o.y * ((c.getWidth()));
		        	v = plateau.findComponentAt(varx, vary);
		         	v.setBackground(Color.green);
		        }
		        numBateau++;
		        }
		        else{
		        	textArea.setText("Erreur de placement");
		        }
			}
			else{System.out.println("Coucouy");}
			
		} else if(buttonDown == MouseEvent.BUTTON3) {	// Clic droit
			
			System.out.println("changement direction");
			if(dir.equals(Bateau.direction.horizontale))
				dir = Bateau.direction.verticale;
			else
				dir = Bateau.direction.horizontale;
			
			this.previsualisationPos(e);
			
		}
		
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
