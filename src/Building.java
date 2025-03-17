import java.awt.Color;
import java.awt.Graphics;

public class Building implements Comparable { //IMPLEMENTS COMPARABLE
	private int x, y;
	private Color c;
	private int height;

	public Building() {//fits 1000x800 screen
		x = 0;
		y = 350;
		c = Color.black;
		height = 300;
	}

	public Building(Color col, int h) {//fits 1000x800 screen
		x = 0;
		y = 650;
		c = col;
		height = h;
	}

	public void drawPiece(Graphics g) {
		g.setColor(c); //set background color
		g.fillRect(x, y, 70, height);
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

	@Override
	public int compareTo(Object o) {
        //class cast exception error in the case that a "cat" is casted into a dog without being able to
        Building d = (Building)(o);
        
        return height - d.getHeight();
    }

	
}