package moteur;

import java.util.ArrayList;
import java.util.ListIterator;


public class Huit extends moteur.CarteSpeciale {


	
    
	public Huit(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
		
	}
	
	 public void jouerEffet() {
		while (Partie.partie.getiIterateurJoueur().hasNext()){
			Partie.partie.getiIterateurJoueur().next();
		}

	}
	
	public void donnerTalon() {

	}
	public void passerTour() {

	}
	
	public String toString(){
		//System.out.println("valeur en chiffre : "+ this.valeur);
		return("Huit"+" de "+this.couleur);
	}

	
}

