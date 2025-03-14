import java.awt.Graphics;
import javax.swing.JPanel;

public class Complex extends JPanel {
    private Building[] slices;

	public Complex() {
		slices = new Building[10];
		for(int i=0; i<slices.length; i++) {
			slices[i] =  new Building(); //makes all slices
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Building p: slices) {
			p.drawPiece(g);
		}
	}



}