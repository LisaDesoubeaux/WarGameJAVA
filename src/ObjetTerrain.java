
public class ObjetTerrain {
	
	private int posX = 0;
	private int posY = 0;
	
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void deplacement(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
}
