
public class Unite extends ObjetTerrain {
	
// Attributes
	private int joueur;
	private int pv;
	private int deplacementMax;
	private int defence;
	
	public int getJoueur() {
		return joueur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public Unite(int j) {
		this.setJoueur(j);
		this.pv=20;
		this.deplacementMax=4;
		this.defence=3;
	}
	
// Getter - Setter
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getDeplacementMax() {
		return deplacementMax;
	}
	public void setDeplacementMax(int deplacementMax) {
		this.deplacementMax = deplacementMax;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	
	
}
