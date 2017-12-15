import java.io.Serializable;

@SuppressWarnings("serial")
public class Ressource implements Serializable {

// Attributes
	private int petrole = 0;
	private int or = 0;
	private int argent = 0;

// Getter - Setter
	public int getPetrole() {
		return petrole;
	}
	public void setPetrole(int petrole) {
		this.petrole = petrole;
	}
	public int getOr() {
		return or;
	}
	public void setOr(int or) {
		this.or = or;
	}
	public int getArgent() {
		return argent;
	}
	public void setArgent(int argent) {
		this.argent = argent;
	}

	public String asString() {
		String s ="p :"+this.petrole+" - p :"+this.or+" - a :"+this.argent;
		return s;
	}
}
