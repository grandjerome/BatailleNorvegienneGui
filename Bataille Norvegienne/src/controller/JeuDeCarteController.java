package controller;
import interfaceGraphique.*;
import moteur.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JeuDeCarteController {
	
	private JeuDeCarteDemarrageView menuDemarrage;
	private JeuDeCarteUniverselView fenetreUniverselle;
	private DemarrageListener demaListener;
	private FenetreUniverselleListener fenUniListener;
	private ArrayList<JoueurView> listJoueur = new ArrayList<JoueurView>();
	
	
	
	
	
	public JeuDeCarteController(JeuDeCarteDemarrageView menuDemarrage,JeuDeCarteUniverselView fenetreUniverselle){
		this.menuDemarrage=menuDemarrage;
		this.fenetreUniverselle=fenetreUniverselle;
		//this.theView.setTestField(0);
		demaListener = new DemarrageListener(this.menuDemarrage,this.fenetreUniverselle);
		fenUniListener = new FenetreUniverselleListener(this.fenetreUniverselle);
		this.menuDemarrage.addNomListener(demaListener );
		this.menuDemarrage.addEnvoyerListener(demaListener );
		this.menuDemarrage.addJouerListener(demaListener);
		this.menuDemarrage.addCommencerListener(demaListener);
		//this.fenetreUniverselle.setListJoueur(listJoueur);
		
		
	}
	
	public void ajouterJoueurView(Joueur joueur){
		JoueurView joueurvi= new JoueurView(joueur);
		listJoueur.add(joueurvi);
		this.fenetreUniverselle.addListJoueur(joueurvi);
		
		
	}
	
	
}
