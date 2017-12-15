
public class Base extends ObjetTerrain {
	
	private int pv;
	private Joueur j;
	
	public Base (int x , int y) {
		super.setPosX(x);
		super.setPosY(y);
		this.pv = 10;
	}
// Getter - Setter
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	
	
}
