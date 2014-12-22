package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import moteur.*;

public class JeuDeCarteUniverselView extends JFrame{
	private JPanel principal ;
	
	private BackgroundPanel centre;
	//private JPanel[] mappageTapisPanel;
	private ArrayList<JPanel> mappageTapisPanel;
	private ArrayList<JoueurView> listJoueur=new ArrayList<JoueurView>();
	private JButton pret 	;
	private JButton prendreTalon ;
	
	
	public JeuDeCarteUniverselView(){
		
		
		
	}
	public void DemarrageFenetre(){
		BorderLayout borderPrincipal=new BorderLayout();
		principal=new JPanel(borderPrincipal);
		borderPrincipal.setHgap(200);
		Image img =Toolkit.getDefaultToolkit().getImage("images/background.jpg");
		centre =new BackgroundPanel(img,2);
		
		centre.setLayout(new SpringLayout());
		creerTapisJeu(moteur.Partie.partie.getNombreJoueurVirtuel());

		JPanel droit = new JPanel(new BorderLayout());
		
		
		droit.setLayout(new BoxLayout(droit, BoxLayout.Y_AXIS));
	
		
		JMenuBar menubar =new JMenuBar();
		JMenu partie=new JMenu("Partie");
		menubar.add(partie);
		setJMenuBar(menubar);
		
		centre.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		principal.add(centre, BorderLayout.CENTER);
		principal.add(droit, BorderLayout.EAST);
		
		
		
		
		
		principal.setPreferredSize(new Dimension(1100, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100,600);
		this.add(principal);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	public void creerTapisJeu(int nbJoueurVirtuel){
		
		int mappageTapis []={20,20,20,20,20,20};
		if (nbJoueurVirtuel==1){
			mappageTapis[0]=2;
			mappageTapis[1]=7;
			mappageTapis[2]=12;
		}else if(nbJoueurVirtuel==2){
			mappageTapis[0]=1;
			mappageTapis[1]=3;
			mappageTapis[2]=7;
			mappageTapis[3]=12;
		}
		else if(nbJoueurVirtuel==3){
			mappageTapis[0]=2;
			mappageTapis[1]=5;
			mappageTapis[2]=7;
			mappageTapis[3]=9;
			mappageTapis[4]=12;
		}
		else if(nbJoueurVirtuel==4){
			mappageTapis[0]=1;
			mappageTapis[1]=3;
			mappageTapis[2]=5;
			mappageTapis[3]=7;
			mappageTapis[4]=9;
			mappageTapis[5]=12;
		}
		else {
			mappageTapis[0]=2;
			mappageTapis[1]=7;
			mappageTapis[2]=12;
			
		}
		mappageTapisPanel=new ArrayList<JPanel>();
		for(int i=0;i<6;i++){
			mappageTapisPanel.add(new JPanel(new BorderLayout()));
		}
		for (int i = 0,j=0,k=1; i < 15; i++) {
			   
			
		   if (i==mappageTapis[0]||i==mappageTapis[1]||i==mappageTapis[2]||i==mappageTapis[3]||i==mappageTapis[4]||i==mappageTapis[5]){
			  
			  // mappageTapisPanel.get(j).setBorder(new BevelBorder(BevelBorder.RAISED));
			   if (i==7){
				   mappageTapisPanel.get(j).setBorder(new BevelBorder(BevelBorder.RAISED));
				   mappageTapisPanel.get(j).setBackground(new Color(0x006600));
				   
				   
			   }
			   if (i==12){
			   this.creerTapisPersonel(j,1,k);
			   
			   }
			   else if (i != 7){
			   this.creerTapisPersonel(j,2,k); 
			   k++;
			   }
			   
			   
			   this.centre.add(mappageTapisPanel.get(j));
			   
			   j++;
			   
			   
			   
		   }
		   
		   
		   else if (i==13){
			   pret= new JButton("Je suis prêt");
			   pret.setEnabled(false);
			   prendreTalon=new JButton("Prendre Talon");
			   
			   JPanel commandesJoueur=new JPanel();
			   commandesJoueur.setLayout(new BoxLayout(commandesJoueur,BoxLayout.Y_AXIS));
			   commandesJoueur.add(pret);
			   commandesJoueur.add(prendreTalon);
			   this.centre.add(commandesJoueur);
			   
		   }
		   else{
			   JLabel vide = new JLabel();
			   this.centre.add(vide);
			   
		   }
		   
		    
		}
		SpringUtilities.makeGrid(centre,3,5,5,5,5,5);
			
		
	}
	public void setListJoueur(ArrayList<JoueurView> list){
		this.listJoueur=list;
	}
	public void addListJoueur(JoueurView joueur){
		this.listJoueur.add(joueur);
	}
	public void creerTapisPersonel(int pos,int type,int posList){
		
		if(type==1){
			
			JPanel panelVertical=new JPanel();
			panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.PAGE_AXIS));
			panelVertical.setSize(10, 10);
			//panelVertical.setPreferredSize(new Dimension(10,10));
			//panelVertical.setBorder(new BevelBorder(BevelBorder.RAISED));
			
			//JPanel ligneCarteVisible = new JPanel();
			//ligneCarteVisible.setLayout(new BoxLayout(ligneCarteVisible, BoxLayout.LINE_AXIS));
			
			
			//ligneCarteVisible.setBorder(new BevelBorder(BevelBorder.RAISED));
			//JPanel ligneMain = new JPanel();
			//ligneMain.setBorder(new BevelBorder(BevelBorder.RAISED));
			//JPanel lignePersonnage = new JPanel();
			//lignePersonnage.setBorder(new BevelBorder(BevelBorder.RAISED));
			
//			JPanel carte1=new JPanel();
//			carte1.setBorder(new BevelBorder(BevelBorder.RAISED));
//			JPanel carte2=new JPanel();
//			carte2.setBorder(new BevelBorder(BevelBorder.RAISED));
//			JPanel carte3=new JPanel();
//			carte3.setBorder(new BevelBorder(BevelBorder.RAISED));
//			ligneCarteVisible.add(carte1);
//			ligneCarteVisible.add(carte2);
//			ligneCarteVisible.add(carte3);
//			panelVertical.add(ligneCarteVisible);
//			panelVertical.add(ligneMain);
//			panelVertical.add(lignePersonnage);
			panelVertical.add(listJoueur.get(0).getLigneCarteVisible());
			panelVertical.add(listJoueur.get(0).getLigneMain());
			panelVertical.add(listJoueur.get(0).getLigneJoueur());
			mappageTapisPanel.get(pos).add(panelVertical);
		}
		else{
			//JPanel panel =mappageTapisPanel.get(mappageTapisPanel.size()-1);
			JPanel panelVertical=new JPanel();
			panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.PAGE_AXIS));
			//panelVertical.setSize(10, 10);
			panelVertical.setPreferredSize(new Dimension(10,10));
			//panelVertical.setBorder(new BevelBorder(BevelBorder.RAISED));
			JPanel ligneCarteVisible = new JPanel();
			ligneCarteVisible.setBorder(new BevelBorder(BevelBorder.RAISED));
			JPanel lignePersonnage = new JPanel();
			lignePersonnage.setBorder(new BevelBorder(BevelBorder.RAISED));
			panelVertical.add(ligneCarteVisible);
			panelVertical.add(lignePersonnage);
			//panelVertical.add(listJoueur.get(posList).getLigneCarteVisible());
			//panelVertical.add(listJoueur.get(posList).getLigneMain());
			//panelVertical.add(listJoueur.get(posList).getLigneJoueur());
			mappageTapisPanel.get(pos).add(panelVertical);
			
		}
		
		
	}
	
	

}
