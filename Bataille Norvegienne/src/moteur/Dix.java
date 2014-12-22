package moteur;


public class Dix extends moteur.CarteSpeciale {


	
    
	public Dix(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
		
	};
	
	public void jouerEffet() {
		Partie.partie.getTasDeCarte().getTalon().clear();

	}
	public void poserCarte() {

	}
	
	public String toString(){
		//System.out.println("valeur en chiffre : "+ this.valeur);
		return("Dix"+" de "+this.couleur);
	}

}
