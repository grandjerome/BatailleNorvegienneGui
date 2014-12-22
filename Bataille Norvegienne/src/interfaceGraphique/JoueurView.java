package interfaceGraphique;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class JoueurView {

	
	private JPanel ligneCarteVisible;
	private JPanel ligneMain;
	private JPanel ligneJoueur;
	private moteur.Joueur joueur;
	
	public JoueurView(moteur.Joueur joueur){
		ligneCarteVisible=new JPanel();
		ligneCarteVisible.setLayout(new BoxLayout(ligneCarteVisible, BoxLayout.LINE_AXIS));
		
		
		
		JPanel carte1=new JPanel();
		carte1.setBorder(new BevelBorder(BevelBorder.RAISED));
		JPanel carte2=new JPanel();
		carte2.setBorder(new BevelBorder(BevelBorder.RAISED));
		JPanel carte3=new JPanel();
		carte3.setBorder(new BevelBorder(BevelBorder.RAISED));
		ligneCarteVisible.add(carte1);
		ligneCarteVisible.add(carte2);
		ligneCarteVisible.add(carte3);
		
		
		ligneCarteVisible.setBorder(new BevelBorder(BevelBorder.RAISED));
		ligneMain=new JPanel();
		//ligneMain.setLayout(new BoxLayout(ligneMain, BoxLayout.LINE_AXIS));
		ligneMain.setBorder(new BevelBorder(BevelBorder.RAISED));
		ligneJoueur=new JPanel();
		//ligneJoueur.setLayout(new BoxLayout(ligneJoueur, BoxLayout.LINE_AXIS));
		ligneJoueur.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.joueur=joueur;
		
	}

	public JPanel getLigneCarteVisible() {
		return ligneCarteVisible;
	}

	

	public JPanel getLigneMain() {
		return ligneMain;
	}

	

	public JPanel getLigneJoueur() {
		return ligneJoueur;
	}

	
	
}
