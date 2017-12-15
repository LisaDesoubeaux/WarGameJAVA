import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Jeu {
	private Joueur j1;
	private Joueur j2;
	private Terrain terrain = new Terrain(10,10);
	
	public Jeu() {
		
	}
	public Jeu (String nom1 , String nom2){
		this.terrain = new Terrain(10,10);
		this.selectionJoueur(1, nom1);
		this.selectionJoueur(2, nom2);
	}
	public Joueur getJ(int i) {
		if (i==1) {
			return j1;
		}else{
			return j2;
		}
	}
	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public void ajouterUnite(Joueur j) {
		
//		if (super.getNbCombat()>=soldat & super.getDispoRecherche()>=recherche ){
//			for (int i=0; i<soldat ;i++) {
//				UniteCombat u = new UniteCombat();
//				this.armee.addUnite(u);
//			}
//			for (int i=soldat; i<soldat+recherche ;i++) {
//				UniteRecherche u = new UniteRecherche();
//				this.armee.addUnite(u);
//			} 
//		}
	}
	
	public Collection<String> listeSauvegarde (){

		String [] liste;
		ArrayList<String> nom = new ArrayList<String>();
		File rep = new File("./SAVE/");
		liste=rep.list();
		for(int i=0;i<liste.length;i++){ 
			nom.add(liste[i]);
		}
		return nom;
	}
	
	public void selectionJoueur (int i , String nom) {
		Joueur j = new Joueur(nom);
		if(i==1) {
			this.setJ1(j);
		}else {
			this.setJ2(j);
		}
	}
	public void selectionUnité (int i, int u1, int u2) {
		Joueur j =null;
		if (i==1) {
			j = this.j1;
		}else if(i==2) {
			j = this.j2;
		}
		if (u1<=j.getDispoCombat() && u2<=j.getDispoRecherche()) {
			for(int t=0;t<u1;t++) {
				UniteCombat uc = new UniteCombat(i);
				this.terrain.addObject(uc);
			}
			for(int t=0;t<u2;t++) {
				UniteRecherche ur = new UniteRecherche(i);
				this.terrain.addObject(ur);
			}
		}
	}
	
}