import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Joueur implements Serializable{

	private String nom;
	private int nbCombat;
	private int nbVictoire;
	private int dispoCombat;
	private int dispoRecherche; 
	private Ressource res;

// Getter - Setter
	public String getNom() {
		return nom;
	}
	public void setNom(String nom ) {
		this.nom = nom;
	}
	public int getNbCombat() {
		return nbCombat;
	}
	public void setNbCombat(int nbCombat) {
		this.nbCombat = nbCombat;
	}
	public int getNbVictoire() {
		return nbVictoire;
	}
	public void setNbVictoire(int nbVictoire) {
		this.nbVictoire = nbVictoire;
	}
	public int getDispoCombat() {
		return dispoCombat;
	}
	public void setDispoCombat(int dispoCombat) {
		this.dispoCombat = dispoCombat;
	}
	public int getDispoRecherche() {
		return dispoRecherche;
	}
	public void setDispoRecherche(int dispoRecherche) {
		this.dispoRecherche = dispoRecherche;
	}
	public Ressource getRes() {
		return res;
	}
	public void setRes(Ressource res) {
		this.res = res;
	}
	
// Constructors
	public Joueur() {}
	
	
	public Joueur(String nom) { // NewUser
		Boolean isnew = this.isNew(nom);
		if (isnew) {
			this.init(nom);
		}else{
			try {
				this.load(nom);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String asString() {
		String s = "nom : "+ this.nom + "\n combat : \n"+ this.nbCombat;
		return s;
	}
	
	public boolean isNew(String nom) {
		boolean isnew = true;
		File rep = new File("./SAVE/");
		String[] liste  = rep.list();
		int i =0;
		while(isnew & (i<liste.length)) {
			if(liste[i].equals(nom)) {
				isnew=false;
			}
			i++;
		}
		return isnew;
	}
	
	public void init (String nom) {
		this.nom=nom;
		this.nbCombat =0;
		this.nbVictoire=0;
		this.dispoCombat = 0;
		this.dispoRecherche = 0;
		this.res = new Ressource();
	}
	
	public void save () throws IOException{
		String f = "./SAVE/"+this.nom;
		FileOutputStream w = new FileOutputStream(f,false);
		ObjectOutputStream o = new ObjectOutputStream(w);
		o.writeObject(this);
		o.close();
		w.close();
	}
	
	public void load(String nom) throws IOException, ClassNotFoundException{
		Joueur j = new Joueur();
		FileInputStream r = new FileInputStream("./SAVE/"+nom); 
		ObjectInputStream o = new ObjectInputStream(r); 
		Object lu = o.readObject(); 
		j = (Joueur)lu;
		this.nom = j.nom;
		this.nbCombat = j.nbCombat;
		this.nbVictoire = j.nbVictoire;
		this.dispoCombat = j.dispoCombat;
		this.dispoRecherche = j.dispoRecherche;
		this.res = j.res;
		o.close(); 
		r.close();
	}	
	
}
