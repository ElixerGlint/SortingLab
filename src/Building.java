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

}