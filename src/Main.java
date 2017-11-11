import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
	
	public static Player p1;
	public static Player p2;

	public static void main(String[] args) {
		
		test();
;
	}
	
	public static void test() {
		p1 = new Player("Lisa");
		System.out.println(p1.asString());
		p2 = new Player();
		try {
			p1.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("sauvegarde ok ");
		try {
			p2.load_backup(p1.nom);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(p2.nom);
	}
	
	// select players

}
