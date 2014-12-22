package moteur;

import interfaceGraphique.JeuDeCarteDemarrageView;
import interfaceGraphique.JeuDeCarteUniverselView;

import java.util.ArrayList;

import controller.*;

import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Partie {

	
	private int nombreJoueurVirtuel=0;

	
	private String nomVainqueur;

	
	private TasDeCarte tasdecarte;
	private int nbJoueurEnJeu=0;
	private boolean JoueurEnJeu=true;
	private ArrayList<Joueur> listJoueur;
	private ListIterator iterateurJoueur;
	private String nomJoueur="Guest";
	static public Partie partie;
	private JeuDeCarteController controller;
	private JeuDeCarteUniverselView fenetreUniverselle ;
	private JeuDeCarteDemarrageView menuDemarrage;
	

	
	
	
	public void lancementPartie(){
		
	//partie = new Partie();
	partie.debutPartie();
	//partie.deroulementPartie();
	}
	public void sortirJoueur(){
		JoueurEnJeu=false;
		nbJoueurEnJeu--;
	}
	public void sortirJoueurVirtuel(){
		nbJoueurEnJeu--;
	}
	public void determinerVainqueur() {

	}

	public void finPartie() {

	}
	public ArrayList<Joueur> getlistJoueur(){
		return (this.listJoueur);
	}
	public Partie(){
		menuDemarrage = new JeuDeCarteDemarrageView();
		fenetreUniverselle = new JeuDeCarteUniverselView();
		controller=new JeuDeCarteController(menuDemarrage,fenetreUniverselle);
		menuDemarrage.setVisible(true);
	}
	public void setController(JeuDeCarteController controller){
		this.controller=controller;
	}
	public void setNbJoueur(){
		try{
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien voulez vous de joueur virtuels (1 -> *)");
		int nbJoueur = sc.nextInt();
		this.nombreJoueurVirtuel=nbJoueur;
		}
		catch (InputMismatchException e){
			System.out.println("n'avez pas entré un nombre !");
			setNbJoueur();
		}
	}
	public String setNomJoueur(){
		String nomJoueur=null;
		
		
		System.out.println("quel est votre nom ? \n \n");
		nomJoueur =lireClavier();
		
		return(nomJoueur);
	}
	public void setNomJoueur(String nom){
		nomJoueur=nom;
		
	}
	public String lireClavier(){
		
		Scanner sc = new Scanner(System.in);
		return(sc.nextLine());
		
	}
	public int lireClavierInt(){
		
		 Scanner sc = new Scanner(System.in);
	
		return(sc.nextInt());
	}
	public void debutPartie() {
		
		//setNbJoueur();
		
		//String nomJoueur=setNomJoueur();
		listJoueur = new ArrayList<Joueur>();
		
		Joueur joueur = new Joueur(nomJoueur);
		controller.ajouterJoueurView(joueur);
		listJoueur.add(joueur);
		this.JoueurEnJeu=true;
		this.nbJoueurEnJeu=this.nombreJoueurVirtuel+1;
		
		JoueurVirtuel[] joueurVirtuel = new JoueurVirtuel[this.nombreJoueurVirtuel];
		for (int i = 0;i<this.nombreJoueurVirtuel;i++){
			joueurVirtuel[i] = new JoueurVirtuel();
			controller.ajouterJoueurView(joueurVirtuel[i]);
			listJoueur.add(joueurVirtuel[i]);
			
		}
		/* Collections.shuffle(listJoueur);
		ListIterator<Joueur> it = listJoueur.listIterator();
		while (it.hasNext()){
			Joueur element = it.next();
			System.out.println(element + " " );
		}
		
		tasdecarte = new TasDeCarte(nombreJoueurVirtuel);
		
		
		
		ListIterator<Joueur> it2 = listJoueur.listIterator();
		while (it2.hasNext()){
				
				Joueur element = it2.next();
				System.out.println("joueur : " + element );
				if(!(element instanceof JoueurVirtuel)){
					System.out.println("main :\n"+element.getmain()+"\n carte face cachée :\n"+element.getfaceCachee());
					
				}
				//System.out.println("main :");
				//Iterator<Carte> it4= element.getmain().iterator();
				//while (it4.hasNext()){
				//Carte carte = it4.next();
				//System.out.println(carte);
				//System.out.println(carte.getCouleur() + " " + carte.getValeur());
				//}
				//System.out.println("carte face cachee :");
				//Iterator<Carte> it1= element.getfaceCachee().iterator();
				//while (it1.hasNext()){
				//Carte carte = it1.next();
				//System.out.println(carte);
				//System.out.println(carte.getCouleur() + " " + carte.getValeur());	
				//}
				System.out.println("carte face visible :");
				System.out.println(element.getfaceVisible()+"\n \n");
				//Iterator<Carte> it3= element.getfaceVisible().iterator();
				//while (it3.hasNext()){
				//Carte carte = it3.next();
				//System.out.println(carte);
				//System.out.println(carte.getCouleur() + " " + carte.getValeur());
				//}
				
		}
		ListIterator<Joueur> it3 = listJoueur.listIterator();
		
		while (it3.hasNext()){
			Joueur element = it3.next();
			element.echangerCarte();
		}
		
				
		
	
*/
	}
	public void deroulementPartie(){
		while (this.nbJoueurEnJeu != 1 || JoueurEnJeu){
		while (!(tasdecarte.getpioche().isEmpty())){
			
			iterateurJoueur = listJoueur.listIterator();
			int i=0;
			while (iterateurJoueur.hasNext()){
				Joueur element=(Joueur)iterateurJoueur.next();
				if(element.JoueurEnJeu){
				System.out.println(element);
				element.jouerCarte();
				i++;
				}
				
			
			}
			//while(it.hasPrevious()){
			//	Joueur element=it.previous();
			//}
			
		}
		{//partie avec tas de cartes visible et caché
		ListIterator<Joueur> it = listJoueur.listIterator();
		int i=0;
		//System.out.println("cartes visibles debloquées");
		while (it.hasNext()){
			Joueur element=it.next();
			i++;
			System.out.println("\n \njoueur : "+i +" "+ element);
			System.out.println("le talon est :" );
			tasdecarte.afficherTalon();
			element.jouerCarte();
		
		}
		}
		
		}
		
		finDePartie();
	}
	public void finDePartie(){
	if (JoueurEnJeu){
		System.out.println("\n \n Vous Avez Perdu!!");
	}
	else{
		System.out.println("\n \nVous Avez Gagné !! félicitation");
		
	}
	}

	

	public int getNombreJoueurVirtuel() {
		return nombreJoueurVirtuel;
	}

	
	public void setNombreJoueurVirtuel(int nombreJoueurVirtuel) {
		this.nombreJoueurVirtuel = nombreJoueurVirtuel;
	}

	

	public String getNomVainqueur() {
		return nomVainqueur;
	}

	
	public void setNomVainqueur(String nomVainqueur) {
		this.nomVainqueur = nomVainqueur;
	}
	public TasDeCarte getTasDeCarte(){
		return (tasdecarte);
	}
	public ListIterator getiIterateurJoueur(){
		return(iterateurJoueur);
	}

}

