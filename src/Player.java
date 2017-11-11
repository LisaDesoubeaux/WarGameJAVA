import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable  {

// Attributes
	public String nom;
	public int nb_soldats = 0;
	public int nb_or = 1;
	public int nb_argent = 1;
	public int nb_petrole = 1;
	
// Getter / Setter Methods
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNb_soldats() {
		return nb_soldats;
	}
	public void setNb_soldats(int nb_soldats) {
		this.nb_soldats = nb_soldats;
	}
	public int getNb_or() {
		return nb_or;
	}
	public void setNb_or(int nb_or) {
		this.nb_or = nb_or;
	}
	public int getNb_argent() {
		return nb_argent;
	}
	public void setNb_argent(int nb_argent) {
		this.nb_argent = nb_argent;
	}
	public int getNb_petrole() {
		return nb_petrole;
	}
	public void setNb_petrole(int nb_petrole) {
		this.nb_petrole = nb_petrole;
	}

// Constructors
	public Player() {
	}

	public Player(String nom) {
		this.nom = nom;
	}

// Other Methods
	

	// Save
	public void save () throws IOException{
		String f = "./SAVE/"+this.nom;
		FileOutputStream w = new FileOutputStream(f,false);
		ObjectOutputStream o = new ObjectOutputStream(w);
		o.writeObject(this);
		o.close();
		w.close();
	}
	//Load
	public  void load_backup (String f) throws IOException, ClassNotFoundException{
		Player p = new Player();
		FileInputStream r = new FileInputStream("./SAVE/"+f); 
		ObjectInputStream o = new ObjectInputStream(r); 
		Object lu = o.readObject(); 
		p = (Player)lu;
		this.nom = p.nom;
		this.nb_soldats = p.nb_soldats;
		this.nb_or = p.nb_or;
		this.nb_argent = p.nb_argent;
		this.nb_petrole = p.nb_petrole;
		o.close(); 
		r.close(); 
	}
	// Print
	public String asString () {
		String s = " nom : "+this.nom+"\n soldats :"+this.nb_soldats+"\n or :"
				+this.nb_or+"\n argent :"+this.nb_argent+"\n petrole :"+this.nb_petrole+"\n";
		return s;
	}
}
