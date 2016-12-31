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
import BattleShip.Controler;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;
import tools.BoatImageProvider;

public class PlacementB2 extends JPanel implements MouseListener, MouseMotionListener, Observer, KeyListener {
	
	Controler controler = null;
	
	private static final long serialVersionUID = 1L;
	private JPanel square;
	private JPanel panel;
	public JPanel plateau;
	private JTextArea textArea;
	JButton btnDemarrer;
	ArrayList<AbstractBateau> al = new ArrayList<AbstractBateau>();
	Bateau.direction dir = Bateau.direction.horizontale;
	int numBateau = 0;
	
	ArrayList<Integer> preselection = new ArrayList<Integer>();
	
	// ----- A SUPPRIMER
//	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	// ------------------	

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	
	public PlacementB2(Controler fenetreMere) throws FontFormatException, IOException {
		this.controler = fenetreMere;
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
		
		al.add(controler.getAbstractBateau("Porte-Avions"));
		al.add(controler.getAbstractBateau("Croiseur"));
		al.add(controler.getAbstractBateau("Sous-Marin"));		
		al.add(controler.getAbstractBateau("Destroyer"));
		al.add(controler.getAbstractBateau("Patrouilleur"));
		
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
			square.setBackground(Color.WHITE);
		}

		plateau.addMouseListener(this);

		plateau.addMouseMotionListener(this);
		panel.add(plateau);
		panel.setBounds(100, 100, 450, 300);
		this.add(panel);
		
		//Listener et bouton du bouton démarrer
		btnDemarrer = new JButton("Placement..");
		btnDemarrer.setBounds(579, 231, 240, 80);
		btnDemarrer.setEnabled(false);
		panel.add(btnDemarrer);
		btnDemarrer.setFont(BattlegroundSmall);
		btnDemarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Changement d'écran vers le jeu
				controler.changeToBoard();
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
	
	// Remet toutes les cases en blanc
	private void resetPrevi() {
		int i;
		for(i=0;i<100;i++)
			plateau.getComponent(i).setBackground(Color.WHITE);
	}
	
	private void previsualisationPos(MouseEvent e) {
		if(numBateau < 5) {
			
			this.resetPrevi();
					
			preselection.clear();
	
			Component c = plateau.findComponentAt(e.getX(), e.getY());
			Coord coord = new Coord();
			coord.x = (e.getY() / (c.getWidth()));
	        coord.y = (e.getX() / (c.getHeight()));
	        
	        int pos = ((coord.x)*10) + (coord.y);
	        
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
			Component c;
			//quand on clique sur une case, elle devient verte
				
			if(numBateau<5){
				c = plateau.findComponentAt(e.getX(), e.getY());
				xInit = e.getY() / ((c.getWidth()));
		        yInit = e.getX() / ((c.getHeight()));
		        Coord coord = new Coord(xInit,yInit);
		        
		        coo = al.get(numBateau).calculPositions(coord, dir);
		        
		        for(Coord o: coo){
		        	co_Valid &= o.coordonnees_valides();
//		        	System.out.println(o.coordonnees_valides());
		        	co_Valid &= !controler.isSomethingHere(o);
		        }
		        
		        String[] img = BoatImageProvider.getImageFile(al.get(numBateau).getNom(), dir);
		        int i = 0;
		        if(co_Valid==true && !coo.isEmpty()){
		        	controler.setPosBoat(al.get(numBateau).getNom(),coord, dir);
		        	for(Coord o: coo){
			        	vary = ((o.x)+1) * ((c.getWidth()));
			        	varx = ((o.y)+1) * ((c.getWidth()));
			        	JLabel image = new JLabel( new ImageIcon(img[i]));// on va chercher l'image dans le tableau
		    			JPanel panel = (JPanel)plateau.findComponentAt(varx, vary); 
		    			panel.add(image);
		    			this.revalidate();
			        	i++;
			        }
			        numBateau++;
			        
			        // Si tous les bateaux ont été placés
			        if(numBateau == 5) {
			        	btnDemarrer.setText("Lancer la Partie");
			        	btnDemarrer.setEnabled(true);
			        	this.resetPrevi();
			        }
		        }
			}
			
		} else if(buttonDown == MouseEvent.BUTTON3) {	// Clic droit
			
			if(dir.equals(Bateau.direction.horizontale))
				dir = Bateau.direction.verticale;
			else
				dir = Bateau.direction.horizontale;
			
			this.setMessagePlacement();
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
