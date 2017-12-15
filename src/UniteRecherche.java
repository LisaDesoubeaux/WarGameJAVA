
public class UniteRecherche extends Unite{

// Attributes
	private Ressource recupere;

// Getter - Setter
	public Ressource getRecupere() {
		return recupere;
	}

	public void setRecupere(Ressource recupere) {
		this.recupere = recupere;
	}
	
	public UniteRecherche(int j) {
		super(j);
		recupere = new Ressource();
	}

// Initialization 
	public void init() {
		super.setPv(20);
		super.setDeplacementMax(5);
		super.setDefence(8);
	}
	
	
}
