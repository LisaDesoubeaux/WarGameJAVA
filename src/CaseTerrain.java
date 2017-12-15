public class CaseTerrain {
// Attributes
	private int posX;
	private int posY;
	private boolean empty;
	private String col;
// Constructor	
	public CaseTerrain(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.empty = true;
	}
// Getter - Setter
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
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
// Other methods
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}

	
	
	
	
}
