import java.awt.Color;

import java.awt.Graphics;



public class Piece { //IMPLEMENTS COMPARABLE

	private int x, y;

	private Color c;

	private double angle;

	public Piece() {//fits 1000x800 screen
		x = (int) (Math.random()*900);
		y = (int) (Math.random()*700);
		angle = Math.random()*(320)+40;
		c = Color.orange;
	}

	

	public void drawPiece(Graphics g) {
		g.setColor(c); //set background color
		g.fillArc(x, y, 100, 100, 0, (int) angle);
	}

}