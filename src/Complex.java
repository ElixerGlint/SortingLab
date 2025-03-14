import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Complex extends JPanel {
    private Building[] buildings;

	public Complex() {
		buildings = new Building[10];
		for(int i=0; i<buildings.length; i++) {
			buildings[i] =  new Building(); //makes all buildings
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		printbackgroup(g);
		//for(Building b: buildings) {
		//	b.drawPiece(g);
		//}
	}

	public void printbackgroup(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 650, 1000, 150);
		g.setColor(Color.black);
		for(int i = 0; i < 32; i++) {
			g.fillRect(30*i + 20, 700, 15, 5);
		}
	}

}