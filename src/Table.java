import java.awt.Graphics;
import javax.swing.JPanel;

public class Table extends JPanel {
    private Piece[] slices;

	public Table() {
		slices = new Piece[10];
		for(int i=0; i<slices.length; i++) {
			slices[i] =  new Piece(); //makes all slices
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Piece p: slices) {
			p.drawPiece(g);
		}
	}



}