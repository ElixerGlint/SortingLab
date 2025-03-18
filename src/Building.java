import java.awt.Color;
import java.awt.Graphics;

public class Building implements Comparable { //IMPLEMENTS COMPARABLE
	private int x, y;
	private int height;

	public Building() {//fits 1000x800 screen
		x = 0;
		y = 350;
		height = 300;
	}

	public Building(int h) {//fits 1000x800 screen
		x = 0;
		y = 650;
		height = h;
	}

	public void drawPiece(Graphics g, Color c) {
		g.setColor(c); //set background color
		g.fillRect(x, y, 10, height); //70 normally, NEEDS TO BE SCALED
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