package moteur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class Joueur {

	
	
	protected int nbCartes;


	protected String nomJoueur;
	
	
	protected ArrayList<Carte> main;
	protected HashSet<Carte> faceCachee;
	protected HashSet<Carte> faceVisible;
	private ArrayList<Carte> carteaposer;
	public boolean JoueurEnJeu=true;
	public Joueur(){
		
	}
	
	public Joueur(String nom){
		this.nomJoueur=nom;		
	}
	
	public void echangerCarte() {
		boolean grandeBoucle=true;
		while(grandeBoucle){
			grandeBoucle=false;
		System.out.println("Voulez vous echanger des cartes? (oui ou non)");
		
		String reponse = lireClavier();
		
		
		
		if(reponse.equals("oui")){
		
		System.out.println("Combien de cartes voulez vous changer? (De 1 à 3)");
		boolean boucle=true;
		int nbCartesAEchanger=0;
		while(boucle){
			try{
			boucle=false;
			nbCartesAEchanger = lireClavierInt();
			controlCarteInexistante(nbCartesAEchanger);
			controlDepassementCarteJouable(nbCartesAEchanger);
			controlInvalidNumber(nbCartesAEchanger);
			}
			catch(InputMismatchException e){
			System.out.println("veuillez entrer un chiffre");
			boucle=true;
			}
			catch(InvalidNumberException e1){
			System.out.println("Entrez un chiffre entre 1 et 3");
			boucle=true;
			} catch (CarteInexistanteException e) {
				
			} catch (DepassementCarteJouableException e) {
				
			}
			}
			boucle=true;
		
		
		for (int i=0;i<nbCartesAEchanger;i++){
			System.out.println("Carte a échanger n°"+(i+1));
			System.out.println("quelle carte voulez vous echanger parmi : ");
			System.out.println("main :");
			for (int j=0;j<main.size();j++){
				System.out.println("numero "+ (j+1) +" "+ main.get(j));
			}
			int numCarteAEchanger=0;
			while(boucle){
				try{
				boucle=false;
				numCarteAEchanger = lireClavierInt()-1;
				controlCarteInexistante(numCarteAEchanger);
				controlDepassementCarteJouable(numCarteAEchanger);
				controlInvalidNumber(numCarteAEchanger);
				}
				catch(InputMismatchException e){
				System.out.println("veuillez entrer un chiffre");
				boucle=true;
				}
				catch (CarteInexistanteException e) {
					System.out.println("veuillez entrer entre 1 et "+main.size());
					boucle=true;
				} 
				catch(InvalidNumberException e1){
				} 
				catch (DepassementCarteJouableException e) {
					
				}
				}
				boucle=true;
			
			Carte carteAEchanger = main.get(numCarteAEchanger);
			System.out.println("Avec quelle carte de la face visible parmi : ");
			System.out.println("face visible :");
			ArrayList<Carte> list = new ArrayList<Carte>( faceVisible );
			for (int j=0;j<main.size();j++){
				System.out.println("numero "+ (j+1) +" "+ list.get(j));
			}
			
			int numCarteAEchangerFaceVisible=0;
			while(boucle){
				try{
				boucle=false;
				numCarteAEchangerFaceVisible = lireClavierInt()-1;
				controlCarteInexistante(numCarteAEchangerFaceVisible);
				controlDepassementCarteJouable(numCarteAEchangerFaceVisible);
				controlInvalidNumber(numCarteAEchangerFaceVisible);
				}
				catch(InputMismatchException e){
				System.out.println("veuillez entrer un chiffre");
				boucle=true;
				}
				catch(CarteInexistanteException e2){
					System.out.println("veuillez entrer entre 1 et "+main.size());
					boucle=true;
				}
				catch(InvalidNumberException e1){
					
				} 
				catch (DepassementCarteJouableException e) {
					
				}
				
				}
				boucle=true;
			
			
			Carte carteAEchangerFaceVisible = list.get(numCarteAEchangerFaceVisible);
			main.remove(numCarteAEchanger);
			main.add(carteAEchangerFaceVisible);
			list.remove(numCarteAEchangerFaceVisible);
			list.add(carteAEchanger);
			System.out.println("Vous avez échangé "+carteAEchanger+" et "+carteAEchangerFaceVisible);
			faceVisible = new HashSet<Carte>(list);
			}
		}
		else if (reponse.equals("non")){
			System.out.println("la partie commence");
		}
		else{
			System.out.println("veuillez entrer oui ou non");
			grandeBoucle=true;
		}
	}
	}
	public void creerList(){
		main = new ArrayList<Carte>();
		faceCachee = new HashSet<Carte>();
		faceVisible = new HashSet<Carte>();
	}
	public void piocher(int nbCarte){
		int i=0;
		while(!(Partie.partie.getTasDeCarte().getpioche().isEmpty()) && i<nbCarte)
		{
		this.main.add(Partie.partie.getTasDeCarte().getpioche().remove());
		i++;
		}
	}
	public HashSet<Carte> getfaceCachee(){
		return(faceCachee);
	}
	public ArrayList<Carte> getmain(){
		return(main);
	}
	public HashSet<Carte> getfaceVisible(){
		return(faceVisible);
	}
	public void setfacevisible(ArrayList<Carte> list){
		faceVisible.removeAll(faceVisible);
		for (int i=0; i<3; i++){
			faceVisible.add(list.get(i));
		}
	}
	public boolean poserCarte(ArrayList<Carte> carteaposer) { 
		 boolean cartejouable=carteaposer.get(0).determinerCarteJouable();
		 
		 if (cartejouable){
			 Carte element=null;
			 if (carteaposer.get(0) instanceof CarteSpeciale){
				 ListIterator<Carte> it = carteaposer.listIterator();
				 while (it.hasNext()){
					 element= it.next();
					 System.out.println(element);
					 //System.out.println(element.getCouleur()+ " "+element.getValeur());
					 Partie.partie.getTasDeCarte().getTalon().add(element);
					 //System.out.println(Partie.partie.getTasDeCarte().getTalon().get(0));
					 main.remove(element);
					 ((CarteSpeciale) element).jouerEffet();
					 if(main.size()<3){
						 piocher(1);
					 }
					 
					 
					 
			 }
				 
			 }
				 else{
					 ListIterator<Carte> it = carteaposer.listIterator();
					 while (it.hasNext()){
						 element= it.next();
						System.out.println(element+" posée");
						 //System.out.println(element.getCouleur()+ " "+element.getValeur());
						 Partie.partie.getTasDeCarte().getTalon().add(element);
						 //System.out.println(Partie.partie.getTasDeCarte().getTalon().get(0));
						 main.remove(element);
						 if(main.size()<3){
							 piocher(1);
						 }
					 }
					 
			 
			 
				 }
			 
			 element.resetEffet();
			 
		 }
		 else {System.out.println("vous ne pouvez pas poser cette carte");}
		 carteaposer.clear();
		 return (cartejouable);
	}

	

	public int getNbCartes() {
		return nbCartes;
	}

	
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	public void prendreCarteFaceVisible(){
		Iterator<Carte> it = faceVisible.iterator();
		
		while(it.hasNext()){
			Carte element = it.next();
			main.add(element);		
		}
		faceVisible.clear();
		System.out.println("vous avez récupéré les cartes visibles");
		
		
		
	}
	public void prendreCarteFaceCachee(){
		Iterator<Carte> it = faceCachee.iterator();
		Carte element=null;
		boolean entreeBoucle=true;
		while(it.hasNext() && entreeBoucle){
			element = it.next();
			main.add(element);
			entreeBoucle=false;
		}
		faceCachee.remove(element);
		System.out.println("vous avez récupéré une carte face cachée");
		
		
	}
	public void jouerCarte(){
		if (main.isEmpty() && faceVisible.isEmpty() && faceCachee.isEmpty()){
			SortieJoueur();
		}
		else {
		
			System.out.println("joueur : "+this);
			System.out.println("le talon est :" );
			Partie.partie.getTasDeCarte().afficherTalon();
			
		
		if (main.isEmpty() && !(Partie.partie.getTasDeCarte().getpioche().isEmpty()))
			{
			piocher(1);
			
			}
		else if(main.isEmpty() && Partie.partie.getTasDeCarte().getpioche().isEmpty()){
				if(faceVisible.isEmpty()){
					prendreCarteFaceCachee();
				}
				else {prendreCarteFaceVisible();}
			}
		else{
			
		
		
			boolean carteposee=false;
			while(!(carteposee)){
			System.out.println("\n \n quelle carte voulez vous poser parmi : ");
			System.out.println("\n main :");
			int i;
			System.out.println(main);
			for (i=0;i<main.size();i++){
				System.out.println("numero "+ (i+1) +" "+ main.get(i));
			//System.out.println("numero "+ (i+1) +" "+ main.get(i).getCouleur() + " " + main.get(i).getValeur());
			}
			
			boolean boucle=true;
			System.out.println("\n combien de cartes à poser ?");
			int nombrecarteaposer=0;
			while(boucle){
			try{
			boucle=false;
			nombrecarteaposer=lireClavierInt();
			controlCarteInexistante(nombrecarteaposer);
			controlDepassementCarteJouable(nombrecarteaposer);
			controlInvalidNumber(nombrecarteaposer);
			}
			catch(InputMismatchException e){
				System.out.println("veuillez entrer un chiffre");
				boucle=true;
			}
			catch(CarteInexistanteException e1){
			System.out.println("veuillez entrer entre 0 et "+main.size());
			boucle=true;
			}
			catch(DepassementCarteJouableException e2){
			System.out.println("veuillez entrer un chiffre entre 0 et 4");	
			boucle=true;
			}
			catch(InvalidNumberException e3){
				
			}
			}
			boucle=true;
			carteaposer = new ArrayList<Carte>();
			if (nombrecarteaposer==0){
				Partie.partie.getTasDeCarte().donnerTalon(this);
			}
			else {
			int numerocarte=0;
			for(i=0;i<nombrecarteaposer;i++){
			System.out.println("numéro de la carte n° "+(i+1)+" :");
			
			while(boucle){
			try{
			boucle=false;
			numerocarte = lireClavierInt();
			controlCarteInexistante(numerocarte);
			controlDepassementCarteJouable(numerocarte);
			controlInvalidNumber(numerocarte);
			
			}
			catch(InputMismatchException e){System.out.println("veuillez entrer un chiffre");
			boucle=true;
			}
			catch(CarteInexistanteException e1){
			System.out.println("veuillez entrer entre 1 et "+main.size());
			boucle=true;
				
			}
			catch(InvalidNumberException e2){
				
			} 
			catch (DepassementCarteJouableException e) {
				
			}
			}
			boucle=true;
			
			carteaposer.add(main.get(numerocarte-1));
			}
			boolean identique=false;
			if(carteaposer.size()==1){
				identique=true;
			}
			//System.out.println(carteaposer.size());
			if(carteaposer.size()>1){
			identique=verifierCarteIdentique(carteaposer);
			}
			if (!(identique)){
			 System.out.println("\n cartes non identiques, veuillez recommencer");
			}
			//->exception identique=false
			if (identique){
				carteposee = poserCarte(carteaposer);	
			}
			
			}}}}
		
			
		
			}
		
	public String lireClavier(){
		
		Scanner sc = new Scanner(System.in);
		return(sc.nextLine());
		
	}
	public int lireClavierInt() throws InvalidNumberException,CarteInexistanteException,DepassementCarteJouableException{
		
		 Scanner sc = new Scanner(System.in);
		int sortie=sc.nextInt();
		//if(sortie!=1&&sortie!=2&&sortie!=3){
		//	throw new InvalidNumberException();
		//}
		//if(sortie<1 || sortie>(main.size()+1)){
			//throw new CarteInexistanteException();
		//}
		//if (sortie<0 ||sortie>4){
		//	throw new DepassementCarteJouableException();
		//}
		return(sortie);
	}
	
	public void controlCarteInexistante(int sortie)throws CarteInexistanteException{
		if(sortie<0 || sortie>main.size()){
			throw new CarteInexistanteException();
			}
	}
	public void controlDepassementCarteJouable(int sortie)throws DepassementCarteJouableException{
		if(sortie<0 ||sortie>4){
			throw new DepassementCarteJouableException();
			}
	}
	public void controlInvalidNumber(int sortie)throws InvalidNumberException{
		if(sortie!=1&&sortie!=2&&sortie!=3){
			throw new InvalidNumberException();
			}
	}
	
		public void SortieJoueur(){
			Partie.partie.sortirJoueur();
		}
		
	public boolean verifierCarteIdentique(ArrayList<Carte> carteacomparer){
		boolean carteidentique=true;
		ListIterator<Carte> it = carteacomparer.listIterator();
		Carte elementreference=null;
		if (it.hasNext()){
			elementreference = it.next();
		}
		while(it.hasNext()){
			Carte elementacomparer = it.next();
			if (elementacomparer.getValeur()!=elementreference.getValeur()){
				carteidentique=false;
				
			}
			
		}
		return(carteidentique);
		
	}
	public ArrayList<Carte> getCarteAPoser(){
		return(carteaposer);
	}
	public String toString(){
		return("Joueur "+nomJoueur+" ");
	}
	
	public String getNomJoueur(){
		return(nomJoueur);
	}
	public String getNom(Joueur joueur){
		return(joueur.getNomJoueur());
	}

	

}

