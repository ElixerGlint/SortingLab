import java.awt.Color;
import java.awt.Graphics;

public class Building { //IMPLEMENTS COMPARABLE
	private int x, y;
	private Color c;
	private int height;

	public Building() {//fits 1000x800 screen
		x = 0;
		y = 500;
		c = Color.black;
		height = 300;
	}

	

	public void drawPiece(Graphics g) {
		g.setColor(c); //set background color
		g.fillRect(x, y, 100, height);
	}

	//getters and setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
}