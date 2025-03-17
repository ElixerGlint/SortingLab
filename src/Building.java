import java.awt.Color;
import java.awt.Graphics;

public class Building { //IMPLEMENTS COMPARABLE
	private int x, y;
	private Color c;
	private int height;
	private int width;

	public Building() {//fits 1000x800 screen
		x = 0;
		y = 350;
		c = Color.black;
		height = 300;
		width = 100;
	}

	public Building(Color col, int h, int w) {//fits 1000x800 screen
		x = 0;
		y = 650;
		c = col;
		height = h;
		width = w;
	}

	

	public void drawPiece(Graphics g) {
		g.setColor(c); //set background color
		g.fillRect(x, y, width, height);
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