import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Terrain {
	
	private int hauteur;
	private int largeur;
	private ArrayList<CaseTerrain> cases;
	private ArrayList<ObjetTerrain> objects;
	
	
	public Terrain(int h, int l) {
		this.hauteur = h;
		this.largeur = l;
		this.cases = new ArrayList<CaseTerrain>();
		for (int i = 0 ; i <= l;i++) {
			for(int j = 0 ; j <= h;j++) {
				CaseTerrain c = new CaseTerrain(i,j);
				this.cases.add(c);
			}
		}
		this.objects = new ArrayList<ObjetTerrain>();
	}
	
	
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public void setObjects(ArrayList<ObjetTerrain> objects) {
		this.objects = objects;
	}
	public ArrayList<ObjetTerrain> getObjects() {
		return objects;
	}
	public ArrayList<CaseTerrain> getCases() {
		return cases;
	}
	public void setCases(ArrayList<CaseTerrain> cases) {
		this.cases = cases;
	}
	
	public CaseTerrain rechercheCase(int x , int y) {
		Iterator<CaseTerrain> it = this.cases.iterator();
		CaseTerrain c = null;
		while (it.hasNext()) {
			c = it.next();
			if(c.getPosX()==x & c.getPosY()==y) {
				break;
			}else {
				c = null;
			}
		}
		return c;
	}
	public void addObject (ObjetTerrain o) {
		CaseTerrain c = this.rechercheCase(o.getPosX(),o.getPosY());
		if(c.isEmpty()) {
			this.objects.add(o);
			c.setEmpty(false);
		}
	}
	
	public ObjetTerrain rechercheObject(int x, int y , String type) {
		Iterator<ObjetTerrain> it = this.objects.iterator();
		ObjetTerrain o = null;
		while(it.hasNext()) {
			o = it.next();
			if((o.getPosX()==x) & (o.getPosY()==y) & (o.getClass().getName()== type)) {
				break;
			}else {
				o=null;
			}
		}
		return o;
	}
	
	
	public void deplaceObject(int x , int y , ObjetTerrain o) {
		CaseTerrain c = this.rechercheCase(x, y);
		if (c.isEmpty()) {
			o.setPosX(x);
			o.setPosY(y);
			c.setEmpty(false);
		}
	}
	
	public void deplacementPossible(int d, int x , int y){
		CaseTerrain o;
		for (int i = x-d; i<= x+d ;i++) {
			for(int j = y-d;j<=y+d ;j++) {
				o= this.rechercheCase(i, j);
				o.setCol("rouge");
			}
		}
	}
	
	public void attaquePossible(int p, int x , int y){
		CaseTerrain c;
		for (int i = x-p; i<= x+p ;i++) {
			for(int j = y-p;j<=y+p ;j++) {
				c=this.rechercheCase(i, j);
				if (!c.isEmpty()) {
					ObjetTerrain o = this.rechercheObject(x, y, "UniteCombat");
					if (o==null) {
						o = this.rechercheObject(x, y, "UniteRecherche");
					}
					if(o!=null) {
						c.setCol("rouge");
					}
				}
			}
		}
	}
	
	public void print() {
		CaseTerrain c;
		for(int j =1 ; j<this.hauteur ; j++) {
			String ligne = "";
			for(int i =1 ; i<this.largeur ; i++) {
				c=this.rechercheCase(i, j);
				if (c.isEmpty()) {
					ligne = ligne+" _";
				}else{
					ligne = ligne+" *";
				}
			}
			System.out.println(ligne);
		}
	}
	
	public GridPane printFX() {
		GridPane g = new GridPane();
		CaseTerrain c;
		Unite o;
		for(int j =1 ; j<=this.hauteur ; j++) {
			for(int i =1 ; i<=this.largeur ; i++) {
				c=this.rechercheCase(i, j);
				StackPane s = new StackPane();
				s.setPrefSize(50, 50);
				s.setStyle("-fx-border-color: lightgrey ;-fx-background-color:white");
				if (!c.isEmpty()) {
					o = (Unite) this.rechercheObject(i, j, "UniteCombat");
					if (o==null) {
						o = (Unite)this.rechercheObject(i, j, "UniteRecherche");
					}
					if (o!=null) {
						if (o.getJoueur()==1) {
							s.setStyle("-fx-border-color: blue;");
						}else {
							s.setStyle("-fx-border-color: red;");
						}
					}
				}
				GridPane.setConstraints(s,i,j);
				g.getChildren().add(s);
			}
		}
		return g;
	}
	
}
