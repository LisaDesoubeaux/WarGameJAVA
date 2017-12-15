
public class UniteCombat extends Unite  {
	
// Attributes
//	private String type;
	private int forceAttaque;
	private int portee;
	
	public UniteCombat(int j) {
		super(j);
		this.forceAttaque = 5;
		this.portee = 2;
	}
// Getter - Setter
	public int getForceAttaque() {
		return forceAttaque;
	}
	public void setForceAttaque(int forceAttaque) {
		this.forceAttaque = forceAttaque;
	}
	public int getPortee() {
		return portee;
	}
	public void setPortee(int portee) {
		this.portee = portee;
	}

// Initialization
	public void initBase() {
		super.setPv(20);
		super.setDeplacementMax(2);
		super.setDefence(5);
		this.forceAttaque = 6;
		this.portee = 3; 
	}
	
	public String asString() {
		String s = "pv"+super.getPv()+"\nF attaque"+this.forceAttaque+"\nPortée"+this.portee;
		return s;
	}


	
	
}
