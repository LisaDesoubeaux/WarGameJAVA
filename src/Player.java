import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable  {

// Attributes
	public String nom;
	public int nb_soldats = 1;
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
}
