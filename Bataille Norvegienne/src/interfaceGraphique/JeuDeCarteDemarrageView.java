package interfaceGraphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

import moteur.*;
import controller.*;

public class JeuDeCarteDemarrageView extends JFrame{

	private JButton jouer = new JButton("Jouer!");
	private JButton nom = new JButton("Entrer un nom");
	private JButton regles = new JButton("Comment jouer");
	private JLabel batailleNorv = new JLabel("<html><center>BATAILLE <br> NORVEGIENNE</html>");
	private JLabel bienvenu = new JLabel("Bienvenue Guest");
	private JButton envoyer =new JButton("Envoyer");
	private JTextField nomtape = new JTextField();
	private JFrame demandeNom;
	private JFrame demandeNbJoueur;
	private JSpinner entrerNbJoueur = new JSpinner(new SpinnerNumberModel(1,1,1000,1));
	private JButton commencer =new JButton("Commencer!");
	
	
	//private JMenuBar menubar =new JMenuBar();
	//private JMenu menu1=new JMenu("Partie");
	
	public JeuDeCarteDemarrageView(){
		
		
		Image img =Toolkit.getDefaultToolkit().getImage("images/density.jpg");
		BackgroundPanel fenetreDebut =new BackgroundPanel(img,2);
		fenetreDebut.setLayout(new FlowLayout());
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,500);
		this.setBatailleNorvLabel(fenetreDebut);
		JLabel vide = new JLabel();
		vide.setPreferredSize(new Dimension(200, 50));
		fenetreDebut.add(vide);
		this.setJouerBouton(fenetreDebut);
		this.setBienvenuLabel(fenetreDebut);
		this.setNomBouton(fenetreDebut);
		this.setReglesBouton(fenetreDebut);
		
		
		
		
		
		
		
		this.add(fenetreDebut);
		this.setLocationRelativeTo(null);
		
		
		
		
	}
	public void setJouerBouton(JPanel fenetreDebut){
		jouer.setFont(new Font("Action Man",Font.PLAIN,20));
		jouer.setPreferredSize(new Dimension(200, 50));
		
		fenetreDebut.add(jouer, BorderLayout.CENTER);
	}
	public void setNomBouton(JPanel fenetreDebut){
		nom.setFont(new Font("Action Man",Font.PLAIN,20));
		nom.setPreferredSize(new Dimension(200, 50));
		fenetreDebut.add(nom, BorderLayout.CENTER);
	}
	public void setReglesBouton(JPanel fenetreDebut){
		regles.setFont(new Font("Action Man",Font.PLAIN,20));
		regles.setPreferredSize(new Dimension(200, 50));
		fenetreDebut.add(regles, BorderLayout.CENTER);
	}
	public void setBienvenuLabel(JPanel fenetreDebut){
		bienvenu.setFont(new Font("Dragon is Coming",Font.PLAIN,60));
		bienvenu.setPreferredSize(new Dimension(200, 100));
		bienvenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		fenetreDebut.add(bienvenu,BorderLayout.CENTER);
	}
	public void setBatailleNorvLabel(JPanel fenetreDebut){
		batailleNorv.setFont(new Font("Rosewood Std",Font.PLAIN,50));
		batailleNorv.setForeground(new Color(0x790000));
		//batailleNorv.setPreferredSize(new Dimension(200, 50));
		batailleNorv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		fenetreDebut.add(batailleNorv, BorderLayout.PAGE_START);
	}
	public void setNom(String nom){
		bienvenu.setText("Bienvenue "+nom);
	}
	
	public void addNomListener(ActionListener listenerForButton){
		nom.addActionListener(listenerForButton);
		nom.setActionCommand("Nom");
	}
	public void addEnvoyerListener(ActionListener listenerForButton){
		envoyer.addActionListener(listenerForButton);
		envoyer.setActionCommand("Envoyer");
	}
	public void addJouerListener(ActionListener listenerForButton){
		jouer.addActionListener(listenerForButton);
		jouer.setActionCommand("Jouer");
	}
	public void addCommencerListener(ActionListener listenerForButton){
		commencer.addActionListener(listenerForButton);
		commencer.setActionCommand("Commencer");
	}
	
	public void creerFenetreDemandeNbJoueur(){
		demandeNbJoueur = new JFrame();
		JPanel demandeJoueurPanel =new JPanel();
		JLabel combienJoueur = new JLabel("Combien de Joueurs Virtuels voulez-vous ? ");
		demandeNbJoueur.setPreferredSize(new Dimension(300, 100));
		demandeJoueurPanel.add(combienJoueur);
		demandeJoueurPanel.add(entrerNbJoueur);
		demandeJoueurPanel.add(commencer);
		demandeNbJoueur.setSize(300,100);
		demandeNbJoueur.add(demandeJoueurPanel);
		demandeNbJoueur.setLocationRelativeTo(null);
		
		demandeNbJoueur.setVisible(true);
		
	}
	public void creerFenetreDemandeNom(){
		
		demandeNom =new JFrame();
		
		JPanel demandePanel =new JPanel();
		JLabel quelNom = new JLabel("Entrez Votre Nom : ");
		nomtape.setPreferredSize(new Dimension(200, 50));
		demandePanel.add(quelNom);
		demandePanel.add(nomtape);
		demandePanel.add(envoyer);
		demandeNom.setSize(200,300);
		demandeNom.add(demandePanel);
		demandeNom.setLocationRelativeTo(null);
		
		demandeNom.setVisible(true);
		
	}
	public String getNomTape(){
		return(nomtape.getText());
	}
	public int getNbJoueurEntre(){
		return(((Integer)entrerNbJoueur.getValue()));
	}
	public void fermerDemandeNom(){
		demandeNom.dispose();
	}
	public void fermerDemandeNbJoueur(){
		demandeNbJoueur.dispose();
	}
//
}

