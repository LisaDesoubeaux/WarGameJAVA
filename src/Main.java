import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
	
	public static Player p1;
	public static Player p2;

	public static void main(String[] args) {
		p1 = new Player();
		p1.nom = "Lisa";
		try {
			p1.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("sauvegarde ok ");
		try {
			p2 = load_backup(p1.nom);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(p2.nom);
		
;
	}
	
	// loads a player from a backup file
	public static Player load_backup (String f) throws IOException, ClassNotFoundException{
		Player j;
		FileInputStream r = new FileInputStream("./SAVE/"+f); 
		ObjectInputStream o = new ObjectInputStream(r); 
		Object lu = o.readObject(); 
		j = (Player)lu;
		o.close(); 
		r.close(); 
		return j;
	}

}
